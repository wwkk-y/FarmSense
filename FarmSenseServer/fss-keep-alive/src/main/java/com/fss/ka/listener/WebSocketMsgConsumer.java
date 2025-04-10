package com.fss.ka.listener;

import cn.hutool.json.JSONUtil;
import com.fss.ka.service.WebSocketService;
import com.fss.common.constant.KeepAliveConst;
import com.fss.common.constant.RocketMQConst;
import com.fss.common.util.RocketMQLogListener;
import com.fss.ka.vo.WebSocketToMQConsumerMsg;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.springframework.stereotype.Component;

@Component
@RocketMQMessageListener(
        topic = KeepAliveConst.WEBSOCKET_MSG_TOPIC,
        consumerGroup = "websocket-msg-consumer-group",
        maxReconsumeTimes = RocketMQConst.RECONSUME_TIMES
)
public class WebSocketMsgConsumer extends RocketMQLogListener {

    @Override
    public void onLogMessage(MessageExt messageExt) {
        // TODO
        String body = new String(messageExt.getBody());
        WebSocketToMQConsumerMsg msg = JSONUtil.toBean(body, WebSocketToMQConsumerMsg.class);
        if(msg.isBroadcast()){
            // 广播消息
            WebSocketService.broadcastMessageToClient(msg.getMsg());
        } else {
            // 非广播消息
            msg.getUserIds().forEach(uid -> {
                WebSocketService.sendMessageToClient(msg.getMsg(), uid);
            });
        }
    }
}
