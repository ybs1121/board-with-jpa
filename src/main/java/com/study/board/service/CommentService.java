package com.study.board.service;

import com.study.board.entity.Comment;

import java.util.List;

public interface CommentService {

     void save(Comment comment) ;

     List<Comment> findByBoardId(Long boardId) ;
}
