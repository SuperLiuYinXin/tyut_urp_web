package com.liuyinxin.grade.biz;

import com.liuyinxin.grade.dto.Evaluate;

import java.util.List;

/**
 * @Author LiuYinXin
 * Created at 2017/5/26.23:15.
 */
public interface EvaluateBiz {

    int autoEvaluate(String cookie, Evaluate evaluate);

    /**
     * 获取教评价列表
     * @param cookie cookie 值
     * @return  教评列表
     */
    List<Evaluate> getEvaluateList(String cookie);

    /**
     * 进入到详情页面
     * @param cookie  cookies值
     * @return 返回详情页面的html
     */
    String  getEvaluateDetail(String cookie,Evaluate evaluate);

}
