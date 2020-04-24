package org.zyx.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by SunShine on 2020/4/24.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    private long id;
    private String name;
    private int age;

}
