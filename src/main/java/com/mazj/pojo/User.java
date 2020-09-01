package com.mazj.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private int userId;
    private String userName;
    private String password;
    private String userEmail;
    private String userMobile;
    private String accountStatus;
    private String createTime;
    private String modifyTime;
    private String lastLoginTime;
    private String userSex;
}
