package com.liuyinxin.grade.controller;

import com.liuyinxin.grade.biz.EvaluateBiz;
import com.liuyinxin.grade.config.ResultConfig;
import com.liuyinxin.grade.dto.Evaluate;
import com.liuyinxin.grade.dto.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author LiuYinXin
 * Created at 2017/5/26.21:21.
 */
@RestController
@RequestMapping("/evaluate")
public class EvaluateController {

    private final EvaluateBiz  evaluateBiz;

    @Autowired
    public EvaluateController(EvaluateBiz evaluate) {
        evaluateBiz = evaluate;
    }


    @RequestMapping(path = "/list",method = RequestMethod.GET)
    public ServiceResult getEvaluateList(@RequestParam("cookies")String cookies){
        List<Evaluate>  evaluateList = evaluateBiz.getEvaluateList(cookies);

        ServiceResult serviceResult = new ServiceResult(ResultConfig.STATIC_RESULT_SUCCESS,
                                                        evaluateList);

        return  serviceResult;
    }


    @RequestMapping(path = "/auto",method = RequestMethod.GET)
    public ServiceResult autoEvaluate(@RequestBody @RequestParam("cookies")String cookies){
//        List<Evaluate>  evaluateList = evaluateBiz.getEvaluateList(cookies);
        List<Evaluate>  evaluateList = (List<Evaluate>) getEvaluateList(cookies).getResult();

        //获取到后开始依次提交
        for (Evaluate evaluate:evaluateList) {
            if(evaluate.getIsEvaluate().equals("是")){
                continue;
            }
            evaluateBiz.autoEvaluate(cookies,evaluate);
        }
        ServiceResult serviceResult = new ServiceResult(ResultConfig.STATIC_RESULT_SUCCESS,
                evaluateList);
        return  serviceResult;
    }
}
