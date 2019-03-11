package com.gy.algorithm.sort;

import java.util.Arrays;

/**
 * ClassName: Student
 * Description:
 * date: 2019/3/11 8:21
 *
 * @author 郭宇
 * @since JDK 1.8
 */
public class Student {
    private int stuNo;

    private String name;

    private int age;

    private String sex;

    public Student(int stuNo, String name, int age, String sex) {
        this.stuNo = stuNo;
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public int getStuNo() {
        return stuNo;
    }

    public void setStuNo(int stuNo) {
        this.stuNo = stuNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuNo=" + stuNo +
                ", name='" + name + '\'' +
                '}';
    }

    //根据学号排序
    public static void selectByNo(Student[] a) {
        if (a == null || a.length == 0) return;
        int minValue = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < a.length - 1; i++) {
            minIndex = i;
            minValue = a[i].getStuNo();
            for (int j = i + 1; j < a.length; j++) {
                if (a[j].getStuNo() < minValue) {
                    minIndex = j;
                    minValue = a[j].getStuNo();
                }
            }
            if (i != minIndex) swap(a, i, minIndex);
        }
    }

    //根据姓名排序
    public static void selectByName(Student[] a) {
        if (a == null || a.length == 0) return;
        String minValue = "";
        int minIndex = -1;
        for (int i = 0; i < a.length - 1; i++) {
            minIndex = i;
            minValue = a[i].getName();
            for (int j = i + 1; j < a.length; j++) {
                if (a[j].getName().compareTo(minValue)<0) {
                    minIndex = j;
                    minValue = a[j].getName();
                }
            }
            if (i != minIndex) swap(a, i, minIndex);
        }
    }

    public static void swap(Student[] array, int pre, int next) {
        Student i = array[pre];
        array[pre] = array[next];
        array[next] = i;
    }

    public static void main(String[] args) {
        Student[] students = {new Student(1, "张三1", 12, "男"),
                new Student(3, "张三3", 12, "女"),
                new Student(5, "张三5", 12, "男"),
                new Student(4, "张三4", 12, "女"),
                new Student(2, "张三2", 12, "男"),
                new Student(1, "张三1", 12, "男"),
                new Student(0, "张三0", 12, "男"),
                new Student(10, "张三9", 12, "男")};
        Student.selectByName(students);
        System.out.println(Arrays.toString(students));
    }
}

