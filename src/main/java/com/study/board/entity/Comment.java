package com.study.board.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Comment {

    @Id
    @GeneratedValue
    @Column(name = "comment_id")
    private Long id;

    private String content;

    private String author;

    @CreatedDate
    private LocalDateTime writeDate;

    @LastModifiedDate
    private LocalDateTime localDateTime;

    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;


    private Long boardTempId;
}
