package org.com.dream.cloud.business.oauth2.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class UserInfo implements Serializable {
    private String name;
    private String avatar;

    private List<String> roles;
}
