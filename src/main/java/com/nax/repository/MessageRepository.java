package com.nax.repository;

import com.nax.entity.MessageEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Maxim on 9/23/2017.
 */
public interface MessageRepository extends CrudRepository <MessageEntity, Long> {

List<MessageEntity> findByUserPhoneAndSenderPhone (String userPhone, String senderPhone);

}
