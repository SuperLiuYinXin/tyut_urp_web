package com.liuyinxin.grade.dto;

import java.util.List;

/**
 * 存放一学期的成绩
 * @Author LiuYinXin
 * Created at 2017/5/19.11:13.
 */
public class Term {

    private List<Grade> grades;

    private String name;


    public List<Grade> getGrades() {
        return grades;
    }

    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Term{" +
                "grades=" + grades +
                ", name='" + name + '\'' +
                '}';
    }
}
