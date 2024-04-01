package com.jack.msgpush.web.vo;

import com.jack.msgpush.support.domin.MessageTemplate;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class MessageTemplateVO {
    private List<MessageTemplate> rows;

    private Long count;
}
