package com.xm.api_mall.message;

import com.alibaba.fastjson.JSONObject;
import com.rabbitmq.client.Channel;
import com.xm.comment_mq.message.AbsMessageReceiver;
import com.xm.comment_mq.message.config.UserActionConfig;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * 监听用户动态
 */
@Component
public class UserMessageReceiver extends AbsMessageReceiver {

    @RabbitListener(bindings = @QueueBinding(
            exchange = @Exchange(value = UserActionConfig.EXCHANGE, type = UserActionConfig.EXCHANGE_TYPE),
            value = @Queue(UserActionConfig.QUEUE_MALL)
    ))
    @Override
    public void onMessage(JSONObject jsonMessage, Channel channel, Message message) throws IOException {
        super.onMessage(jsonMessage, channel, message);
    }

}
