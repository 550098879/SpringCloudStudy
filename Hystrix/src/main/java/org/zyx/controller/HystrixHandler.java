package org.zyx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zyx.entity.Student;
import org.zyx.feign.FeignProviderClient;

import java.util.Collection;

/**
 * Created by SunShine on 2020/4/25.
 */
@RestController
@RequestMapping("/hystrix")
public class HystrixHandler {

    @Autowired
    private FeignProviderClient feignProviderClient;

    @GetMapping("/findAll")
    public Collection<Student> findAll(){
        return feignProviderClient.findAll();
    }

    @GetMapping("/index")
    public  String index(){
        return feignProviderClient.index();
    }

}
