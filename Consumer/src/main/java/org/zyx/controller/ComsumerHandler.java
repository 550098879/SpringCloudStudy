package org.zyx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.zyx.entity.Student;

import java.util.Collection;

/**服务消费者
 * Created by SunShine on 2020/4/24.
 */
@RestController
@RequestMapping("/consumer")
public class ComsumerHandler {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/findAll")
    public Collection<Student> findAll(){
        //getForEntity get请求,获取一个entity,url:服务提供者请求路径,返回的结果类型 ,getBody()返回Collection
        return restTemplate.getForEntity("http://localhost:8010/student/findAll",Collection.class).getBody();
    }

    @GetMapping("/findAll2")
    public Collection<Student> findAll2(){
        //getForObject 直接根据传递的类型返回响应结果
        return restTemplate.getForObject("http://localhost:8010/student/findAll",Collection.class);
    }

    @GetMapping("findById/{id}")
    public Student findById(@PathVariable("id") Long id){
        /**
         * 参数的填写方式也是rest风格. ../findById/{id}
         * 参数传递在getObject()类型后面追加
         * 参数请看源码
         */
//        return restTemplate.getForObject("url",Student.class,id).getBody();
        return restTemplate.getForObject("http://localhost:8010/student/findById/{id}",Student.class,id);
    }

    @PostMapping("/save")
    public void save(@RequestBody Student student){
//        restTemplate.postForObject("url",student,null).getBody();
        /**
         * postForObject()方法的传参是直接在url后添加,返回值则填写null
         */
        restTemplate.postForObject("http://localhost:8010/student/save",student,null);
    }

    @PutMapping("/update")
    public void update(@RequestBody Student student){
//        restTemplate.postForObject("url",student,null).getBody();
        /**
         * 更新使用put请求和方法,只有两个参数
         */
        restTemplate.put("http://localhost:8010/student/save",student);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") Long id){
        restTemplate.delete("http://localhost:8010/student/deleteById/{id}",id);
    }

}
