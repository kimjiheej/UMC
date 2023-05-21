package umcweek7.demo.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umcweek7.demo.domain.Board;

@Getter
@NoArgsConstructor
public class BoardSaveRequestDto {
    private String title;
    private String content;
    private Long userId;

    @Builder
    public BoardSaveRequestDto(String title, String content, Long userId) {
        this.title = title;
        this.content = content;
        this.userId = userId;
    }

    public Board toEntity() {
        return Board.builder()
                .title(title)
                .content(content)
                .userId(userId)
                .build();
    }
}