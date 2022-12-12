package org.com.dream.cloud.admin.api.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.com.dream.cloud.commons.api.base.entity.BaseEntity;


import java.util.Date;


public class AuthUser  extends BaseEntity {
    private Long id;

    private String username;

    private String password;

    private Long personid;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Long getPersonid() {
        return personid;
    }

    public void setPersonid(Long personid) {
        this.personid = personid;
    }
}