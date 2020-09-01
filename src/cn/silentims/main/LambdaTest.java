package cn.silentims.main;

import cn.silentims.StudentFilter;
import cn.silentims.entity.Student;
import cn.silentims.impl.FilterByAge;
import cn.silentims.impl.FilterByGrade;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class LambdaTest {


    List<Student> students = Arrays.asList(
            new Student(1,"张三",17,560.5),
            new Student(2,"李四",16,360.5),
            new Student(3,"王五",18,460.5),
            new Student(4,"赵六",18,470)
    );

    //需求：获取年龄大于17岁的学生

    //最笨的方法
    public List<Student> filterStudentByAge(List<Student> list){
        List<Student> students = new ArrayList<>();
        for (Student student : list) {
            if (student.getAge() > 17){
                students.add(student);
            }
        }
        return students;
    }

    //优化方式1：采用接口策略设计模式
    public List<Student> filterStudentByFilter(List<Student> list , StudentFilter<Student> sf){
        List<Student> students = new ArrayList<>();
        for (Student student : list) {
            if (sf.filterStudents(student)){
                students.add(student);
            }
        }
        return students;
    }


    //测试最笨的方法
    @Test
    public void test1(){
        List<Student> students = filterStudentByAge(this.students);
        for (Student s : students) {
            System.out.println(s);
        }
    }

    //测试策略模式-byAge
    @Test
    public void test2(){
        List<Student> list = filterStudentByFilter(students,new FilterByAge());
        for (Student student : list) {
            System.out.println(student);
        }
    }

    //测试策略模式-byGrade
    @Test
    public void test3(){
        List<Student> students = filterStudentByFilter(this.students, new FilterByGrade());
        for (Student student : students) {
            System.out.println(student);
        }
    }

    //优化方式2：匿名内部类
    @Test
    public void test4(){
        List<Student> students = filterStudentByFilter(this.students, new StudentFilter<Student>() {
            @Override
            public boolean filterStudents(Student student) {
                return student.getGrade() > 400;
            }
        });
        for (Student student : students) {
            System.out.println(student);
//            Student{id=1, name='张三', age=17, grade=560.5}
//            Student{id=3, name='王五', age=18, grade=460.5}
//            Student{id=4, name='赵六', age=18, grade=470.0}
        }
    }

    //优化方式3：lambda
    @Test
    public  void test5(){
        List<Student> list = filterStudentByFilter(this.students, student -> student.getGrade() > 470);
        //老的写法
        for (Student student : list) {
            System.out.println(student);
            //Student{id=1, name='张三', age=17, grade=560.5}
        }

        //lambda写法
        list.forEach(System.out::println);
    }

    //优化方式4：lamda+stream流
    @Test
    public void test6(){
        students.stream()
                .filter(student -> student.getAge() > 17)
                .forEach(System.out::println);
    }

}