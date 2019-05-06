package com.jc519.search.web.rest;

/**
 * @author XZHH
 * @Description:
 * @create 2018/6/14 0014 14:00
 * @modify By:
 **/
public class Student {
    private String name;
    public int age;
    public int point;
    public int hight;

    public Student(String name, int age, int point, int hight) {
        this.name = name;
        this.age = age;
        this.point = point;
        this.hight = hight;
    }

    public Student() {
    }

    public int getHight() {
        return hight;
    }

    public void setHight(int hight) {
        this.hight = hight;
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

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", point=" + point +
                ", hight=" + hight +
                '}';
    }
}
