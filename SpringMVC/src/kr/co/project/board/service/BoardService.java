package kr.co.project.board.service;

import java.util.List;

import kr.co.project.board.dto.BoardDto;

public interface BoardService {
	public BoardDto read(BoardDto dto);
	public List<BoardDto> getList();
	public void insertBoard(BoardDto dto);
	public void updateBoard(BoardDto dto);
	public void deleteBoard(BoardDto dto);
}
