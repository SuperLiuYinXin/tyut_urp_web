package com.liuyinxin.grade.biz.impl;

import com.liuyinxin.grade.biz.GradeBiz;
import com.liuyinxin.grade.config.PathConfig;
import com.liuyinxin.grade.dto.Term;
import com.liuyinxin.grade.utils.http.RequestUtils;
import com.liuyinxin.grade.utils.re.ReUtils;
import org.apache.http.HttpException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author LiuYinXin
 * Created at 2017/5/27.21:44.
 */
@Service
public class GradeBizImpl implements GradeBiz{

//    @RequestMapping(path = "/get",method = RequestMethod.POST)
    public List<Term> getGradeList(@RequestParam("cookies")String cookies){

        Map<String,String> header = new HashMap<>();
        header.put("Cookie",cookies);

        String gradePath = PathConfig.getIndex()+PathConfig.getGradePath();
        String gradeResult = null;
        try {
            gradeResult = RequestUtils.get(gradePath,header,"UTF-8");
        } catch (HttpException e) {
            e.printStackTrace();
        }

        String pattern = "\\bcenter\\b.{1,3}>\\s*([a-zA-Z]{0,3}\\d+\\.?\\d?|[a-zA-Z]{0,10}[\\u4e00-\\u9fa5].*)";

        List<Term> terms = ReUtils.getTermList(gradeResult,pattern,"<b>");

//        return new ServiceResult(ResultConfig.STATIC_RESULT_SUCCESS,terms);
        return terms;
    }

//    @GetMapping("/detail")
//    public ModelAndView gradeDetail(ModelAndView view){
//        view.setViewName("/front/detail");
//        return view;
//    }
}
