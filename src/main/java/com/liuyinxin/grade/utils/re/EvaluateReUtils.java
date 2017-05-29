package com.liuyinxin.grade.utils.re;

import com.liuyinxin.grade.dto.Evaluate;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 网教正则工具
 * @Author LiuYinXin
 * Created at 2017/5/26.22:22.
 */
public class EvaluateReUtils {

    public static List<Evaluate> getEvaluateList(String context){
        String regex = "(?<=\")(.*?)#@(.*?)#@(.*?)#@(.*?)#@(.*?)#@(.*?)(?=\")|(是(?=</td>)|否(?=</td>))";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(context);
        List<Evaluate> evaluateList = new ArrayList<>();
        Evaluate evaluate = new Evaluate();
        int count = 0;
        while(matcher.find()) {
            if(count++%2==0 ){
                evaluate.setIsEvaluate(matcher.group(0));
                continue;
            }
//            System.out.print(matcher.groupCount()+"   ");
//            System.out.println(matcher.group(0));
            evaluate.setEvaluateNumber(matcher.group(1));
            evaluate.setTeacherNumber(matcher.group(2));
            evaluate.setTeacherName(matcher.group(3));
            evaluate.setEvaluateName(matcher.group(4));
            evaluate.setClassName(matcher.group(5));
            evaluate.setClassNumber(matcher.group(6));
            evaluateList.add(evaluate);
            evaluate = new Evaluate();
        }
        return evaluateList;
    }


    public static boolean isEvaluateSuccess(String context){

        String regex = "(?<=alert\\(\").*?(?=\"\\))";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(regex);
        while (matcher.find()){
            if(matcher.group(0).indexOf("失败") >0){
                return false;
            }
        }
        return true;



    }



}
