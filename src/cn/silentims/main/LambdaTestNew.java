package cn.silentims.main;


import cn.silentims.entity.Student;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LambdaTestNew {

    List<Student> list = Arrays.asList(
            new Student(1,"张三",23,660.5),
            new Student(2,"李四",24,560.5),
            new Student(3,"张三",21,360.5),
            new Student(4,"赵六",32,260.5));



    //需求：通过Collections进行排序，并使用lambda先进行姓名比较，姓名相同比较年龄
    @Test
    public void test1(){
        Collections.sort(list,(l1,l2) -> {
            if (l1.getAge() == l2.getAge()){
                return l1.getName().compareTo(l2.getName());
            }else {
                return Integer.compare(l1.getAge(),l2.getAge());
            }
        });

        list.forEach(System.out::println);
    }
}


