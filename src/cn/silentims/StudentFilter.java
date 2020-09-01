package cn.silentims;

import cn.silentims.entity.Student;

import java.util.List;

public interface StudentFilter<T> {

    public boolean filterStudents(T t);

}
