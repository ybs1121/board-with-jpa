package com.study.board.service;

import com.study.board.entity.Member;

public interface MemberService {

    void save(Member member);

    Member findOne(Long id);

    Member findByUsrId(String usrId);

    Member findByUsrIdAndPassword(String usrId, String password);
}
