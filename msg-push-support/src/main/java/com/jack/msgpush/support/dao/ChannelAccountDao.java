package com.jack.msgpush.support.dao;

import com.jack.msgpush.support.domin.ChannelAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface ChannelAccountDao extends JpaRepository<ChannelAccount, Long>, JpaSpecificationExecutor<ChannelAccount> {

    ChannelAccount findAllBySendChannelEquals(Integer channelType);
}
