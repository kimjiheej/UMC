package umcweek7.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umcweek7.demo.domain.Board;

import java.util.Optional;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BoardListResponseDto {

    private String title;
    private String content;
    private Long userId;

    public BoardListResponseDto(Board board) {
        this.title = board.getTitle();
        this.content = board.getContent();
        this.userId = board.getUserId();
    }

    public BoardListResponseDto(Optional<Board> board) {
        this.title = board.get().getTitle();
        this.content = board.get().getContent();
        this.userId = board.get().getUserId();
    }
}