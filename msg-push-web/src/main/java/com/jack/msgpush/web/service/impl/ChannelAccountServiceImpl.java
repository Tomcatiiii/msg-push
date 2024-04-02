package com.jack.msgpush.web.service.impl;

import cn.hutool.core.date.DateUtil;
import com.jack.msgpush.common.constant.CommonConstant;
import com.jack.msgpush.support.dao.ChannelAccountDao;
import com.jack.msgpush.support.domin.ChannelAccount;
import com.jack.msgpush.web.service.ChannelAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;

@Service
public class ChannelAccountServiceImpl implements ChannelAccountService {

    @Autowired
    private ChannelAccountDao channelAccountDao;

    @Override
    public ChannelAccount saveOrUpdate(ChannelAccount channelAccount) {
        if (channelAccount.getId() == null) {
            channelAccount.setIsDeleted(CommonConstant.FALSE);
            channelAccount.setCreated(Math.toIntExact(DateUtil.currentSeconds()));
        }

        channelAccount.setUpdated(Math.toIntExact(DateUtil.currentSeconds()));
        return channelAccountDao.save(channelAccount);
    }

    @Override
    public ChannelAccount queryById(Long id) {
        return channelAccountDao.findById(id).orElse(null);
    }

    @Override
    public ChannelAccount queryByChannelType(Integer channelType) {
        return channelAccountDao.findAllBySendChannelEquals(channelType);
    }
}
