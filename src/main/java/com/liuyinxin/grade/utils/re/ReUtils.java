package com.liuyinxin.grade.utils.re;


import com.liuyinxin.grade.dto.Grade;
import com.liuyinxin.grade.dto.Term;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author LiuYinXin
 * Created at 2017/5/18.21:29.
 */
public class ReUtils {

    private static List<Grade> getGradeList(String src, String pattern){
        Pattern r = Pattern.compile(pattern);
        Matcher m= r.matcher(src);
        List<Grade> gradeList= new ArrayList<>();
        int count = 0;
        Grade grade = new Grade();
        while(m.find()) {
            switch (count++%6){
                case 0: grade.setClassNumber(
                            m.group().replaceAll("center\">\\s*",""));
                        break;
                case 1:grade.setClassOrder(
                        m.group().replaceAll("center\">\\s*",""));
                        break;
                case 2:grade.setClassName(m.group().replaceAll("center\">\\s*",""));
                        break;
                case 3:grade.setCredit(m.group().replaceAll("center\">\\s*",""));
                        break;
                case 4:grade.setClassInfo(m.group().replaceAll("center\">\\s*",""));
                        break;
                case 5:grade.setGrade(m.group().replaceAll("center\">\\s*",""));
                        gradeList.add(grade);
                        grade = new Grade();
                        break;
            }
        }
        return gradeList;
    }

    public static boolean isLoginSuccess(String result,String pattern){
        if(result.indexOf(pattern)>0){
            return true;
        }
        return false;
    }

    public static List<Term> getTermList(String src, String regex, String splitRegex){
//        String pattern = "\\bcenter\\b.{1,3}>\\s*([a-zA-Z]{0,3}\\d+\\.?\\d?|[a-zA-Z]{0,10}[\\u4e00-\\u9fa5].*)";
        //跳过刚开始匹配的
        List<Term> terms = new ArrayList<>();
        String[] result =  src.split(splitRegex);
        Term  term;
        for (int i = 1;i<result.length;i++){
            term = new Term();
            String name = result[i].substring(0,result[i].lastIndexOf("</b>"));
            term.setName(name);
            List<Grade> gradeList =  ReUtils.getGradeList(result[i],regex);
            term.setGrades(gradeList);
            terms.add(term);
        }
        return terms;
    }

    public static String classReUtils(){
        return null;

    }

}
