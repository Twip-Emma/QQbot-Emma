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
        System.out.println("芜湖起飞");
    }

    @OnGroup//模板注解监听群聊消息
    @Filter(value = "hi", matchType = MatchType.STARTS_WITH)
    @Filter(value = "mua", matchType = MatchType.STARTS_WITH)
    public void groupMsg(GroupMsg groupMsg, MsgSender sender) {
        sender.SENDER.sendGroupMsg(groupMsg, groupMsg.getMsgContent());
    }


}
