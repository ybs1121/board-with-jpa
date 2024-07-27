package com.study.board.controller.view;

import com.study.board.entity.Board;
import com.study.board.repository.BoardRepository;
import com.study.board.service.BoardService;
import com.study.board.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/v1/mav/board")
@RequiredArgsConstructor
public class BoardViewController {

    private final BoardService boardService;
    private final CommentService commentService;

    @GetMapping("")
    public String getBoardList(Model model) {
        model.addAttribute("boards", boardService.findAll());
        return "boardList";
    }


    @GetMapping("/{id}")
    public String getBoard(Model model, @PathVariable Long id) {
        model.addAttribute("board", boardService.findOne(id));
        model.addAttribute("comments", commentService.findByBoardId(id));
        return "board";
    }

    @GetMapping("/add")
    public String addBoard(Model model) {
        return "new";
    }


}
