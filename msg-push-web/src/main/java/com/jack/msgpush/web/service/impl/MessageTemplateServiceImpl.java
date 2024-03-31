package com.jack.msgpush.web.service.impl;

import cn.hutool.core.date.DateUtil;
import com.jack.msgpush.common.constant.CommonConstant;
import com.jack.msgpush.support.dao.MessageTemplateDao;
import com.jack.msgpush.support.domin.MessageTemplate;
import com.jack.msgpush.web.service.MessageTemplateService;
import com.jack.msgpush.web.vo.MessageTemplateParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

    @Override
    public MessageTemplate queryById(Long id) {
        return messageTemplateDao.findById(id).orElse(null);
    }

    @Override
    public Page<MessageTemplate> queryList(MessageTemplateParam param) {
        PageRequest pageRequest = PageRequest.of(param.getPage() - 1, param.getPageSize());
        return messageTemplateDao.findAll(pageRequest);
    }

}
