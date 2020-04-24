package org.zyx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**注册中心
 * Created by SunShine on 2020/4/24.
 *
 @SpringBootApplication： 声明该类是 Spring Boot 服务的入口。
 @EnableEurekaServer： 声明该类是一个 Eureka Server 微服务，提供服务注册和服务发现功能，即注册中心。

 */
@SpringBootApplication
//注册中心:声明该类是一个Eureka Server微服务.提供服务注册和服务发现功能
@EnableEurekaServer
public class EurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication.class,args);

//        访问路径:http://localhost:8761

    }
}
