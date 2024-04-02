package com.jack.msgpush.common.dto;

import com.jack.msgpush.common.dto.ContentModel;
import lombok.Data;

@Data
public class EmailContentModel extends ContentModel {

    /**
     * 标题
     */
    private String title;

    /**
     * 发送内容
     */
    private String content;

    /**
     * 邮件附件链接
     */
    private String url;
}
