package com.liuyinxin.grade.controller;

import com.liuyinxin.grade.config.PathConfig;
import com.liuyinxin.grade.config.ResultConfig;
import com.liuyinxin.grade.dto.ServiceResult;
import com.liuyinxin.grade.dto.Term;
import com.liuyinxin.grade.utils.http.RequestUtils;
import com.liuyinxin.grade.utils.re.ReUtils;
import org.apache.http.HttpException;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author LiuYinXin
 * Created at 2017/5/18.15:47.
 */
@RestController
@RequestMapping("/grade")
public class GradeController {

    private static final Logger log = Logger.getLogger(GradeController.class.getName());


    @RequestMapping(path = "/get",method = RequestMethod.POST)
    public ServiceResult login(@RequestParam("cookies")String cookies){

        Map<String,String>header = new HashMap<>();
        header.put("Cookie",cookies);

        String gradePath = PathConfig.getIndex()+PathConfig.getGradePath();
        String gradeResult = null;
        try {
            gradeResult = RequestUtils.get(gradePath,header,"UTF-8");
        } catch (HttpException e) {
            e.printStackTrace();
        }
//        String pattern = "\\bcenter\\b.{1,3}>\\s*(\\d+\\.?\\d?|[\\u4e00-\\u9fa5].*)";
        String pattern = "\\bcenter\\b.{1,3}>\\s*([a-zA-Z]{0,3}\\d+\\.?\\d?|[a-zA-Z]{0,10}[\\u4e00-\\u9fa5].*)";
//        List<Grade> gradeList =  ReUtils.getGradeList(gradeResult,pattern);
        List<Term> terms = ReUtils.getTermList(gradeResult,pattern,"<b>");

        return new ServiceResult(ResultConfig.STATIC_RESULT_SUCCESS,terms);
    }

    @GetMapping("/detail")
    public ModelAndView gradeDetail(ModelAndView view){
        view.setViewName("/front/detail");
        return view;
    }

}
