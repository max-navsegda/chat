package com.nax.service;

import com.nax.dto.MessageDto;
import com.nax.entity.MessageEntity;
import com.nax.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.nax.repository.MessageRepository;
import com.nax.repository.UserRepository;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Created by Maxim on 9/23/2017.
 */
@Service
public class MessageService {

    private MessageRepository messageRepository;
    UserService userService;
    UserRepository userRepository;

    @Autowired
    public MessageService(MessageRepository messageRepository, UserService userService, UserRepository userRepository) {
        this.messageRepository = messageRepository;
        this.userService = userService;
        this.userRepository = userRepository;
    }


    public ResponseEntity makeMessage(MessageDto messageDto) {
        if (userRepository.findOneByPhone(messageDto.getUserPhone()) == null) {
            return ResponseEntity.badRequest().body("User not found");
        } else {
            MessageEntity m = new MessageEntity();
            m.setUserPhone(messageDto.getUserPhone());
            m.setSenderPhone(messageDto.getSenderPhone());
            m.setMessage(messageDto.getMessage());
            LocalTime localTime = LocalTime.now();
            m.setTime(localTime.toString());
            messageRepository.save(m);
            return ResponseEntity.badRequest().body("Message sent");
        }
    }
}
