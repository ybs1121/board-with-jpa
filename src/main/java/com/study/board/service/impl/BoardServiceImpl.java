package com.study.board.service.impl;

import com.study.board.dto.BoardFindDto;
import com.study.board.entity.Board;
import com.study.board.repository.BoardRepository;
import com.study.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;


    public List<Board> findAll() {
        return boardRepository.findAll();
    }

    public Board findOne(Long id) {
        return boardRepository.findById(id).orElse(null);
    }

    @Override
    public List<Board> findByBoardFindDto(BoardFindDto boardFindDto) {
        List<Board> byBoardFindDto = boardRepository.findByBoardFindDto(boardFindDto);
//        for (Board board : byBoardFindDto) {
//            board.getComments().size();
//        }
        return byBoardFindDto;
    }


    public void save(Board board) {
        boardRepository.save(board);
    }
}
