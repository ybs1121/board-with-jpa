package com.study.board.service;

import com.study.board.entity.Board;

import java.util.List;

public interface BoardService {

    List<Board> findAll();

    void save(Board board);

    Board findOne(Long id);
}
