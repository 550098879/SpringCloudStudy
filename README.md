#Spring Cloud 微服务

基于SpringBoot多模块,添加SpringCloud进行服务管理

##概念  

一、分布式、集群

集群：一台服务器无法负荷高并发的数据访问量，那么就设置十台服务器一起分担压力，  
十台不行就设置一百台（物理层面）。很多人干同一件事情，来分摊压力。

分布式：将一个复杂问题拆分成若干个简单的小问题，将一个大型的项目架构拆分成若干个微服务  
来协同完成。（软件设计层面）。将一个庞大的工作拆分成若干个小步骤，分别由不同的人完成这些小步骤，  
最终将所有的结果进行整合实现大的需求。

二、服务治理的核心又三部分组成：服务提供者、服务消费者、注册中心。  

在分布式系统架构中，每个微服务在启动时，将自己的信息存储在注册中心，叫做服务注册。

服务消费者从注册中心获取服务提供者的网络信息，通过该信息调用服务，叫做服务发现。

Spring Cloud 的服务治理使用 Eureka 来实现，Eureka 是 Netflix 开源的基于 REST   
的服务治理解决方案，Spring Cloud 集成了 Eureka，提供服务注册和服务发现的功能，  
可以和基于 Spring Boot 搭建的微服务应用轻松完成整合，开箱即用，Spring Cloud Eureka。

##服务治理 
####注册中心,服务提供者,服务消费者

#####Spring Cloud Eureka

- Eureka Server，注册中心  

- Eureka Client，所有要进行注册的微服务通过 Eureka Client 连接到 Eureka Server，完成注册。

- 服务消费者和服务提供者之间的身份是可以转换的,根据不同的情形互相调用接口.  

- 引入不同的依赖,注册不同的身份.  

一、父工程
 1.pom.xml添加依赖  
 ```xml
 <parent>
   <groupId>org.springframework.boot</groupId>
   <artifactId>spring-boot-starter-parent</artifactId>
   <version>2.0.7.RELEASE</version>
 </parent>
 
 <dependencies>
   <dependency>
     <groupId>org.springframework.boot</groupId>
     <artifactId>spring-boot-starter-web</artifactId>
   </dependency>    
 </dependencies>
 <dependencyManagement>
   <dependencies>
     <dependency>
       <groupId>org.springframework.cloud</groupId>
       <artifactId>spring-cloud-dependencies</artifactId>
       <version>Finchley.SR2</version>
       <type>pom</type>
       <scope>import</scope>
     </dependency>
   </dependencies>
 </dependencyManagement>
 ```
 注意SpringBoot和SpringCloud之间的版本关系,不对应的版本会导致依赖无法导入和兼容的问题.  
 
####二、注册中心(Eureka Server)创建Module
1.pom.xml添加依赖
```xml
<dependencies>
  <dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
    <version>2.0.2.RELEASE</version>
  </dependency>
</dependencies>
```
2.创建配置文件 application.yml，添加 Eureka Server 相关配置。
  
  ```yaml
  server:
    port: 8761
  eureka:
    client:
      register-with-eureka: false
      fetch-registry: false
      service-url:
        defaultZone: http://localhost:8761/eureka/
  ```
> 属性说明

`server.port`：当前 Eureka Server 服务端口。

`eureka.client.register-with-eureka`：是否将当前的 Eureka Server 服务作为客户端进行注册。

`eureka.client.fetch-fegistry`：是否获取其他 Eureka Server 服务的数据。

`eureka.client.service-url.defaultZone`：注册中心的访问地址。

- 创建启动类

```java
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication.class,args);
    }
}
```
> 注解说明：

`@SpringBootApplication`：声明该类是 Spring Boot 服务的入口。

`@EnableEurekaServer`：声明该类是一个 Eureka Server 微服务，提供服务注册和服务发现功能，即注册中心。

### 服务提供者(Eureka Client)

- 创建 Module ，pom.xml

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
        <version>2.0.2.RELEASE</version>
    </dependency>
</dependencies>
```

- 创建配置文件 application.yml，添加 Eureka Client 相关配置

```yaml
server:
  port: 8010
spring:
  application:
    name: provider
eureka:
  client:
    service-url:
      defaultZone: http://localhost:8761/eureka/
  instance:
    prefer-ip-address: true
```

> 属性说明：

`spring.application.name`：当前服务注册在 Eureka Server 上的名称。

`eureka.client.service-url.defaultZone`：注册中心的访问地址。

`eureka.instance.prefer-ip-address`：是否将当前服务的 IP 注册到 Eureka Server。

- 创建启动类

```java
package com.southwind;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication.class,args);
    }
}
```

###服务消费者(Consumer)

- 创建 Maven 工程，pom.xml

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
        <version>2.0.2.RELEASE</version>
    </dependency>
</dependencies>
```

- 创建配置文件 application.yml

```yaml
server:
  port: 8020
spring:
  application:
    name: consumer
eureka:
  client:
    service-url:
      defaultZone: http://localhost:8761/eureka/
  instance:
    prefer-ip-address: true
```
- 创建启动类

```java
package com.southwind;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class,args);
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
```

###小结:  
- 父模块中添加的依赖和依赖管理,所有子模块都能使用
- 服务消费者和服务提供者引入的依赖是一样的,但是端口要区分开来
- 注册中心的访问地址为: http://localhost:8761  
- 项目的启动顺序依次为:注册中心→服务提供者→服务消费者
- Rest风格,基于RestTemplate,SpringBoot已经集成了RestTemplate
- 在创建启动类的时候使用@Bean将RestTemplate注入到IOC容器中

###出现的问题  
- 删除操作出现跨域异常
   解决:服务提供者中的删除方法用的是PutMapping,导致找不到请求路径,注意请求的方法必须一致  
- save方法出现responseType不能为null的问题,使用Object.class作为返回值即可
      