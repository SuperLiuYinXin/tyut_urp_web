package com.liuyinxin.grade.exception;

/**
 * @Author LiuYinXin
 * Created at 2017/5/27.0:03.
 */
public class EvaluateException extends RuntimeException {

    private String errorMessage;

    public EvaluateException() {
        super("评教时出现错误");
    }

    public EvaluateException(String errorMessage) {
        super(errorMessage);
    }

    public String getErrorMessage() {
        return errorMessage;
    }


    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
