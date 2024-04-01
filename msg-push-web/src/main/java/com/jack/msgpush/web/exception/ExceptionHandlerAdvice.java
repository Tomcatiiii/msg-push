package com.jack.msgpush.web.exception;


import com.jack.msgpush.common.enums.ResponseStatusEnum;
import com.jack.msgpush.common.vo.BasicResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.assertj.core.util.Throwables;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


/**
 * 异常处理
 */
@Slf4j
@ControllerAdvice(basePackages = "com.jack.msgpush.web.controller")
@ResponseBody
public class ExceptionHandlerAdvice {

    @ExceptionHandler({Exception.class})
    public BasicResultVO<String> exceptionResponse(Exception e) {
        log.error(Throwables.getStackTrace(e));
        return BasicResultVO.fail(ResponseStatusEnum.ERROR_500, "\r\n" + Throwables.getStackTrace(e) + "\r\n");
    }


    @ExceptionHandler({CommonException.class})
    public BasicResultVO<ResponseStatusEnum> commonResponse(CommonException e) {
        log.error(Throwables.getStackTrace(e));
        return new BasicResultVO<>(e.getCode(), e.getMessage(), e.getStatus());
    }
}
