package cn.edu.jxnu.rj.lrf.common;

/**
 * @InterfaceName ErrorEnum
 * @Description TODO 异常类
 * @Date 2021/5/9 9:29
 * @Created by 刘荣飞
 */
public enum ErrorCodeEnum {
    //通用异常
    UNDEFINED_ERROR(0,"请求的数据未定义"),
    PARAMETER_ERROR(1,"请求参数异常"),

    //用户异常
    USER_NOT_LOGIN(101,"用户未登录"),
    USER_LOGIN_FAILURE(102,"用户登录失败"),

    //业务异常
    STOCK_NOT_ENOUGH(201,"库存不足"),
    CREATE_ORDER_FAILURE(202,"创建订单失败"),
    OUT_OF_LIMIT(203,"超出限制");

    private Integer code;
    private String msg;
    ErrorCodeEnum(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
