package love.simbot.example.text;

import catcode.CatCodeUtil;
import love.forte.common.ioc.annotation.Beans;
import love.forte.common.ioc.annotation.Depend;
import love.forte.simbot.annotation.Filter;
import love.forte.simbot.annotation.OnPrivate;
import love.forte.simbot.api.message.MessageContent;
import love.forte.simbot.api.message.MessageContentBuilder;
import love.forte.simbot.api.message.MessageContentBuilderFactory;
import love.forte.simbot.api.message.events.PrivateMsg;
import love.forte.simbot.api.sender.MsgSender;
import love.forte.simbot.api.sender.Sender;
import love.forte.simbot.filter.MatchType;

@Beans
public class ImageHandler {
    private static final String IMG_PATH_1 = "D:\\PS\\成品\\蓝蝶.jpg";

    @Depend
    private MessageContentBuilderFactory messageContentBuilderFactory;

    @OnPrivate//第一种方法发送图片
    @Filter(value = "图一", matchType = MatchType.CONTAINS)
    public void ImageSender1(PrivateMsg msg, MsgSender sender){
        //获取猫猫码工具
        CatCodeUtil util = CatCodeUtil.INSTANCE;

        //三种方法构建猫猫码
        String img1 = util.toCat("image",true,"file=" + IMG_PATH_1);
        String img2 = util.getStringTemplate().image(IMG_PATH_1);
        String img3 = util.getStringCodeBuilder("image", true).key("file").value(IMG_PATH_1).build();

        sender.SENDER.sendPrivateMsg(msg.getAccountInfo().getAccountCode(), img1);
        sender.SENDER.sendPrivateMsg(msg.getAccountInfo().getAccountCode(), img2);
        sender.SENDER.sendPrivateMsg(msg.getAccountInfo().getAccountCode(), img3);
    }

    @OnPrivate//第二种方法发送图片
    @Filter(value = "图二", matchType = MatchType.CONTAINS)
    public void ImageSender2(PrivateMsg msg, MsgSender sender){
        //获取消息正文构建器
        MessageContentBuilder builder = messageContentBuilderFactory.getMessageContentBuilder();

        //构建消息正文
        MessageContent build = builder.text("这是构建工厂做出来的图片：").image(IMG_PATH_1).build();

        sender.SENDER.sendPrivateMsg(msg.getAccountInfo().getAccountCode(), build);
    }
}
