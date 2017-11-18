package com.nax.service;

import com.nax.dto.UserDto;
import com.nax.entity.UserEntity;
import com.nax.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private static final Logger LOG = LoggerFactory.getLogger(UserService.class);

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseEntity register(UserDto userDto) {

        LOG.info("Register by phone {} {}", userDto.getPhone(), userDto.getPassword());

        try {
            UserEntity u = userDto.clone();
            u.setRate("none");
            u.setBalance(100);
            userRepository.save(u);
            LOG.info("Register by phone {} {}", userDto.getPhone(), userDto.getPassword());
            return ResponseEntity.badRequest().body("Register is ok");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Register is not ok");
        }
    }

    public ResponseEntity login(UserDto userDto) {
        LOG.info("Login by phone {} {}", userDto.getPhone(), userDto.getPassword());
        if (userRepository.findOneByPhone(userDto.getPhone()) != null) {
            if (userRepository.findOneByPhoneAndPassword(userDto.getPhone(), userDto.getPassword()) != null)
                return ResponseEntity.badRequest().body("Login");
            else {
                return ResponseEntity.badRequest().body("Wrong pass");
            }
        }
        return register(userDto);
    }

    public ResponseEntity createRate(String phone, String rate) {

        LOG.info("Rate by phone {}", phone);

        try {
            if (userRepository.findOneByPhone(phone) != null) {
                UserEntity u = userRepository.findOneByPhone(phone);
                u.setRate(rate);
                userRepository.save(u);
                return ResponseEntity.badRequest().body("Rate is ok");
            }
        } catch (Exception e) {
        }
        return ResponseEntity.badRequest().body("Rate is not ok");
    }

    public ResponseEntity findRate(String phone, String rate) {

        LOG.info("Find rate {}", phone);

        if (userRepository.findOneByPhoneAndRate(phone, rate) != null)
            return ResponseEntity.badRequest().body("Win");
        return ResponseEntity.badRequest().body("Loose");
    }

//    public ResponseEntity setStatus(String phone, String status) {
//
//        LOG.info("Find status {}", phone);
//
//        if (userRepository.findOneByPhone(phone) != null)
//    }
}
