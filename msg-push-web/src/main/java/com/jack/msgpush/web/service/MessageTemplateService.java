package com.jack.msgpush.web.service;

import com.jack.msgpush.support.domin.MessageTemplate;

public interface MessageTemplateService {

    /**
     * 保存或者更新
     * @param messageTemplate
     * @return
     */
    MessageTemplate saveOrUpdate(MessageTemplate messageTemplate);

}
