<!--
 * @Author: your name
 * @Date: 2021-07-27 21:29:18
 * @LastEditTime: 2021-07-27 21:40:16
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: \MarkDown\Emma.md
-->
# simbot Demo - Mirai

## 注意
>- 本仓库是本人照搬了一个demo
>- 本人自己学习编写的插件将会放在*src/main/java/love/simbot/example/text*中

### 自行编写目前已实现的功能
>- 私聊机器人，控制台输出**芜湖起飞**，并复读
>- 在群内发送hi、mua，机器人复读


## 以下为原内容
这是[simple-robot](https://github.com/ForteScarlet/simpler-robot) 框架使用[mirai组件](https://github.com/ForteScarlet/simpler-robot/tree/dev/component/component-mirai) 对接[Mirai](https://github.com/mamoe/mirai) 的Demo项目。

## 需要做的
### fork/clone
fork或者clone此项目到你的本地，并使用IDE工具打开并构建它。

### 修改配置文件
打开文件 [simbot.yml](src/main/resources/simbot.yml) 并修改其中的 `simbot.core.bots` 项为你测试用的QQ账号，例如：
```yaml
simbot: 
  core:
    bots: 123456789:password 
```

### 保证安静
将你的bot放在一些测试用的群而不是一些大型群。 

### 阅读
- [listener](src/main/java/love/simbot/example/listener) 包下为一些监听函数示例。阅读它们的注释，并可以试着修改它们。

### 运行
执行[SimbotExampleApplication](src/main/java/love/simbot/example/SimbotExampleApplication.java) 中的main方法。

### 验证
如果你是第一次使用此框架，且出现了诸如需要“滑动验证”等相关错误，你可以尝试先使用一次 [simbot-mirai-login-solver-selenium-helperPack](https://github.com/simple-robot/simbot-mirai-login-solver-selenium-helperPack) 来使腾讯记住你的设备信息。

以及，记得关闭账号中与“设备锁”、“安全保护”等相关内容。

### 协助
如果你有一个好的示例点子，你可以通过[github pr](https://github.com/simple-robot/simbot-mirai-demo/pulls) 来协该框架下demo项目的更新。

