package com.study.board;

import lombok.Data;
import org.springframework.web.bind.annotation.RequestParam;

@Data
public class LoginDto {

    private String usrId;
    private String password;
}
