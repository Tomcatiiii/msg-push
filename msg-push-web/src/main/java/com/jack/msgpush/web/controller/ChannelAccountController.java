package com.jack.msgpush.web.controller;

import com.jack.msgpush.support.domin.ChannelAccount;
import com.jack.msgpush.web.annotation.BasicResult;
import com.jack.msgpush.web.annotation.Monitor;
import com.jack.msgpush.web.service.ChannelAccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@BasicResult
@Monitor
@RequestMapping("/channelAccount")
@Tag(name = "渠道账号")
public class ChannelAccountController {

    @Autowired
    private ChannelAccountService channelAccountService;

    @PostMapping("/save")
    @Operation(summary = "保存数据")
    public ChannelAccount save(@RequestBody ChannelAccount channelAccount) {
        return channelAccountService.saveOrUpdate(channelAccount);
    }


    @GetMapping("/query/id")
    @Operation(summary = "根据id查询")
    public ChannelAccount queryById(Long id) {
        return channelAccountService.queryById(id);
    }

    @GetMapping("/query/channelType")
    @Operation(summary = "根据类型查询")
    public ChannelAccount queryById(Integer channelType) {
        return channelAccountService.queryByChannelType(channelType);
    }
}
