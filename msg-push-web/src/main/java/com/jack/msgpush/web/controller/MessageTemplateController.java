package com.jack.msgpush.web.controller;

import com.jack.msgpush.support.domin.MessageTemplate;
import com.jack.msgpush.web.service.MessageTemplateService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 消息模板管理controller
 */
@Slf4j
@RestController
@RequestMapping("/messageTemplate")
@Tag(name = "消息模板")
public class MessageTemplateController {

    @Autowired
    private MessageTemplateService messageTemplateService;

    @PostMapping("/save")
    @Operation(summary = "保存数据")
    public MessageTemplate save(@RequestBody MessageTemplate messageTemplate) {
        return messageTemplateService.saveOrUpdate(messageTemplate);
    }


}
