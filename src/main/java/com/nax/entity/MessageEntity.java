package com.nax.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Maxim on 9/23/2017.
 */
@Entity
@Table(name = "messages")
public class MessageEntity extends AbstractEntity<Long> {

    private static long serialVersionUID = 4646464645384896L;

    @Column(name = "userPhone")
    private String userPhone;
    @Column(name = "senderPhone")
    private String senderPhone;
    @Column(name = "message")
    private String message;
    @Column(name = "time")
    private String time;

    public MessageEntity() {
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getSenderPhone() {
        return senderPhone;
    }

    public void setSenderPhone(String senderPhone) {
        this.senderPhone = senderPhone;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
