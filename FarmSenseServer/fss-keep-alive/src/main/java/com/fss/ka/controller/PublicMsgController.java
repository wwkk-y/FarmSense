package com.fss.ka.controller;

import cn.hutool.json.JSONUtil;
import com.fss.common.api.RResult;
import com.fss.common.constant.KeepAliveConst;
import com.fss.common.util.RocketMQSendUtil;
import com.fss.common.vo.KaMsgSendVo;
import com.fss.ka.vo.WebSocketToClientMsg;
import com.fss.ka.vo.WebSocketToMQConsumerMsg;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
@RequestMapping("/public/msg")
public class PublicMsgController {

    @Resource
    private RocketMQSendUtil rocketMQSendUtil;

    @PostMapping("/send")
    public RResult<Boolean> send(@Valid @RequestBody KaMsgSendVo msgSendVo){
        WebSocketToMQConsumerMsg msg = new WebSocketToMQConsumerMsg();
        msg.setUserIds(msgSendVo.getUserIds());
        msg.setBroadcast(false);
        // 封装成发送给客户端的消息
        msg.setMsg(WebSocketToClientMsg.builder().path(msgSendVo.getPath()).body(msgSendVo.getBody()).build());
        // 往mq发消息 集群消费
        rocketMQSendUtil.asyncSend(KeepAliveConst.WEBSOCKET_MSG_TOPIC, JSONUtil.toJsonStr(msg));
        return RResult.success(true);
    }

}
