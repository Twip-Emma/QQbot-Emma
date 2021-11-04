package love.simbot.example.text;

import love.forte.common.ioc.annotation.Beans;
import love.forte.simbot.annotation.*;
import love.forte.simbot.api.message.events.GroupMsg;
import love.forte.simbot.api.message.events.PrivateMsg;
import love.forte.simbot.api.sender.MsgSender;
import love.forte.simbot.constant.PriorityConstant;
import love.forte.simbot.filter.MatchType;


@Beans
public class MyListener {

    @OnPrivate//模板注解监听私聊消息
    public void privateMsg(PrivateMsg privateMsg, MsgSender sender) {
        sender.SENDER.sendPrivateMsg(privateMsg, privateMsg.getMsgContent());
    }

    @OnPrivate//模板注解监听群聊消息
    @Filter(value = "亲亲", trim = true, matchType = MatchType.CONTAINS)
    @Filter(value = "mua", trim = true, matchType = MatchType.CONTAINS)
    public void groupMsg(PrivateMsg privateMsg, MsgSender sender) {
        sender.SENDER.sendPrivateMsg(privateMsg, "亲亲~");
    }

    @OnPrivate//模板注解监听群聊消息
    @Filter(value = "测试", trim = true, matchType = MatchType.CONTAINS)
    public void groupMsg2(PrivateMsg privateMsg, MsgSender sender) {
        sender.SENDER.sendPrivateMsg(privateMsg, "这是测试结果~");
    }
}
