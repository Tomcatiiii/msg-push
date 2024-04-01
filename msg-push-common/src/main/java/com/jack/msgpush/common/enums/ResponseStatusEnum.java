package com.jack.msgpush.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResponseStatusEnum {

    /**
     * 错误
     */
    ERROR_500("500", "服务器未知错误"),
    ERROR_400("400", "错误请求"),

    /**
     * OK：操作成功
     */
    SUCCESS("0", "操作成功"),
    FAIL("-1", "操作失败"),
    ;



    /**
     * 响应状态
     */
    private final String code;

    /**
     * 响应信息
     */
    private final String msg;
}
