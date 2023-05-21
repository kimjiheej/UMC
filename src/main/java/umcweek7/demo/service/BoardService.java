package umcweek7.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umcweek7.demo.domain.Board;
import umcweek7.demo.dto.BoardListResponseDto;
import umcweek7.demo.dto.BoardResponseDto;
import umcweek7.demo.dto.BoardSaveRequestDto;
import umcweek7.demo.dto.BoardUpdateRequestDto;
import umcweek7.demo.repository.BoardRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional
    public String save(BoardSaveRequestDto requestDto) {
        return boardRepository.save(requestDto.toEntity()).getId() + ": 글이 등록되었습니다.";
    }

    @Transactional
    public String update(Long id, BoardUpdateRequestDto requestDto) {
        Board board = boardRepository.findById(id).orElseThrow
                (() -> new IllegalArgumentException("해당 게시글이 없습니다. id="+id));
        board.update(requestDto.getTitle(), requestDto.getContent());

        return id + ": 글이 수정되었습니다.";
    }
    @Transactional
    public void delete(Long id){
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id =" + id));
        //존재하는 글인지 확인하기 위해 조회 후 삭제
        boardRepository.delete(board);
    }

    public BoardResponseDto findById(Long id) {
        Board entity = boardRepository.findById(id).orElseThrow
                (() -> new IllegalArgumentException("해당 게시글이 없습니다. id="+id));

        return new BoardResponseDto(entity);
    }

    @Transactional
    public List<BoardListResponseDto> findAllBoard() {
        try {
            List<Board> boardList = boardRepository.findAll();
            List<BoardListResponseDto> responseDtoList = new ArrayList<>();
            for (Board board : boardList) {
                responseDtoList.add(
                        new BoardListResponseDto(board)
                );
            }
            return responseDtoList;
        } catch (Exception e) {
        }
        return null;
    }
}