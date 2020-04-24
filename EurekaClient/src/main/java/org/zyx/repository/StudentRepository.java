package org.zyx.repository;

import org.zyx.entity.Student;

import java.util.Collection;

/**
 * Created by SunShine on 2020/4/24.
 */
public interface StudentRepository {

    Collection<Student> findAll();
    Student findById(long id);
    void saveOrUpdate(Student student);
    void deleteById(long id);

}
