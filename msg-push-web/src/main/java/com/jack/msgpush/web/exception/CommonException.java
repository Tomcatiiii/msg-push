package com.jack.msgpush.web.exception;

import com.jack.msgpush.common.enums.ResponseStatusEnum;
import lombok.Getter;

@Getter
public class CommonException extends RuntimeException{

    private String code = ResponseStatusEnum.ERROR_400.getCode();

    private ResponseStatusEnum status = null;

    public CommonException(String msg) {
        super(msg);
    }

    public CommonException(ResponseStatusEnum status) {
        super(status.getMsg());
        this.code = status.getCode();
        this.status = status;
    }

    public CommonException(String msg, String code) {
        super(msg);
        this.code = code;
    }

    public CommonException(String msg, String code, ResponseStatusEnum status) {
        super(msg);
        this.code = code;
        this.status = status;
    }
}
