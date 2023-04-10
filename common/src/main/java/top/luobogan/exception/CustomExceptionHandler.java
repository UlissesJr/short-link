package top.luobogan.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import top.luobogan.util.JsonData;

/**
 * @Description
 * @Version 1.0
 **/

@RestControllerAdvice
@Slf4j
public class CustomExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public JsonData handler(Exception e){
        if(e instanceof BizException){
            BizException bizException = (BizException) e;
            log.error("[业务异常]{}",e);
            return JsonData.buildCodeAndMsg(bizException.getCode(),bizException.getMsg());
        }else {
            log.error("[系统异常]{}",e);
            return JsonData.buildError("系统异常");
        }
    }
}
