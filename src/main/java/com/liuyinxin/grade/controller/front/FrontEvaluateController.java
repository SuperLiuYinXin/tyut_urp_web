package com.liuyinxin.grade.controller.front;

import com.liuyinxin.grade.biz.EvaluateBiz;
import com.liuyinxin.grade.config.ResultConfig;
import com.liuyinxin.grade.dto.Evaluate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * @Author LiuYinXin
 * Created at 2017/5/27.13:32.
 */
@Controller
@RequestMapping("/front")
public class FrontEvaluateController {

    private final EvaluateBiz evaluateBiz;

    @Autowired
    public FrontEvaluateController(EvaluateBiz evaluate) {
        evaluateBiz = evaluate;
    }


    @RequestMapping(path = "/evaluate/list",method = RequestMethod.GET)
    public List<Evaluate> getEvaluateList(@RequestParam("cookies")String cookies){

        List<Evaluate>  evaluateList = evaluateBiz.getEvaluateList(cookies);

        return evaluateList;
    }

    @RequestMapping(path = "/evaluate/auto",method = RequestMethod.GET)
    public ModelAndView autoEvaluate(@RequestParam("cookies")String cookies,
                                     ModelAndView view,
                                     RedirectAttributes attributes){

        List<Evaluate> evaluateList =  getEvaluateList(cookies);
        int result = 0 ;
        for (Evaluate evaluate:evaluateList) {
            if(evaluate.getIsEvaluate().equals("是")){
                result++;
                continue;
            }
            if( evaluateBiz.autoEvaluate(cookies,evaluate) == ResultConfig.STATIC_RESULT_SUCCESS){
                result++;
            }
        }

        attributes.addFlashAttribute("result","一共"
                        +evaluateList.size()
                        +"位老师，已自动评教"
                        +result+"位,如有问题请检查教务处或者重新登陆");
        view.setViewName("redirect:/front/login");
        attributes.addFlashAttribute("evaluateResult",0);
//        view.addObject("",0);
        return view;
    }

}
