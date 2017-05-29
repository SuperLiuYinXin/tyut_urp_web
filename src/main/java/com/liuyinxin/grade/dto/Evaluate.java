package com.liuyinxin.grade.dto;

/**
 * 教学评估
 * @Author LiuYinXin
 * Created at 2017/5/26.21:37.
 */
public class Evaluate {


    //  0000000103 wjbm教评编码
    private String evaluateNumber;

    // #@101453  bpr 被评人
    private String teacherNumber;

    // #@田添 bprm 被评人名
    private String teacherName;

    // #@2016-2017学年第二学期期末学生评教 wjmc  网教名称
    private String evaluateName;

    // #@线性代数E  pgnrm  评估内容名
    private String className;

    // #@00003346 pgnr评估内容
    private String classNumber;

    // 是否评价
    private String isEvaluate;

    // oper 操作名
    private String oper = "wjShow";

    @Override
    public String toString() {
        return "Evaluate{" +
                "evaluateNumber='" + evaluateNumber + '\'' +
                ", teacherNumber='" + teacherNumber + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", evaluateName='" + evaluateName + '\'' +
                ", className='" + className + '\'' +
                ", classNumber='" + classNumber + '\'' +
                ", isEvaluate='" + isEvaluate + '\'' +
                ", oper='" + oper + '\'' +
                '}';
    }

    public String getEvaluateNumber() {
        return evaluateNumber;
    }

    public void setEvaluateNumber(String evaluateNumber) {
        this.evaluateNumber = evaluateNumber;
    }

    public String getTeacherNumber() {
        return teacherNumber;
    }

    public void setTeacherNumber(String teacherNumber) {
        this.teacherNumber = teacherNumber;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getEvaluateName() {
        return evaluateName;
    }

    public void setEvaluateName(String evaluateName) {
        this.evaluateName = evaluateName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(String classNumber) {
        this.classNumber = classNumber;
    }

    public String getIsEvaluate() {
        return isEvaluate;
    }

    public void setIsEvaluate(String isEvaluate) {
        this.isEvaluate = isEvaluate;
    }

    public String getOper() {
        return oper;
    }

    public void setOper(String oper) {
        this.oper = oper;
    }
}
