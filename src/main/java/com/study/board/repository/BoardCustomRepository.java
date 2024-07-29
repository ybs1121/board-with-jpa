package com.study.board.repository;

import com.study.board.dto.BoardFindDto;
import com.study.board.entity.Board;

import java.util.List;

public interface BoardCustomRepository {
    List<Board> findByBoardFindDto(BoardFindDto findDto);

}
