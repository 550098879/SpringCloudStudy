package org.zyx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**Hystrix容错机制
 *
 *  访问节点:localhost:8060/actuator/hystrix.stream
 *  访问仪表盘: localhost:8060/hystrix
 * Created by SunShine on 2020/4/25.
 */
@SpringBootApplication
@EnableFeignClients     //feign提供负载均衡
@EnableCircuitBreaker   //声明启用数据监控
@EnableHystrixDashboard  //声明启用可视化数据监控(仪表盘)
public class HystrixApplication {

    public static void main(String[] args) {
        SpringApplication.run(HystrixApplication.class,args);
    }

}
