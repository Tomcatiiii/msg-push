package com.jack.msgpush.web.service;

import com.jack.msgpush.support.domin.ChannelAccount;

public interface ChannelAccountService {
    ChannelAccount saveOrUpdate(ChannelAccount channelAccount);

    ChannelAccount queryById(Long id);

    ChannelAccount queryByChannelType(Integer channelType);
}
