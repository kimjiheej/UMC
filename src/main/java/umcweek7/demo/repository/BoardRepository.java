package umcweek7.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import umcweek7.demo.domain.Board;
import umcweek7.demo.dto.BoardListResponseDto;

import java.util.List;
@Repository

public interface BoardRepository extends JpaRepository<Board, Long> {
    @Query("SELECT b FROM Board b ORDER BY b.id DESC")
    List<BoardListResponseDto> findAllDesc();
}