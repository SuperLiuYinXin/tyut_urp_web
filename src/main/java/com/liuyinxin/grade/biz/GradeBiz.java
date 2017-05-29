package com.liuyinxin.grade.biz;

import com.liuyinxin.grade.dto.Term;

import java.util.List;

/**
 * @Author LiuYinXin
 * Created at 2017/5/27.21:44.
 */
public interface GradeBiz {

    /**
     *
     * @param cookies
     * @return
     */
    List<Term> getGradeList(String cookies);
}
