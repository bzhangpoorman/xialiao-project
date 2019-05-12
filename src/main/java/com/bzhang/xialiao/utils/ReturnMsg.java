package com.bzhang.xialiao.utils;

/**
 * 返回消息，用于客户端响应的数据结构
 * status：
 * 1.200：表示成功。
 * 2.500：表示错误，错误信息在msg字段中。
 * Created by bzhang on 2019/5/9.
 */
public class ReturnMsg<T> {
      public static final int OK = 200;
      public static final int ERR = 500;
      public static final String SUCCESS = "ok";

      private int status;
      private String msg;
      private T data;

      public static ReturnMsg build(int status,String msg, Object data){
            return new ReturnMsg(status,msg,data);
      }

      public static ReturnMsg ok(Object data){
            return new ReturnMsg(data);
      }

      public static ReturnMsg err(String msg){
            return new ReturnMsg(msg);
      }

      public ReturnMsg(int status, String msg, T data) {
            this.status = status;
            this.msg = msg;
            this.data = data;
      }

      private ReturnMsg(T data) {
            this(OK,SUCCESS,data);
      }

      private ReturnMsg(String msg) {
            this(ERR,msg,null);
      }

      public ReturnMsg() {
      }

      public int getStatus() {
            return status;
      }

      public void setStatus(int status) {
            this.status = status;
      }

      public String getMsg() {
            return msg;
      }

      public void setMsg(String msg) {
            this.msg = msg;
      }

      public T getData() {
            return data;
      }

      public void setData(T data) {
            this.data = data;
      }
}
