package org.zyx.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.zyx.entity.Student;
import org.zyx.feign.impl.FeignError;

import java.util.Collection;

/**
 * Created by SunShine on 2020/4/25.
 */
@Component
@FeignClient(value = "provider",fallback = FeignError.class)
public interface FeignProviderClient {

    @GetMapping("/student/findAll")
    Collection<Student> findAll();

    @GetMapping("/student/index")
    String index();


}
