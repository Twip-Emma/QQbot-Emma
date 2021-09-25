package love.simbot.example;

import love.forte.common.configuration.Configuration;
import love.forte.simbot.annotation.SimbotApplication;
import love.forte.simbot.api.sender.BotSender;
import love.forte.simbot.bot.Bot;
import love.forte.simbot.core.SimbotApp;
import love.forte.simbot.core.SimbotContext;
import love.forte.simbot.core.SimbotProcess;
import org.jetbrains.annotations.NotNull;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * simbot 启动类。
 * <p>
 * 此处的注解配置了两个配置文件：
 * <ul>
 *     <li>simbot.yml</li>
 *     <li>simbot-dev.yml</li>
 * </ul>
 * 其中，{@code simbot-dev.yml} 是一个测试环境的配置文件，只有当启动参数中存在 {@code --Sdev} 的时候才会被使用。
 * 如果你不需要一些特殊的配置文件，那么可以直接使用 {@code @SimbotApplication}.
 * <p>
 * 默认情况下，默认的配置文件名称为 {@code simbot.yml} 或 {@code simbot.properties}
 *
 * @author ForteScarlet
 */
@SimbotApplication
// @SimbotApplication
public class SimbotExampleApplication implements SimbotProcess {
    private static Map<String,Object> BOT_CONFIG = new LinkedHashMap<>();

    static {
           BOT_CONFIG.put("MasterQQ","1157529280");
    }

    public static void main(String[] args) {
        /*
            run方法的第一个参数是一个标注了@SimbotApplication注解的启动类。
            第二个参数是main方法得到的启动参数。
         */
        SimbotApp.run(SimbotExampleApplication.class, args);
    }

    @Override//启动后执行
    public void post(@NotNull SimbotContext context) {
        Bot bot = context.getBotManager().getDefaultBot();
        BotSender sender = bot.getSender();

        String loginTime = new SimpleDateFormat("yyyy年MM月dd日：hh时mm分ss秒").format(new Date());
        sender.SENDER.sendPrivateMsg((String) BOT_CONFIG.get("MasterQQ"),"启动成功！\n" + loginTime);
    }

    @Override//启动前执行
    public void pre(@NotNull Configuration config) {

    }
}
