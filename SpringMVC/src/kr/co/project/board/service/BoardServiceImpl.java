package kr.co.project.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.project.board.dao.BoardDao;
import kr.co.project.board.dto.BoardDto;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardDao dao;
	

	@Override
	public BoardDto read(BoardDto dto) {
		// TODO Auto-generated method stub
		return dao.selectOne(dto);
	}


	@Override
	public List<BoardDto> selectAll(){
		// TODO Auto-generated method stub
		return dao.selectAll();
	}


	@Override
	public void insertBoard(BoardDto dto){
		dao.insertBoard(dto);
		
	}


	@Override
	public void updateBoard(BoardDto dto){
		dao.updateBoard(dto);
	}


	@Override
	public void deleteBoard(BoardDto dto) {
		dao.deleteBoard(dto);
		
	}


	@Override
	public int totalCount() {
		// TODO Auto-generated method stub
		return dao.totalCount();
	}

}
