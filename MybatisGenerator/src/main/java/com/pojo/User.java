package com.pojo;

/**
 * @ClassName:  User   
 * @Description:逆向工程生成的实体类
 * @author: caiji
 * @date: 2019年4月27日 下午2:49:16
 */
public class User {
    private Integer id;

    private String username;

    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
}