package com.nax.controller;

import com.nax.dto.UserDto;
import com.nax.entity.UserEntity;
import com.nax.repository.UserRepository;
import com.nax.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.util.StringUtils;

import javax.validation.Valid;


/**
 * Created by Maxim on 9/23/2017.
 */
@RestController
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    private UserService userService;
    private UserRepository userRepository;

    @Autowired
    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @PostMapping("login")
    private ResponseEntity login(@Valid UserDto userDto, BindingResult bindingResult) {

        LOGGER.info("Trying login", userDto.getPhone());

        if (StringUtils.isEmpty(userDto.getPhone())) {
            return ResponseEntity.badRequest().body("Enter phone");
        }
        if (StringUtils.isEmpty(userDto.getPassword())) {
            return ResponseEntity.badRequest().body("Enter pass");
        } else {
            if (bindingResult.hasErrors()) {
                return ResponseEntity.badRequest().body(bindingResult.getFieldErrors().get(0).getDefaultMessage());
            }
            return userService.login(userDto);
        }
    }

    @PostMapping("register")
    private ResponseEntity register(@Valid UserDto userDto) {

        LOGGER.info("Trying login {} {}", userDto.getPhone(), userDto.getPassword());

        return userService.login(userDto);
    }

    @PostMapping("createRate")
    private ResponseEntity createRate(@RequestParam String phone, @RequestParam String rate) {

        LOGGER.info("Trying rate {} {}", phone);

        return userService.createRate(phone, rate);
    }

    @PostMapping("findRate")
    private ResponseEntity findRate(@RequestParam String phone, @RequestParam String rate) {

        LOGGER.info("Trying rate {} {}", phone);

        return userService.findRate(phone, rate);
    }
}
