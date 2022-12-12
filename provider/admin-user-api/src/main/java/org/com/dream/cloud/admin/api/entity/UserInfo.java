package org.com.dream.cloud.admin.api.entity;


import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 系统用户表
 * @author Dream
 * @date 2021年7月18日22:47:40
 *
 *
 */
@Table( name = "user_info")
public class UserInfo  implements Serializable {

    @Id
    @Column( name = "id")
    @GeneratedValue(generator = "JDBC")
    private Long id;

    @Column( name = "name")
    private String name;

    @Column( name = "password")
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }
}