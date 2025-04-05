package com.fss.cms.service;

import com.alibaba.nacos.shaded.com.google.common.collect.Lists;
import com.fss.cms.vo.MessageQueryVo;
import com.fss.cms.vo.MessageSendVo;
import com.fss.cms.vo.UserOfConversationVo;
import com.fss.cms.mapper.MessageMapper;
import com.fss.common.api.RCode;
import com.fss.common.api.RException;
import com.fss.security.dao.UmsUserDao;
import com.fss.security.util.AccountUtil;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import javax.validation.Valid;

@Service
@Validated
@Slf4j
public class MessageService {

    @Resource
    private MessageMapper messageMapper;
    @Resource
    private AccountUtil accountUtil;
    @Resource
    private MsgNoticeService msgNoticeService;

    @Transactional(rollbackFor = Exception.class)
    public MessageQueryVo sendMsg(@NonNull @Valid MessageSendVo msg){
        // 用户id
        UmsUserDao account = accountUtil.getCurAccount();
        if(account == null){
            throw new RException(RCode.UNAUTHORIZED);
        }
        msg.setSenderId(account.getId());

        // 1.插入新消息
        messageMapper.newMessage(msg);
        MessageQueryVo ans = messageMapper.queryMsgById(msg.getId());

        // 2 更新会话最后一条消息id
        messageMapper.setLastMsgOfConversation(msg.getId(), msg.getConversationId());

        // 3.查询会话其它成员
        UserOfConversationVo users = messageMapper.queryUserOfConversation(ans.getConversationId());
        long otherUid = users.getUserId1();
        if(otherUid == account.getId()){
            otherUid = users.getUserId2();;
        }

        // 3.1 生成未读消息
        messageMapper.newUnreadMessage(msg.getId(), otherUid);

        // 3.2 发送通知 新消息通知 不但给对方发，也给自己发，考虑同一个用户在线多台设备的场景
        msgNoticeService.sendChatMsgToUser(Lists.newArrayList(users.getUserId1(), users.getUserId2()), ans);

        return ans;
    }

    /**
     * 清除未读消息
     */
    public void clearUnreadMsg(long conversationId, long uid) {
        messageMapper.clearUnreadMsg(conversationId, uid);
    }
}
