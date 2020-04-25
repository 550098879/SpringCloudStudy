package org.zyx.feign.impl;

import org.springframework.stereotype.Component;
import org.zyx.entity.Student;
import org.zyx.feign.FeignProviderClient;

import java.util.Collection;

/**
 * Created by SunShine on 2020/4/25.
 */
@Component
public class FeignError implements FeignProviderClient {
    @Override
    public Collection<Student> findAll() {
        return null;
    }

    @Override
    public String index() {
        return "服务器维护中.......";
    }
}
