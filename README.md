# spring-boot-dubbo
## spring-boot-dubbo 框架 是基于dubbo 协议对内提供服务和基于restful 封装对外提供服务访问 

### spring-boot-api  jar 封装服务对外的API和公共功能
    1.提供统一返回模版
    2.提供统一参数模版

### spring-boot-common jar 封装StringUtil,BeanUtil等组件化功能模块
    1.提供StringUtil,BeanUtil等基础组件封装
    2.提供签名加密组件封装

### spring-boot-dao jar 封装底层dao 这一层模块化功能
    1.提供基于mybatis集成dao
    2.提供基于mybatis-generator-maven-plugin 插件自动生成代码

### spring-boot-core jar 封装dubbo对内暴露的服务接口
    1.提供注解式事务管理
    2.提供统一业务异常

### spring-boot-server war 封装dubbo对内暴露的服务接口的启动入口
    1.提供服务启动入口
    2.提供统一参数日志打印信息
    3.提供日志模版

### spring-boot-face war 封装在dubbo对内暴露服务的基础上对外提供restful 服务
    1.提供统一签名功能
    2.提供统一参数验证
    3.提供统一异常管理
    4.提供对外restful 服务

### spring-boot-dubbo jar 封装dubbo依赖服务,提供dubbo的集成
    1.封装dubbo服务集成，公共组件化服务

### spring-boot-job-core jar 封装JOB中对内暴露的服务接口
    1.提供job 注解式事务管理
    2.提供job 统一业务异常

### spring-boot-job-server war 封装dubbo-Job 对内暴露的服务接口的启动入口
    1.提供job 服务启动入口
    2.提供job 统一参数日志打印信息
    3.提供job 日志模版

### spring-boot-job-face war 封装在dubbo-Job 对内暴露服务的基础上对外提供restful 服务
    1.提供job restful 服务

### spring-boot-job war 封装基于elasticjob集成任务调度
    1.提供基于elasticjob分布式分片任务调度
    2.提供统计restful 异步webClient 调用 API








