package com.lmx.myshop.commons.dto;

import org.springframework.stereotype.Component;

import java.io.Serializable;
@Component
public class BaseResult  implements Serializable {
        public static final int  STATUS_SUCCESS=200;
        public static final int STATUS_FAIL =500;

        private int Status;
        private String message;
        private Object data;


     public static BaseResult success() {
        return BaseResult.createBaseResult(STATUS_SUCCESS, "成功", null);
    }

    public static BaseResult success(String message) {
        return BaseResult.createBaseResult(STATUS_SUCCESS, message, null);
    }

    public static BaseResult success(String message, Object data) {
        return BaseResult.createBaseResult(STATUS_SUCCESS, message, data);
    }

        public static BaseResult fail(){
            return BaseResult.createBaseResult(STATUS_FAIL,"失败",null);
        }
        public static BaseResult fail(String message){
            return BaseResult.createBaseResult(STATUS_FAIL,message,null);
        }
        public static BaseResult fail(int status, String message){
            return BaseResult.createBaseResult(status,message,null);
        }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    public void setData(Object data) {
        this.data = data;
    }

    //重构重复代码
    private  static BaseResult createBaseResult(int status,String message,Object data){
        BaseResult  baseResult=new BaseResult();
        baseResult.setStatus(status);
        baseResult.setMessage(message);
        baseResult.setData(data);
        return baseResult;
    }


    public Object getData() {
        return data;
    }
}
