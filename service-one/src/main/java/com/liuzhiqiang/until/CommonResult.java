package com.liuzhiqiang.until;

/**
 * Created by HoldCourt on 2017/6/12.
 */


import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

/**
 * 开发公司：青岛上朝信息科技有限公司
 * 版权：青岛上朝信息科技有限公司
 *
 * 包装http请求的返回
 * @author anming
 * @created 2018/2/26.
 */
public class CommonResult<T> implements Serializable {

    private boolean success = true;
    /**
     * app 暂定code 等于3 是过期重新登录
     */
    private Integer code;
    private String message;
    private String msg;
    private T data;
    private Integer total;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return StringUtils.isNoneEmpty(this.msg) ? this.msg : this.message;
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

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    /**
     * 请求成功
     *
     * @return
     */
    public static <T> CommonResult<T> successReturn() {
        return successReturn(null,null,"ok");
    }

    /**
     * 请求成功
     *
     * @param data 要返回的数据
     * @return
     */
    public static <T> CommonResult<T> successReturn(T data) {
        return successReturn(data, null, null);
    }

    /**
     * 请求成功
     *
     * @param data 要返回的数据
     * @param total 数据总数
     * @return
     */
    public static <T> CommonResult<T> successReturn(T data, Integer total) {
        return successReturn(data, total, null);
    }

    /**
     * 请求成功
     *
     * @param data 要返回的数据
     * @param message 要返回的信息
     * @return
     */
    public static <T> CommonResult<T> successReturn(T data, String message) {
        return successReturn(data, null, message);
    }

    /**
     * 请求成功
     *
     * @param data 要返回的数据
     * @param total 数据总数
     * @param message 要返回的信息
     * @return
     */
    public static <T> CommonResult<T> successReturn(T data, Integer total, String message) {
        CommonResult<T> result = new CommonResult<T>();
        result.setSuccess(true);
        result.setCode(0);
        result.setMessage(message);
        result.setMsg(message);
        result.setData(data);
        result.setTotal(total);
        return result;
    }

    /**
     * 请求失败
     *
     * @param message 错误信息
     * @return
     */
    public static <T> CommonResult<T> errorReturn(String message) {
        return errorReturn(505, message);
    }

    /**
     * 请求失败
     *
     * @param code 错误码
     * @param message 错误信息
     * @return
     */
    public static <T> CommonResult<T> errorReturn(Integer code, String message) {
        CommonResult<T> result = new CommonResult<T>();
        result.setSuccess(false);
        result.setCode(code);
        result.setMessage(message);
        result.setMsg(message);
        result.setData(null);
        result.setTotal(null);
        return result;
    }
}
