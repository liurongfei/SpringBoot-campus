package cn.edu.jxnu.rj.lrf.common;

/**
 * @title: BusinessException
 * @description:
 * @Author liu rong fei
 * @Date: 2021/3/28 14:31
 */
public class BusinessException extends RuntimeException{

    private int code;
    private String message;

    public BusinessException(int code) {
        super();
        this.code = code;
    }

    public BusinessException(int code, String message) {
        super();
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "BusinessException{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
