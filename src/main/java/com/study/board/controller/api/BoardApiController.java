package com.study.board.controller.api;

import com.study.board.entity.Board;
import com.study.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
