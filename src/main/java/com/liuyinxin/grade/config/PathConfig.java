package com.liuyinxin.grade.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 学校配置
 * @Author LiuYinXin
 * Created at 2017/5/18.11:49.
 */
//加载前缀为path的路径
@ConfigurationProperties(prefix = "path")
@Configuration
public class PathConfig {

    //学校首页ip
    public static String  index;

    //验证码请求地址
    public static String captchaPath;

    //文件保存基础地址
    public static String basePath;
    //验证码保存基础地址
    public static String captchaSavePath;
    //登陆地址
    public static String loginPath;

    public static String gradePath;

    //教学评估列表页
    public static String evaluateListPath;

    //教学评估列提交
    public static String evaluatePostPath;

    //教学评估列提交
    public static String evaluateDetailPath;



//    //成绩列表页面
//    public static final String GRADE_PATH="http://202.207.247.49/gradeLnAllAction.do?type=ln&oper=qbinfo";
//
//    //没有通过的成绩列表页面
//    public static final String UNPASS_GRADE_PATH="/gradeLnAllAction.do?type=ln&oper=bjg";
//
//    public static final String SCHOOL_HOST = "http://202.207.247.49";
//
//    public static final String  SCHOOL_INDEX = "http://202.207.247.49/";
//
//    public static final String  LOGIN_PATH= "http://202.207.247.49/loginAction.do";
//
////    public static final String CAPTCHA_PATH = "http://202.207.247.49/validateCodeAction.do?random=0.501631743124658";
//
//    public static final String CAPTCHA_SAVE_PATH = "E:\\code\\javaCode\\wechat\\src\\main\\resources\\static";
//


    public static String getIndex() {
        return index;
    }

    public static void setIndex(String index) {
        PathConfig.index = index;
    }

    public static String getCaptchaPath() {
        return captchaPath;
    }

    public static void setCaptchaPath(String captchaPath) {
        PathConfig.captchaPath = captchaPath;
    }

    public static String getBasePath() {
        return basePath;
    }

    public static void setBasePath(String basePath) {
        PathConfig.basePath = basePath;
    }

    public static String getCaptchaSavePath() {
        return captchaSavePath;
    }

    public static void setCaptchaSavePath(String captchaSavePath) {
        PathConfig.captchaSavePath = captchaSavePath;
    }

    public static String getLoginPath() {
        return loginPath;
    }

    public static void setLoginPath(String loginPath) {
        PathConfig.loginPath = loginPath;
    }

    public static String getGradePath() {
        return gradePath;
    }

    public static void setGradePath(String gradePath) {
        PathConfig.gradePath = gradePath;
    }

    public static String getEvaluateListPath() {
        return evaluateListPath;
    }

    public static void setEvaluateListPath(String evaluateListPath) {
        PathConfig.evaluateListPath = evaluateListPath;
    }

    public static String getEvaluatePostPath() {
        return evaluatePostPath;
    }

    public static void setEvaluatePostPath(String evaluatePostPath) {
        PathConfig.evaluatePostPath = evaluatePostPath;
    }

    public static String getEvaluateDetailPath() {
        return evaluateDetailPath;
    }

    public static void setEvaluateDetailPath(String evaluateDetailPath) {
        PathConfig.evaluateDetailPath = evaluateDetailPath;
    }
}
