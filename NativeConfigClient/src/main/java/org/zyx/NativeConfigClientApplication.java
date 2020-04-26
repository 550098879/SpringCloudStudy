package org.zyx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**读取本地配置文件
 * Created by SunShine on 2020/4/26.
 */
@SpringBootApplication
public class NativeConfigClientApplication {

    public static void main(String[] args) {

        SpringApplication.run(NativeConfigClientApplication.class,args);
    }
}
