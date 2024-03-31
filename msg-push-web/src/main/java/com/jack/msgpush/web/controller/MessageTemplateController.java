package com.jack.msgpush.web.controller;

import com.jack.msgpush.support.domin.MessageTemplate;
import com.jack.msgpush.web.service.MessageTemplateService;
import com.jack.msgpush.web.vo.MessageTemplateParam;
import com.jack.msgpush.web.vo.MessageTemplateVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/query/{id}")
    @Operation(summary = "根据id查询")
    public MessageTemplate queryById(@PathVariable("id") Long id) {
        return messageTemplateService.queryById(id);
    }

    @GetMapping("/query/list")
    @Operation(summary = "列表查询")
    public MessageTemplateVo queryList(@Validated MessageTemplateParam messageTemplateParam) {
        Page<MessageTemplate> messageTemplates = messageTemplateService.queryList(messageTemplateParam);
        return MessageTemplateVo.builder().rows(messageTemplates.toList()).count(messageTemplates.getTotalElements()).build();
    }
}
