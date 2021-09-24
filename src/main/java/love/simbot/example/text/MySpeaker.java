package love.simbot.example.text;

import love.forte.common.ioc.annotation.Beans;
import love.forte.simbot.annotation.Listen;
import love.forte.simbot.annotation.Listens;
import love.forte.simbot.annotation.OnGroup;
import love.forte.simbot.api.message.containers.AccountInfo;
import love.forte.simbot.api.message.containers.GroupInfo;
import love.forte.simbot.api.message.events.GroupMsg;
import love.forte.simbot.api.message.events.MsgGet;
import love.forte.simbot.api.message.events.PrivateMsg;
import love.forte.simbot.api.sender.Sender;
import love.forte.simbot.constant.PriorityConstant;

@Beans
public class MySpeaker {

    @Listens(value = {
            @Listen(PrivateMsg.class),
            @Listen(GroupMsg.class)},
            priority = PriorityConstant.FIRST, name = "mySpeaker1"
    )
    public void testListener1(MsgGet msg, Sender sender){
        String messageContent = msg.getText();
        if(messageContent.contains("你好")){
            System.out.println("你好~");
        }
    }


    @OnGroup
    public void testListener2(GroupMsg groupMsg, Sender sender){
        String message = groupMsg.getText();//获取消息文本


        AccountInfo accountInfo = groupMsg.getAccountInfo();//获取发送者对象
        String userId = accountInfo.getAccountCode();//获取发送者QQ号
        String userName = accountInfo.getAccountNickname();//获取发送者昵称

        GroupInfo groupInfo = groupMsg.getGroupInfo();
        String groupId = groupInfo.getGroupCode();
        String groupName = groupInfo.getGroupName();

        String sendMessage = userName + "(" + userId + ")发了一条消息：\n";
        sendMessage += "在群" + groupName + "(" + groupId + ")\n";
        sendMessage += message;

        if(groupId.equals("274733672")){
            System.out.println(sendMessage);
            sender.sendGroupMsg(groupId,sendMessage);
        }else{
            System.out.println("阿巴啊吧");
        }

    }
}
