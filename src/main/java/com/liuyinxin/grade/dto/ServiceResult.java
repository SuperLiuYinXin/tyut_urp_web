package com.liuyinxin.grade.dto;

/**
 * 响应结果
 * @Author LiuYinXin
 * Created at 2017/5/25.20:47.
 */
public class ServiceResult {

    private int status;

    private Object result;

    public ServiceResult() {
    }

    public ServiceResult(int status, Object result) {
        this.status = status;
        this.result = result;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
