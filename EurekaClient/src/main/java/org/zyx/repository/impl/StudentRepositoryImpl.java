package org.zyx.repository.impl;

import org.springframework.stereotype.Repository;
import org.zyx.entity.Student;
import org.zyx.repository.StudentRepository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by SunShine on 2020/4/24.
 */
@Repository
public class StudentRepositoryImpl implements StudentRepository {

    private static Map<Long,Student> studentMap=new HashMap<>();

    static{
        studentMap.put(1L,new Student(1,"张三",20));
        studentMap.put(2L,new Student(2,"李四",20));
        studentMap.put(3L,new Student(3,"王五",21));
    }

    @Override
    public Collection<Student> findAll() {
        return studentMap.values();
    }

    @Override
    public Student findById(long id) {
        return studentMap.get(id);
    }

    @Override
    public void saveOrUpdate(Student student) {
        studentMap.put(student.getId(),student);
    }

    @Override
    public void deleteById(long id) {
        studentMap.remove(id);
    }
}
