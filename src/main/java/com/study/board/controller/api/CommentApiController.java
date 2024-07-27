package com.study.board.controller.api;

import com.study.board.entity.Comment;
import com.study.board.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/api/comment")
public class CommentApiController {

    private final CommentService commentService;

    @PostMapping("")
    public String addComment(@RequestBody Comment comment) {
        commentService.save(comment);
        return "success";
    }
}
