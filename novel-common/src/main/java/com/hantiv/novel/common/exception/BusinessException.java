package com.hantiv.novel.common.exception;

import com.hantiv.novel.common.enums.ResponseStatus;
import lombok.Data;

/**
 * 自定义业务异常，用于处理用户请求时，业务错误时抛出
 * @author Zhikun Han
 * @version 1.0
 * @since 2022/5/23
 */
@Data
public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private String msg;
    private int code;

    public BusinessException(int code,String msg) {
        //不调用父类Throwable的fillInStackTrace()方法生成栈追踪信息，提高应用性能
        //构造器之间的调用必须在第一行
        super(msg, null, false, false);
        this.code = code;
        this.msg = msg;
    }

    private ResponseStatus resStatus;

    public BusinessException(ResponseStatus resStatus) {
        //不调用父类Throwable的fillInStackTrace()方法生成栈追踪信息，提高应用性能
        //构造器之间的调用必须在第一行
        super(resStatus.getMsg(), null, false, false);
        this.resStatus = resStatus;
    }

}
