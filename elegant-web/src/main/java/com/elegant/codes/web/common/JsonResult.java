package com.elegant.codes.web.common;

import com.elegant.codes.common.constants.Constants;
import org.slf4j.MDC;

import java.io.Serializable;

public class JsonResult<T> implements Serializable {
    private static final String SUCCESS = "1";
    private static final String FAIL = "0";

    private static final long serialVersionUID = -4470859783453716909L;

    /**
     * 状态码
     */
    public String code;

    /**
     * 消息
     */
    private String message;

    /**
     * 数据
     */
    private T data;

    /**
     * 请求ID,只要api响应就一定会返回.
     * 注意: 这里的请求Id是取子日志框架生成的id,没有初始化时应该为空.
     */
    private final String requestTraceId = MDC.get(Constants.LOG_TRACE_ID);

    public JsonResult(){

    }

    public JsonResult(String code, String message){
        this.code = code;
        this.message = message;
    }

    public JsonResult(T data){
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getRequestTraceId() {
        return requestTraceId;
    }

    public static<T> JsonResult<T> error(String message){
        return new JsonResult(FAIL, message);
    }

    public static<T> JsonResult<T> success(String message){
        return new JsonResult(SUCCESS, message);
    }
}
