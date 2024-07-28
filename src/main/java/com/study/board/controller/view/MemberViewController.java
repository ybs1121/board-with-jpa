package com.study.board.controller.view;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/v1/mav/member")
@RequiredArgsConstructor
public class MemberViewController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }


    @GetMapping("/sign-up")
    public String signUp() {
        return "signup";
    }
}
