package com.liuyinxin.grade.exception;

import java.io.IOException;

/**
 * @Author LiuYinXin
 * Created at 2017/5/17.10:52.
 */
public class DownLoadFileException extends IOException{


    private String errorMessage ;

    public DownLoadFileException(){
        super("下载文件时出现未知错误");
    }

    public DownLoadFileException(String errorMessage){
        super(errorMessage);
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
