package com.liuyinxin.grade.controller.front;

import com.liuyinxin.grade.biz.GradeBiz;
import com.liuyinxin.grade.dto.Term;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Author LiuYinXin
 * Created at 2017/5/27.13:32.
 */

@Controller
@RequestMapping("/front")
public class FrontGradeController {

    @Autowired
    private GradeBiz gradeBiz;

    @RequestMapping(path = "/grade",method = RequestMethod.GET)
    public ModelAndView getGradeList(@RequestParam("cookies")String cookies,
                                     ModelAndView view){
        List<Term>  terms = gradeBiz.getGradeList(cookies);
        if(terms==null || terms.size()<=0){
            view.addObject("error","获取成绩失败");
        }
        view.addObject("terms",terms);
        view.setViewName("/front/gradeList");
        return view;

    }

}
