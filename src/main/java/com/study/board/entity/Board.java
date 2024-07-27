package com.study.board.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
public class Board {

    @Id
    @GeneratedValue
    @Column(name = "borad_id")
    private Long id;

    private String title;

    private String content;

    private String author;

    @CreatedDate
    private LocalDateTime writeDate;
    @LastModifiedDate
    private LocalDateTime modifyDate;

    @OneToMany(mappedBy = "board")
    private List<Comment> comments = new ArrayList<>();

}
