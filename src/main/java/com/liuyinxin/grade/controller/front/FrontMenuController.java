package com.liuyinxin.grade.controller.front;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author LiuYinXin
 * Created at 2017/5/27.13:49.
 */
@Controller
@RequestMapping("/front")
public class FrontMenuController {

    @GetMapping("/menu")
    public ModelAndView showMenu( ModelAndView view){

//        view.addObject("cookies",cookies);
        view.setViewName("/front/menu");
        return view;
    }


}
