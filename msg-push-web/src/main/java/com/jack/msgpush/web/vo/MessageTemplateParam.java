package com.jack.msgpush.web.vo;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MessageTemplateParam {

    @NotNull
    private Integer page = 1;

    @NotNull
    private Integer pageSize = 10;
}
