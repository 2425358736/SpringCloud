# springcloud搭建
## 1.新建maven项目（springCloud001）
###  1.1修改pox.xml(src目录可以删除)

```
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>springCloud001</groupId>
    <artifactId>springCloud001</artifactId>
    <version>1.0-SNAPSHOT</version>

<!--以下dependency来自官方-->
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>1.4.5.RELEASE</version>
    </parent>

    <dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-dependencies</artifactId>
                <version>Camden.SR6</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
        </dependencies>
    </dependencyManagement>
<!-- end -->

</project>
```
## 2. 在springCloud001项目里新建注册中心工程服务（register-service）

```
新建后springCloud001的pox.xml里会出现子模块
    <modules>
        <module>register-service</module>
    </modules>
```
### 2.1 修改register-service 的pox.xml
  pox.xml 增加 注册核心开发包
```
    <dependencies>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-eureka-server</artifactId>
        </dependency>
    </dependencies>
```
### 2.2 新建RegisterApplication 启动类（注意 启动类不能直接在Java目录下）
#### 2.2.1 Java目录下新建 com->liuzhiqiang目录在此目录下新建RegisterApplication 启动类

```
package com.liuzhiqiang;

/**
 * Created by liuzhiqiang on 2018/12/09.
 */
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer //开启Eureka Server
public class RegisterApplication implements CommandLineRunner {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    public static void main(String[] args) {
        SpringApplication.run(RegisterApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        logger.info("服务器启动成功");
    }
}

```
### 2.3resources目录下新建application.yml 配置文件


```
server:
  port: 8080 # 注册中心占用8080端口
eureka:
  instance:
    hostname: localhost
  client:
    registerWithEureka: false
    fetchRegistry: false
    serviceUrl:
      defaultZone: http://${eureka.instance.hostname}:${server.port}/eureka/
```
### 启动注册中心 http://localhost:8080/

![image](https://yun-cunchu.oss-cn-beijing.aliyuncs.com/images/AW3C4O1I%5D%5B%7ED%7D9%7BWAS_80GB.png)

    





    
