package com.jack.msgpush.common.vo;

import com.jack.msgpush.common.enums.ResponseStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public final class BasicResultVO<T> {

    /**
     * 响应状态
     */
    private String status;

    /**
     * 响应信息
     */
    private String msg;

    /**
     * 返回数据
     */
    private T data;

    public BasicResultVO(String status, String msg) {
        this.status = status;
        this.msg = msg;
    }
    public BasicResultVO(ResponseStatusEnum statusEnum) {
        this(statusEnum, null);
    }

    public BasicResultVO(ResponseStatusEnum status, T data) {
        this(status, status.getMsg(), data);
    }

    public BasicResultVO(ResponseStatusEnum status, String msg, T data) {
        this.status = status.getCode();
        this.msg = msg;
        this.data = data;
    }

    /**
     * 默认成功响应
     * @return
     */
    public static BasicResultVO<Void> success() {
        return new BasicResultVO<>(ResponseStatusEnum.SUCCESS);
    }

    /**
     * 自定义响应信息的成功响应
     * @param msg
     * @return
     * @param <T>
     */
    public static <T> BasicResultVO<T> success(String msg) {
        return new BasicResultVO<>(ResponseStatusEnum.SUCCESS, msg, null);
    }

    /**
     * 带数据的成功响应
     * @param data
     * @return
     * @param <T>
     */
    public static <T> BasicResultVO<T> success(T data) {
        return new BasicResultVO<>(ResponseStatusEnum.SUCCESS, data);
    }

    /**
     * 默认失败响应
     * @return
     */
    public static <T> BasicResultVO<T> fail() {
        return new BasicResultVO<>(ResponseStatusEnum.FAIL);
    }

    /**
     * 自定义响应信息的失败响应
     * @param msg
     * @return
     * @param <T>
     */
    public static <T> BasicResultVO<T> fail(String msg) {
        return new BasicResultVO<>(ResponseStatusEnum.FAIL, msg, null);
    }

    /**
     * 自定义状态的失败响应
     * @param status
     * @return
     * @param <T>
     */
    public static <T> BasicResultVO<T> fail(ResponseStatusEnum status) {
        return new BasicResultVO<>(status, status.getMsg(), null);
    }


    /**
     * 自定义状态和响应信息的失败响应
     * @param status
     * @return
     * @param <T>
     */
    public static <T> BasicResultVO<T> fail(ResponseStatusEnum status, String msg) {
        return new BasicResultVO<>(status, msg, null);
    }
}
