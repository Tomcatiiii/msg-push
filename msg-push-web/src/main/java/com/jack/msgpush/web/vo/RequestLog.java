package com.jack.msgpush.web.vo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class RequestLog {

    /**
     * 请求id
     */
    private String id;

    /**
     * 请求uri
     */
    @JSONField(ordinal = 1)
    private String uri;

    /**
     * 请求方法
     */
    @JSONField(ordinal = 2)
    private String method;

    /**
     * 请求参数
     */
    @JSONField(ordinal = 3)
    private Object[] args;

    /**
     * 类名 + 方法名
     */
    @JSONField(ordinal = 4)
    private String path;

    /**
     * 请求地址
     */
    @JSONField(ordinal = 5)
    private String remoteAddr;

    /**
     * 页面引用
     */
    @JSONField(ordinal = 6)
    private String referer;

    /**
     * 用户代理
     */
    @JSONField(ordinal = 7)
    private String userAgent;
}
