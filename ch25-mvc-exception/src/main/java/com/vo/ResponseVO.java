package com.vo;

/**
 * @author cj
 * @date 2019/11/18
 */
public class ResponseVO {

    private String code;
    private String msg;
    private Object data;

    public static ResponseVO success(String msg, Object data) {
        return new ResponseVO("200", "success", data);
    }


    public static ResponseVO fail(String msg, Object data) {
        return new ResponseVO("500", "failed", data);
    }


    public ResponseVO() {
    }

    public ResponseVO(String msg, Object data) {
        this.msg = msg;
        this.data = data;
    }

    public ResponseVO(String code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResponseVO{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
