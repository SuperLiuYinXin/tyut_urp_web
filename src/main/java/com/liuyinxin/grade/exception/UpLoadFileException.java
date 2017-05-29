package com.liuyinxin.grade.exception;

import java.io.IOException;

/**
 * @Author LiuYinXin
 * Created at 2017/5/17.10:52.
 */
public class UpLoadFileException extends IOException{


    private String errorMessage ;

    public UpLoadFileException(){
        super("上传文件时出现未知错误");
    }

    public UpLoadFileException(String errorMessage){
        super(errorMessage);
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
