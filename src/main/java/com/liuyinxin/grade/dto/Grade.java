package com.liuyinxin.grade.dto;

/**
 * @Author LiuYinXin
 * Created at 2017/5/18.23:48.
 */
public class Grade {
//    课程号
    private String classNumber;

//    课序号
    private String classOrder;

//    课程名
    private String className;

//    学分
    private String credit ;

//    课程属性
    private String classInfo;

//    成绩
    private String grade;

    public String getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(String classNumber) {
        this.classNumber = classNumber;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    public String getClassOrder() {
        return classOrder;
    }

    public void setClassOrder(String classOrder) {
        this.classOrder = classOrder;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassInfo() {
        return classInfo;
    }

    public void setClassInfo(String classInfo) {
        this.classInfo = classInfo;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "classNumber='" + classNumber + '\'' +
                ", classOrder='" + classOrder + '\'' +
                ", className='" + className + '\'' +
                ", credit='" + credit + '\'' +
                ", classInfo='" + classInfo + '\'' +
                ", grade='" + grade + '\'' +
                '}';
    }
}
