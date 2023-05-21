package umcweek7.demo.dto;

import lombok.Getter;
import umcweek7.demo.domain.Board;

@Getter
public class BoardResponseDto {
    private Long id;
    private String title;
    private String content;
    private Long userId;

    public BoardResponseDto(Board entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.userId = entity.getUserId();
    }
}