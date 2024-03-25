DROP DATABASE IF EXISTS msg;

CREATE DATABASE msg;

USE msg;

DROP TABLE IF EXISTS message_template;

CREATE TABLE `message_template`
(
    `id`            BIGINT NOT NULL AUTO_INCREMENT,
    `name`          VARCHAR(100) NOT NULL DEFAULT '' COMMENT '标题',
    `send_channel`  TINYINT NOT NULL DEFAULT '0' COMMENT '消息发送渠道：1.Email 2.短信',
    `msg_content`   VARCHAR(4096) NOT NULL DEFAULT '' COMMENT '消息发送内容 占位符用{$var}表示',
    `shield_type`   TINYINT NOT NULL DEFAULT '0' COMMENT '1.夜间不屏蔽 2.夜间屏蔽 3.夜间屏蔽(次日早上9点发送)',
    `is_deleted`    BIT(1)       NOT NULL DEFAULT b'0' COMMENT '是否删除：0.不删除 1.删除',
    `created`       INT NOT NULL DEFAULT '0' COMMENT '创建时间',
    `updated`       INT NOT NULL DEFAULT '0' COMMENT '更新时间',

    PRIMARY KEY (`id`),
    INDEX `idx_send_channel` (`send_channel`)
) ENGINE = InnoDB AUTO_INCREMENT = 1 DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT ='消息模板信息';


drop table IF EXISTS channel_account;

CREATE TABLE `channel_account`
(
    `id`            BIGINT NOT NULL AUTO_INCREMENT,
    `name`          VARCHAR(100) NOT NULL DEFAULT '' COMMENT '账号名称',
    `send_channel`  TINYINT NOT NULL DEFAULT '0' COMMENT '消息发送渠道：1.Email 2.短信',
    `account_config`   VARCHAR(4096) NOT NULL DEFAULT '' COMMENT '账号配置',
    `is_deleted`    BIT(1)       NOT NULL DEFAULT b'0' COMMENT '是否删除：0.不删除 1.删除',
    `created`       INT NOT NULL DEFAULT '0' COMMENT '创建时间',
    `updated`       INT NOT NULL DEFAULT '0' COMMENT '更新时间',

    PRIMARY KEY (`id`),
    INDEX `idx_send_channel` (`send_channel`)
) ENGINE = InnoDB AUTO_INCREMENT = 1 DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT ='发送渠道账号配置';
