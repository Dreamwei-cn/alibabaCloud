package org.com.dream.cloud.business.oauth2.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class LoginParam implements Serializable {
    private String username;
    private String password;
}
