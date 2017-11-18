package com.nax.controller;


import com.nax.dto.MessageDto;
import com.nax.entity.MessageEntity;
import com.nax.repository.MessageRepository;
import com.nax.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.apache.log4j.Logger;

import javax.validation.Valid;


/**
 * Created by Maxim on 9/23/2017.
 */
@RestController
public class MessageController {


    private final static Logger log = Logger.getLogger(MessageController.class);

    @Autowired
    MessageRepository messageRepository;
    @Autowired
    MessageService messageService;

    @PostMapping("createMessage")
    public ResponseEntity makeMessage(MessageDto messageDto) {

        log.info("Trying create message");

        return messageService.makeMessage(messageDto);
    }

    @GetMapping("findMessage")
    public Iterable<MessageEntity> findMessage(@RequestParam String userPhone, @RequestParam String senderPhone) {

        log.info("Trying search");

        return messageRepository.findByUserPhoneAndSenderPhone(userPhone, senderPhone);
    }
}
