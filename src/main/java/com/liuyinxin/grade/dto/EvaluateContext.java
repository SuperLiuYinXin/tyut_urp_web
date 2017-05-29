package com.liuyinxin.grade.dto;

import java.util.Map;

/**
 * @Author LiuYinXin
 * Created at 2017/5/26.23:33.
 */
public class EvaluateContext extends Evaluate{

    private String context;

    private Map<String,String>  evaluateMap;

    @Override
    public String toString() {
        return "EvaluateContext{" +
                "context=" + context +
                ", evaluateMap=" + evaluateMap +
                "} " + super.toString();
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Map<String, String> getEvaluateMap() {
        return evaluateMap;
    }

    public void setEvaluateMap(Map<String, String> evaluateMap) {
        this.evaluateMap = evaluateMap;
    }
}
