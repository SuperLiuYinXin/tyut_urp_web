package com.liuyinxin.grade.biz;

import com.liuyinxin.grade.dto.Captcha;

/**
 * @Author LiuYinXin
 * Created at 2017/5/27.20:46.
 */
public interface LoginBiz {

    /**
     *
     * @param user
     * @param password
     * @param captcha
     * @param cookies
     * @return
     */
    String login(String user,String password,String captcha,String cookies);


    /*
     * 获取验证码并且保存
     * @return
     */
    Captcha getCaptcha();
}
