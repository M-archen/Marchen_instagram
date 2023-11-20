package com.example.greengram2.user.model;

import lombok.Data;

@Data
public class UserSigninVo {//로그인 성공했을때 보여줄 값. (응답)
    private int iuser;
    private String nm;
    private String pic;
    private int result;
}
