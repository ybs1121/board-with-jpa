package com.study.board.controller.api;

import com.study.board.dto.BoardFindDto;
import com.study.board.entity.Board;
import com.study.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/api/board")
public class BoardApiController {

    private final BoardService boardService;

    @PostMapping("")
    public String save(@RequestBody Board board) {
        boardService.save(board);
        return "success";
    }

    @GetMapping("/search")
    public List<Board> findByBoardFind(BoardFindDto boardFindDto) {
        return boardService.findByBoardFindDto(boardFindDto);
    }
}
