package com.study.board.service.impl;

import com.study.board.entity.Member;
import com.study.board.repository.MemberRepository;
import com.study.board.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;


    public void save(Member member) {
        memberRepository.save(member);
    }

    public Member findOne(Long id) {
        return memberRepository.findById(id).orElse(null);
    }

    @Override
    public Member findByUsrId(String usrId) {
        return memberRepository.findByUsrId(usrId).orElse(null);
    }

    @Override
    public Member findByUsrIdAndPassword(String usrId, String password) {
        return memberRepository.findByUsrIdAndPassword(usrId,password).orElse(null);
    }

}
