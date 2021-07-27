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

    @OnPrivate
    public void privateMsg(PrivateMsg privateMsg, MsgSender sender) {
        sender.SENDER.sendPrivateMsg(privateMsg, privateMsg.getMsgContent());
        System.out.println("芜湖起飞");
    }

    @OnGroup
    @Filter(value = "hi", matchType = MatchType.STARTS_WITH)
    public void groupMsg(GroupMsg groupMsg, MsgSender sender) {
        sender.SENDER.sendGroupMsg(groupMsg, groupMsg.getMsgContent());
    }
}
