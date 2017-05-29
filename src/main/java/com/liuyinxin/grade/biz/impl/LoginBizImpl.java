package com.liuyinxin.grade.biz.impl;

import com.liuyinxin.grade.biz.LoginBiz;
import com.liuyinxin.grade.config.PathConfig;
import com.liuyinxin.grade.dto.Captcha;
import com.liuyinxin.grade.exception.BizException;
import com.liuyinxin.grade.utils.http.CaptchaUtils;
import com.liuyinxin.grade.utils.http.RequestUtils;
import com.liuyinxin.grade.utils.re.ReUtils;
import org.apache.http.HttpException;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author LiuYinXin
 * Created at 2017/5/27.20:46.
 */
@Service
public class LoginBizImpl implements LoginBiz {


    private static final Logger log = Logger.getLogger(LoginBizImpl.class);

    /**
     * @param user
     * @param password
     * @param captcha
     * @param cookies
     * @return
     */
    @Override
    public String login(String user, String password, String captcha, String cookies) {

//        设置请求头
//        zjh=2016005906&mm=283617&v_yzm=54d1
        Map<String,String> data = new HashMap<>();
        data.put("zjh",user);
        data.put("mm",password);
        data.put("v_yzm",captcha);
        Map<String,String>header = new HashMap<>();
        header.put("Cookie",cookies);

//        post 方法请求登录页
        String loginPath = PathConfig.getIndex()+PathConfig.getLoginPath();
        String loginResult = null;
        try {
            loginResult = RequestUtils.post(loginPath,header,data);
        } catch (HttpException e) {
            e.printStackTrace();
        }
//        判断是否登陆成功，如果没有登陆成功，则重定向到首页。
        String loginPattern = "<title>学分制综合教务</title>";
        if(!ReUtils.isLoginSuccess(loginResult,loginPattern)){

            throw new BizException("用户名或密码错误，请重试");

        }
        return cookies;
    }

    @Override
    public Captcha getCaptcha() {
        System.out.println("请求验证码");
        String captchaPath = PathConfig.getIndex()+PathConfig.getCaptchaPath();
        Captcha captcha = null;
        try {
            captcha = CaptchaUtils.requestCaptcha(captchaPath);
        } catch (HttpException e) {
            //如果请求异常，返回空值
            log.error(e.getMessage());
            return null;
        }
        String imgUrl = captcha.getSavePath();
        String img = imgUrl.replace(PathConfig.getCaptchaSavePath(),"");
        captcha.setSavePath(img);
        return captcha;
    }
}
