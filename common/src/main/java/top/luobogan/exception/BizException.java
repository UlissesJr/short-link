package top.luobogan.exception;

import lombok.Data;
import top.luobogan.enums.BizCodeEnum;

/**
 * 自定义异常
 * @Description
 * @Version 1.0
 **/

@Data
public class BizException extends RuntimeException {

    private int code;

    private String msg;

    public BizException(Integer code, String message) {
        super(message);
        this.code = code;
        this.msg = message;
    }

    public BizException(BizCodeEnum bizCodeEnum){
        super(bizCodeEnum.getMessage());
        this.code = bizCodeEnum.getCode();
        this.msg = bizCodeEnum.getMessage();
    }

}
