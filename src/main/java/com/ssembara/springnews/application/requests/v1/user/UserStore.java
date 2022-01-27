package com.ssembara.springnews.application.requests.v1.user;

import lombok.Data;

@Data
public class UserStore {

    private String email;
    private String password;
    private String name;

}
