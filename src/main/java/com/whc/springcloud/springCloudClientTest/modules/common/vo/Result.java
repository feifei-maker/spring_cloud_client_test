package com.whc.springcloud.springCloudClientTest.modules.common.vo;

/**
 * ClassName: Result <br/>
 * Description: <br/>
 * date: 2020/8/12 23:14<br/>
 *
 * @author FEI FEI<br/>
 * @since JDK 1.8
 */
public class Result<T> {
    private int status;
    private String message;
    private T object;

    public Result() {
    }

    public Result(int status, String message, T object) {
        this.status = status;
        this.message = message;
        this.object = object;
    }

    public Result(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }
    //枚举类
    public enum ResultStatus{
        SUCCESS(200),FAILED(500);
        public int status;

        ResultStatus(int status) {
            this.status = status;
        }
    }
}
