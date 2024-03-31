package com.jack.msgpush.web.service;

import com.jack.msgpush.support.domin.MessageTemplate;
import com.jack.msgpush.web.vo.MessageTemplateParam;
import org.springframework.data.domain.Page;

public interface MessageTemplateService {

    /**
     * 保存或者更新
     * @param messageTemplate
     * @return
     */
    MessageTemplate saveOrUpdate(MessageTemplate messageTemplate);

    MessageTemplate queryById(Long id);

    Page<MessageTemplate> queryList(MessageTemplateParam param);
}
