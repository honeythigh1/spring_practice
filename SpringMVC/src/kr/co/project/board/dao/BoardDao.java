package kr.co.project.board.dao;


import java.util.List;

import kr.co.project.board.dto.BoardDto;

public interface BoardDao {
	public List<BoardDto> selectAll();
	public BoardDto selectOne(BoardDto dto);
	public void insertBoard(BoardDto dto);
	public void updateBoard(BoardDto dto);
	public void deleteBoard(BoardDto dto);
}
