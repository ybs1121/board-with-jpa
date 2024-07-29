package com.study.board.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.study.board.dto.BoardFindDto;
import com.study.board.entity.Board;
import com.study.board.entity.QBoard;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class BoardCustomRepositoryImpl implements BoardCustomRepository {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Board> findByBoardFindDto(BoardFindDto findDto) {
//        return queryFactory.selectFrom(QBoard.board)
//                .where(boardFind(findDto))
//                .fetch();
        return queryFactory.select(Projections.fields(
                Board.class,
                QBoard.board.id,
                QBoard.board.title,
                QBoard.board.content,
                QBoard.board.writeDate
                ))
                .from(QBoard.board)
                .where(boardFind(findDto))
                .fetch();
    }


    public BooleanExpression boardFind(BoardFindDto findDto) {
        QBoard board = QBoard.board;
        BooleanExpression expression = null;

        switch (findDto.getFindOption()) {
            case "title":
                expression = board.title.containsIgnoreCase(findDto.getFindText());
                break;
            case "context":
                expression = board.content.containsIgnoreCase(findDto.getFindText());
                break;
            case "all":
                expression = board.title.containsIgnoreCase(findDto.getFindText())
                        .or(board.content.containsIgnoreCase(findDto.getFindText()));
                break;
            default:
                throw new IllegalArgumentException("Invalid findOption: " + findDto.getFindOption());
        }

        return expression;

    }
}
