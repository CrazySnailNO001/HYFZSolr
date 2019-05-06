package com.jc519.search.web.rest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author XZHH
 * @Description:
 * @create 2018/6/14 0014 13:35
 * @modify By:
 **/
public class CompareDemo {
    public static void main(String[] args) {
        Student bob = new Student("bob", 1, 1, 1);
        Student jack = new Student("jack", 1, 1, 2);
        Student lisa = new Student("lisa", 1, 2, 1);
        Student lufei = new Student("lufei", 1, 2, 2);
        Student mike = new Student("mike", 2, 1, 1);

        ArrayList<Student> students = new ArrayList<>();

        students.add(bob);
        students.add(jack);
        students.add(lisa);
        students.add(lufei);
        students.add(mike);

        new CompareDemo(students);
        System.out.println(students);

    }

    public List<Comparator<Student>> mCmpList = new ArrayList<Comparator<Student>>();

    public CompareDemo(List<Student> mList) {
        mCmpList.add(compareAgeDESC);
        mCmpList.add(comparePointDESC);
        mCmpList.add(orderByHightDesc);
        sort(mList, mCmpList);
    }

    public void sort(List<Student> list, final List<Comparator<Student>> comList) {
        if (comList == null)
            return;
        Comparator<Student> cmp = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                for (Comparator<Student> comparator : comList) {
                    if (comparator.compare(o1, o2) > 0) {
                        return 1;
                    } else if (comparator.compare(o1, o2) < 0) {
                        return -1;
                    }
                }
                return 0;
            }
        };
        Collections.sort(list, cmp);
    }

    private Comparator<Student> compareAgeDESC = new Comparator<Student>() {

        @Override
        public int compare(Student o1, Student o2) {
            return o1.age > o2.age ? 1 : -1;
        }
    };

    private Comparator<Student> comparePointDESC = new Comparator<Student>() {

        @Override
        public int compare(Student o1, Student o2) {
            return o1.point < o2.point ? 1 : -1;
        }
    };
    private Comparator<Student> orderByHightDesc = new Comparator<Student>() {

        @Override
        public int compare(Student o1, Student o2) {
            return o1.hight < o2.hight ? 1 : -1;
        }
    };
}
