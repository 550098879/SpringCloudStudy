package org.zyx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**没注册,不是服务消费者
 * Created by SunShine on 2020/4/24.
 */
@SpringBootApplication
public class RestTemplateApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestTemplateApplication.class,args);
    }

    @Bean  //折辱IOC容器
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
