package com.example.greengram2.user;

import com.example.greengram2.user.model.UserSigninDto;
import com.example.greengram2.user.model.UserSigninVo;
import com.example.greengram2.user.model.UserSignupProcDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int UserSignup(UserSignupProcDto pk);
    String getUserPw(String uid);
    UserSigninVo userSignin(String uid);
}
