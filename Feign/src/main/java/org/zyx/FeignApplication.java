package org.zyx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**Feign客户端
 * Created by SunShine on 2020/4/25.
 */
@SpringBootApplication
@EnableFeignClients      //使之成为Feign客户端
public class FeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeignApplication.class,args);
    }
}
