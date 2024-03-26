package com.jack.msgpush.web.service.impl;

import cn.hutool.core.date.DateUtil;
import com.jack.msgpush.common.constant.CommonConstant;
import com.jack.msgpush.support.dao.MessageTemplateDao;
import com.jack.msgpush.support.domin.MessageTemplate;
import com.jack.msgpush.web.service.MessageTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageTemplateServiceImpl implements MessageTemplateService {

    @Autowired
    private MessageTemplateDao messageTemplateDao;

    @Override
    public MessageTemplate saveOrUpdate(MessageTemplate messageTemplate) {
        if (messageTemplate.getId() == null) {
            messageTemplate.setIsDeleted(CommonConstant.FALSE);
            messageTemplate.setCreated(Math.toIntExact(DateUtil.currentSeconds()));
        }

        messageTemplate.setUpdated(Math.toIntExact(DateUtil.currentSeconds()));
        return messageTemplateDao.save(messageTemplate);
    }

}
