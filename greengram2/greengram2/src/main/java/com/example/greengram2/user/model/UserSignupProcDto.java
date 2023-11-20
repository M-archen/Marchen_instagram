package com.example.greengram2.user.model;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UserSignupProcDto {
    private String uid;
    private String upw;
    private String nm;
    private String pic;
    private int iuser;

}
