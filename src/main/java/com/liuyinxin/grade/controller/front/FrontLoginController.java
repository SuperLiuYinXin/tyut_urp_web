package com.liuyinxin.grade.controller.front;

import com.liuyinxin.grade.biz.LoginBiz;
import com.liuyinxin.grade.dto.Captcha;
import com.liuyinxin.grade.exception.BizException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


/**
 * @Author LiuYinXin
 * Created at 2017/5/27.13:37.
 */
@Controller
@RequestMapping("/front")
public class FrontLoginController {


    private static final Logger log = Logger.getLogger(FrontLoginController.class);

    @Autowired
    private LoginBiz loginBiz;

    @GetMapping("/login")
    public ModelAndView frontLogin( ModelAndView view){
        System.out.println("进入到登陆页");

        //获取验证码
        Captcha captcha =null;
        try {
            captcha =  loginBiz.getCaptcha();
        }catch (Exception e){
            log.error(e.getMessage());
            view.setViewName("/front/login");
            view.addObject("error","获取不到验证码啊！刷新吧");
        }
        String imgUrl = captcha.getSavePath();
        view.addObject("imgUrl",imgUrl);
        view.addObject("cookies",captcha.getCookies());
        view.setViewName("/front/login");
        return view;
    }

    @RequestMapping(path= "/login",method = RequestMethod.POST)
    public ModelAndView frontLogin(@RequestParam("user")String user,
                              @RequestParam("password")String password,
                              @RequestParam("captcha")String captcha,
                              @RequestParam("cookies")String cookies,
                              ModelAndView view,
                              RedirectAttributes attributes){

        String cookie = null;
        try {
            cookie =  loginBiz.login(user,password,captcha,cookies);
        }catch (BizException e){
            //如果登陆失败
//            view.setViewName("redirect:/front/login");
//            attributes.addAttribute("loginFail",e.getErrorMessage());
            view.addObject("loginFail",e.getMessage());
            return frontLogin(view);
        }
//        TODO 制作菜单页面
//        view.setViewName("redirect:/front/menu");
//        attributes.addFlashAttribute("cookies",cookies);
        view.setViewName("redirect:/front/evaluate/auto");
        attributes.addAttribute("cookies",cookies);
        return view;
    }


}
