package com.tianyao.xiaolu.bean.response;

import java.io.Serializable;

/**
 * Created by xiaolu
 * on 2018/9/18
 */
public class ResponseResult<T> implements Serializable {

    /**
     * result falg
     */
    private int result;
    /**
     * result data
     */
    private T data;
    /**
     * result msg
     */
    private String msg;

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
