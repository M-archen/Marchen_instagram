package com.example.greengram2.user.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserSigninDto {//요청.,
    private String uid;
    private String upw;
}
