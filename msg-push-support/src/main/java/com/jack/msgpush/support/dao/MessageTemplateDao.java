package com.jack.msgpush.support.dao;

import com.jack.msgpush.support.domin.MessageTemplate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * 消息模板Dao
 */
public interface MessageTemplateDao extends JpaRepository<MessageTemplate, Long>, JpaSpecificationExecutor<MessageTemplate> {


}
