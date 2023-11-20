package com.example.greengram2.user;

import com.example.greengram2.ResVo;
import com.example.greengram2.user.model.UserSigninDto;
import com.example.greengram2.user.model.UserSigninVo;
import com.example.greengram2.user.model.UserSignupDto;
import com.example.greengram2.user.model.UserSignupProcDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper mapper;
    public ResVo UserSignup(UserSignupDto dto){
        String hashedPw = BCrypt.hashpw(dto.getUpw(),BCrypt.gensalt());

        log.info("hashedPw : {}",hashedPw);
        UserSignupProcDto userSignupProcDto = UserSignupProcDto.builder()
                .uid(dto.getUid())
                .upw(hashedPw)
                .nm(dto.getNm())
                .pic(dto.getPic()).build();
        mapper.UserSignup(userSignupProcDto);

        return new ResVo(userSignupProcDto.getIuser());
    }
    public UserSigninVo UserSignin(UserSigninDto dto){
        String savedPw=mapper.getUserPw(dto.getUid());// DB에서 가져온 비밀번호
        boolean comparedPw=BCrypt.checkpw(dto.getUpw(),savedPw); //true=비밀번호 같다.
        log.info("savedPw : {}",savedPw);
        if(comparedPw==true){
            UserSigninVo vo=mapper.userSignin(dto.getUid());
            vo.setResult(1);
            return vo;
        }
        return null;
    }
}
