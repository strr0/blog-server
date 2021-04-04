package com.example.demo.common;

/**
 * 结果封装
 * @author STRR
 * @param <T>
 */
public class CommonResult<T> {
    private int code;
    private String message;
    private T data;

    protected CommonResult() { }

    protected CommonResult(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> CommonResult<T> success() {
        return new CommonResult<T>(200, "操作成功", null);
    }

    public static <T> CommonResult<T> success(T data) {
        return new CommonResult<T>(200, "操作成功", data);
    }

    public static <T> CommonResult<T> fail() {
        return new CommonResult<T>(500, "操作失败", null);
    }

    public void setCode(int code) {
        this.code = code;
    }
    public int getCode() {
        return code;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
    public void setData(T data) {
        this.data = data;
    }
    public T getData() {
        return data;
    }
}
