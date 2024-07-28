package com.study.board.controller.api;

import com.study.board.LoginDto;
import com.study.board.core.jwt.JwtUtil;
import com.study.board.entity.Member;
import com.study.board.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/api/member")
public class MemberApiController {

    private final MemberService memberService;
    private final JwtUtil jwtUtil;

    @PostMapping("/sign-up")
    public String join(@RequestBody Member member) {
        memberService.save(member);
        return "success";
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginDto loginDto) {
        Member member = memberService.findByUsrIdAndPassword(loginDto.getUsrId(), loginDto.getPassword());

        if (member == null) {
            return "fail";
        }
        // JWT 토큰 생성
        String jwt = jwtUtil.generateToken(member.getUsrId());
        return "Bearer " + jwt;
    }
}
