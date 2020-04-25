package org.zyx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**服务网关
 * 注解说明：
@EnableZuulProxy：包含了 @EnableZuulServer，设置该类是网关的启动类。
@EnableAutoConfiguration： 可以帮助 Spring Boot 应用将所有符合条件的 @Configuration 配置加载到当前 Spring Boot 创建并使用的 IoC 容器中。
 * Created by SunShine on 2020/4/25.
 */
@EnableZuulProxy
@EnableAutoConfiguration    //自动装载配置
public class ZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class,args);
    }

}
