package com.example.greengram2.user;

import com.example.greengram2.ResVo;
import com.example.greengram2.user.model.UserSigninDto;
import com.example.greengram2.user.model.UserSigninVo;
import com.example.greengram2.user.model.UserSignupDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user/")
public class UserController {
    private final UserService service;
    @PostMapping("/signup")
    public ResVo signup(@RequestBody UserSignupDto dto){
        log.info("dto: {}",dto);
        return service.UserSignup(dto);//ResVo 값에 insert 한 레코드 pk값을 담아서 응답처리
    }
    @PostMapping("/signin")
    public UserSigninVo signin(@RequestBody UserSigninDto dto){

        return service.UserSignin(dto);
    }
}
