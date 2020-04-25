package org.zyx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**服务提供者
 * Created by SunShine on 2020/4/24.
 */
@SpringBootApplication
//@EnableEurekaClient    不用添加这个注解?
public class ProviderApplication2 {

    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication2.class,args);
    }
}
