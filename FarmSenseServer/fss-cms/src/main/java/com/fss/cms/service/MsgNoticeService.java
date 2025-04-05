package com.fss.cms.service;

import cn.hutool.json.JSONUtil;
import com.fss.cms.feign.FssKaFeign;
import com.fss.cms.vo.MessageQueryVo;
import com.fss.common.vo.KaMsgSendVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MsgNoticeService {
    @Resource
    private FssKaFeign fssKaFeign;

    /**
     * 发送聊天信息给用户
     */
    public void sendChatMsgToUser(List<Long> userIds, MessageQueryVo msg){
        KaMsgSendVo kaMsgSendVo = new KaMsgSendVo();
        kaMsgSendVo.setUserIds(userIds);
        kaMsgSendVo.setPath("/notice/msg/chat"); // FIXME
        kaMsgSendVo.setBody(JSONUtil.toJsonStr(msg));
        fssKaFeign.send(kaMsgSendVo);
    }
}
