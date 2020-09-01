package cn.silentims.impl;

import cn.silentims.StudentFilter;
import cn.silentims.entity.Student;

import java.util.List;

public class FilterByAge implements StudentFilter<Student> {

    @Override
    public boolean filterStudents(Student student) {
        return student.getAge() < 17;
    }
}
