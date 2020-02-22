#wqwy-zhnm project
1. 描述:  智慧农贸 小程序电商平台 

  线上下单，线下配送的电商平台。 产品是农贸市场商户提供的商品，以客户提供地址为基准，场覆盖附近农贸市3公里范围内配送。
  小程序搜索“罗老板在线”  可以看到小程序的商城效果.    
  从表面上看不出是个多店系统， 商城的商品，其实是由农贸市场的多个商家提供的 ，采用抢单模式+拼单模式，一个单子可能是由多个商家协同供货的 。


2. 架构1: 
    - api -> 后台接口相关项目
        - mallapp -> 接口用户端(小程序)
        - mallseller -> 接口商户端
        - malldelivery -> 接口配送端
        - mallbase-entity -> entity
        - mallbase-dao -> dao
        - mallbase-service -> service
        - mallbase-component -> component
    - backend -> 后台管理系统相关
        - mallweb -> 后台管理系统
>其中 api 项目为接口相关项目的父项目，
>api下的mallapp mallseller malldelivery 为 3个单独的子项目
>mallbase-*为基类项目
>mallweb 为单独的子项目
>> 基类项目的功能通过名称自解释




3. 架构2:
    - maven: api以及mallweb均为maven项目
    - spring-boot: api中的所有子项目均为独立的spring-boot项目
    
4. 环境:
    - java: jdk8+
    - maven: 3.5.2(测试环境下)
    - spring-boot: 2.0.0.RC1+
    
5. 已有的第三方依赖(非官方)
    
     请替换 appid ,APPSECRET...为自己的 

    - aliyun
        - aliyun短信支持
        - aliyun oss支持
    - wechat
        - 微信支付， 
        - mallapp 获取用户信息
    - geode
        - 地理编码
        - 云图检索
        
6. 运行:
    `由于api下的项目均为spring-boot项目，故可以通过main方法直接运行本地调试，启动时可添加参数由开发人员自行配置 e.g.:`
    - mallapp mallseller malldelivery可以通过: 
    `nohup java -jar xx.jar -parameter1 value1...&` 达到项目启动效果
    - mallweb:
    `mallweb 为传统 java项目(springMVC mybatis jsp) 项目架构与其他项目有部分区别，由于通过maven修改了启动选项 项目中集成了tomcat，项目启动命令与其他项目基本相同，但仍然需要手动设置项目port e.g.:`
    `nohup java -jar xx.war -httpPort 9091 ...`
    
7. 开发&测试:
    在api下的mallseller malldelivery 2个端现已集成了Junit mock测试，所有的接口提交前 在条件允许的情况下 `必须` 通过测试后才能提交(比如微信支付的回调可以考虑提交后测试)
    在api下的mallapp项目 由于 开发原因 暂时并没有集成Junit mock测试，但可以考虑写入，部分接口可能需要通过session或者经过特定的HttpHeader中cookie字段才能访问，调试不便，可考虑发布测试环境调试
    
8. 其他相关技术:
    - rabbitmq: 项目目前使用rabbitmq做消息中间件; 商户的登录 抢单 备货通知 都使用mq做消息处理(服务端发送消息到mq 客户端订阅消息)
    - redis: 项目测试环境使用redis做部分缓存操作，部分操作直接从redis获取数据展示，`正式环境并未使用`
    - quartz: 项目使用quartz做定时任务操作，quartz采用jdbcStore持久化到DB，目前并没有单独的quartz项目，所有注册scheduler的项目都会操作quartz任务

9  商业项目，前端小程序代码 和 后台管理 部分的代码， 商户端APP ，配送端APP， 这个没有上传代码， 需要的单独联系我 吧 。就不方便公开了， 需要的朋友可以加QQ 2219992847索求，好友请求加说明“智慧农贸”。

10. 小程序体验可以在微信 小程序中搜索 “罗老板智慧农贸商城”

 


 
