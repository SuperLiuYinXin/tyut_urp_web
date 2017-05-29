package com.liuyinxin.grade.exception;

/**
 * @Author LiuYinXin
 * Created at 2017/5/27.0:24.
 */
public class BizException extends RuntimeException {

    private String errorMessage;

    public BizException() {
        super("Biz出现错误");
    }

    public BizException(String errorMessage) {
        super(errorMessage);
    }

    public String getErrorMessage() {
        return errorMessage;
    }


    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}

