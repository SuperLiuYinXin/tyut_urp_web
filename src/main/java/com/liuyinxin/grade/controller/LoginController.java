package com.liuyinxin.grade.controller;

import com.liuyinxin.grade.biz.LoginBiz;
import com.liuyinxin.grade.config.ResultConfig;
import com.liuyinxin.grade.dto.Captcha;
import com.liuyinxin.grade.dto.ServiceResult;
import com.liuyinxin.grade.exception.BizException;
import com.liuyinxin.grade.exception.UpLoadFileException;
import com.liuyinxin.grade.utils.http.CaptchaUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

/**
 * @Author LiuYinXin
 * Created at 2017/5/26.21:22.
 */
@RestController
public class LoginController {

    private static final Logger log = Logger.getLogger(LoginController.class.getName());

    @Autowired
    private LoginBiz loginBiz;

    @RequestMapping(path = "/login",method = RequestMethod.GET)
    public ServiceResult login(@RequestParam("user")String user){

//        TODO
        return null;
    }


    @RequestMapping(path = "/login",method = RequestMethod.POST)
    public ServiceResult login(@RequestParam("user")String user,
                               @RequestParam("password")String password,
                               @RequestParam("captcha")String captcha,
                               @RequestParam("cookies")String cookies){

        try{
            String cookie =  loginBiz.login(user,password,captcha,cookies);
        }catch (BizException e){
            log.error(e.getMessage());
            return new ServiceResult(ResultConfig.STATIC_RESULT_ERROR,e.getErrorMessage());
        }
        return new ServiceResult(ResultConfig.STATIC_RESULT_SUCCESS,cookies);
//        设置请求头
//        zjh=2016005906&mm=283617&v_yzm=54d1
//        Map<String,String> data = new HashMap<>();
//        data.put("zjh",user);
//        data.put("mm",password);
//        data.put("v_yzm",captcha);
//        Map<String,String>header = new HashMap<>();
//        header.put("Cookie",cookies);

//        post 方法请求登录页
//        String loginPath = PathConfig.getIndex()+PathConfig.getLoginPath();
//        String loginResult = null;
//        try {
//            loginResult = RequestUtils.post(loginPath,header,data);
//        } catch (HttpException e) {
//            e.printStackTrace();
//        }
////        判断是否登陆成功，如果没有登陆成功，则重定向到首页。
//        String loginPattern = "<title>学分制综合教务</title>";
//        if(!ReUtils.isLoginSuccess(loginResult,loginPattern)){
//
////            view.addObject("isLoginSuccess",Boolean.FALSE);
//            return new ServiceResult(ResultConfig.STATIC_RESULT_ERROR,"用户名或密码错误，请重试");
//
//        }
//
////        String gradePath = PathConfig.getIndex()+PathConfig.getGradePath();
////        String gradeResult = null;
////        try {
////            gradeResult = RequestUtils.get(gradePath,header,"UTF-8");
////        } catch (HttpException e) {
////            e.printStackTrace();
////        }
//////        String pattern = "\\bcenter\\b.{1,3}>\\s*(\\d+\\.?\\d?|[\\u4e00-\\u9fa5].*)";
////        String pattern = "\\bcenter\\b.{1,3}>\\s*([a-zA-Z]{0,3}\\d+\\.?\\d?|[a-zA-Z]{0,10}[\\u4e00-\\u9fa5].*)";
//////        List<Grade> gradeList =  ReUtils.getGradeList(gradeResult,pattern);
////        List<Term> terms = ReUtils.getTermList(gradeResult,pattern,"<b>");
////
//////        view.addObject("terms",terms);
//////        view.setViewName("redirect:/grade/detail");
//////        attributes.addFlashAttribute("terms",terms);
//////        return view;
////        return new ServiceResult(ResultConfig.STATIC_RESULT_SUCCESS,terms);
    }

    @RequestMapping(path = "/captcha/{dir}/{name}",method = RequestMethod.GET)
    public void showCaptcha(@PathVariable("dir")int captchaPath,
                            @PathVariable("name")String captchaName,
                            HttpServletResponse response){

        StringBuilder path = new StringBuilder();
        path.append("/").append(captchaPath).append("/").append(captchaName).append(".jpg");
        try {
            CaptchaUtils.outPutCaptcha(response,path.toString());
        } catch (UpLoadFileException e) {
            log.error(e.getMessage());
        }
    }

    /**
     * 获取验证码并且保存
     * @return
     */
    @RequestMapping(path = "/captcha",method = RequestMethod.GET)
    public ServiceResult getCaptcha(){

        Captcha captcha = loginBiz.getCaptcha();
        if(captcha==null){
            return new ServiceResult(ResultConfig.STATIC_RESULT_ERROR,"验证码获取失败");
        }
        return new ServiceResult(ResultConfig.STATIC_RESULT_SUCCESS,captcha);
    }

}
