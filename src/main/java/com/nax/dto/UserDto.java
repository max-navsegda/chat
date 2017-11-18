package com.nax.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.nax.entity.UserEntity;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.Valid;

/**
 * Created by Maxim on 9/23/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto {

    private Long id;
    @NotEmpty(message = "The phone cannot be empty")
    private String phone;
    @NotEmpty(message = "The password cannot be empty")
    private String password;
//    @NotEmpty(message = "The rate cannot be empty")
    private String rate;
//    @NotEmpty(message = "The balance cannot be empty")
    private Integer balance;
//    @NotEmpty(message = "The status cannot be empty")
    private String status;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public UserEntity clone() {
        UserEntity userEntity = new UserEntity();
        userEntity.setPhone(getPhone());
        userEntity.setPassword(getPassword());
        userEntity.setRate(getRate());
        userEntity.setBalance(getBalance());
        userEntity.setStatus(getStatus());
        return userEntity;
    }
}
