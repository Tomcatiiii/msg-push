package com.jack.msgpush.support.domin;


import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Entity
@Data
@Accessors(chain = true)
public class MessageTemplate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 模板名称
     */
    private String name;

    /**
     * 发送渠道
     */
    private Integer sendChannel;

    /**
     * 消息内容
     */
    private String msgContent;

    /**
     * 屏蔽类型
     */
    private Integer shieldType;

    /**
     * 是否删除
     * 0：未删除
     * 1：已删除
     */
    private Integer isDeleted;

    /**
     * 创建时间 单位 s
     */
    private Integer created;

    /**
     * 更新时间 单位s
     */
    private Integer updated;
}
