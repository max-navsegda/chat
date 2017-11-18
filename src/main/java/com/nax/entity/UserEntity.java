package com.nax.entity;

import com.nax.dto.UserDto;

import javax.persistence.*;

/**
 * Created by Maxim on 9/23/2017.
 */
@Entity
@Table(name = "users")
public class UserEntity extends AbstractEntity<Long> {

    private static long serialVersionUID = 4646464645484896L;

    @Column (name = "phone", unique = true)
    private String phone;
    @Column (name = "password")
    private String password;
    @Column (name = "rate")
    private String rate;
    @Column (name = "balance")
    private Integer balance;
    @Column (name = "status")
    private String status;

    public String getRate() {return rate;}

    public void setRate(String rate) {this.rate = rate;}

    public Integer getBalance() {return balance;}

    public void setBalance(Integer balance) {this.balance = balance;}

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
