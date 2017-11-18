package com.nax.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.Date;

/**
 * Created by Maxim on 9/23/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MessageDto {
    private Long id;
    @NotEmpty(message = "The userPhone cannot be empty")
    private String userPhone;
    @NotEmpty(message = "The senderPhone cannot be empty")
    private String senderPhone;
    @NotEmpty(message = "The message cannot be empty")
    private String message;
//    @NotEmpty(message = "The time cannot be empty")
    private String time;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public MessageDto() {
    }
}
