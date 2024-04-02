package com.jack.msgpush.common.enums;

import com.jack.msgpush.common.dto.ContentModel;
import com.jack.msgpush.common.dto.EmailContentModel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Objects;

@Getter
@AllArgsConstructor
public enum ChannelTypeEnum {
    EMAIL(1, "电子邮件", EmailContentModel.class, "email");




    private final Integer code;

    private final String desc;

    private final Class<? extends ContentModel> contentModelClass;

    private final String codeEn;


    public static Class<? extends ContentModel> getChannelModelClassByCode(Integer code) {
        return Arrays.stream(values())
                .filter(channelType -> Objects.equals(code, channelType.getCode()))
                .map(ChannelTypeEnum::getContentModelClass)
                .findFirst().orElse(null);
    }
}
