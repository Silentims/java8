package cn.silentims.impl;

import cn.silentims.StudentFilter;
import cn.silentims.entity.Student;

public class FilterByGrade implements StudentFilter<Student> {
    @Override
    public boolean filterStudents(Student student) {
        return student.getGrade() > 400;
    }
}
