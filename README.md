# SpringLite

基于SpringBoot的完整框架，便于在此框架上快速开始业务处理。

项目使用gradle、SpringBoot2.0、Kotlin开发。

## 项目目标

项目由三个module组成：

- SpringLite: 基本库。
  - i18n
  - 缓存
  - Session
  - 日志
  - 错误处理
  - 基于角色的访问控制
- SpringLiteRest: 使用SpringLite库，开发Restful接口。
  - 登录
  - 退出登录
  - 主页内容(非保护资源)
  - 个人信息(需要登录)
  - 查看用户表(需要登录，且角色为管理员)
- SpringLiteWeb: 一个Web页面，演示SpringLiteRest接口的调用。
  - 欢迎页
  - 登录页面
  - 个人信息页
  - 用户列表页

## 创建多Module的项目

1. 创建一个文件夹，命名为SpringLite。

1. 执行`gradle init`。

1. 创建SpringLite Module：

   1. 用IDEA打开SpringLite

   1. File -> New -> Module, 选择Spring Initializr， 创建SpringLite
       - Artifact: spring-lite
       - Type: Gradle Type
       - Language: Kotlin

   1. Dependencies中选择:
      - Session
      - Cache
      - Aspects
      - DevTools
      - Web
      - Security
      - JPA
      - MySQL
      - H2
      - Redis
      - Actuator
   1. 删除掉spring-lite中的以下文件或文件夹:
  
      - .gradle、gradle、gradlew、gradlew.bat、settings.gradle

   1. SpringLite/settings.gradle中添加:
  
      ```groovy
      rootProject.name = 'SpringLite'
      include 'spring-lite'
      ```

   1. 在com.example.springlite下创建以下package

      - common: 存放通用的功能
      - file: 存放文件相关功能
      - db: 存放数据库相关功能
      - config: 存放配置相关功能
      - exception: 存放错误处理功能
      - utils: 存放utils

   1. 右侧Gradle栏，双击spring-lite -> Tasks -> build -> build，会生成spring-lite/build/lib/spring-lite-0.0.1-SNAPSHOT.jar文件

1. 创建SpringLiteRest Module

   步骤同上，只说明不同的地方:
   - Artifact: spring-lite-rest
   - Dependencies只选择Web
   - SpringLite/settings.gradle中添加:

     ```groovy
     rootProject.name = 'SpringLite'
     include 'spring-lite', 'spring-lite-rest'
     ```

   - SpringLiteRest/gradle.build下增加对SpringLite的依赖:

     ```groovy
     dependencies {
        ...
        implementation project(':spring-lite')
     }
     ```

   - 创建包名:
     - controller: 存放页面
     - repository: 存放数据Repository
     - serivice: 存放service类
     - config: 存放配置类
