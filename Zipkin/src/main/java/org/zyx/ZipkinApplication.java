package org.zyx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin.server.internal.EnableZipkinServer;

/**
 * 访问Zipkin 图形化界面的路径:http://localhost:9090/zipkin/
 *
 * Created by SunShine on 2020/4/26.
 */
@SpringBootApplication
@EnableZipkinServer         //声明启动Ziipkin Server
public class ZipkinApplication {

    public static void main(String[] args) {

        SpringApplication.run(ZipkinApplication.class,args);
    }

}
