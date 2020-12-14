package kr.co.project.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.project.board.dto.BoardDto;

@Repository
public class BoardDaoImpl implements BoardDao {

	@Autowired
	private SqlSession session;
	
	private static final String namespace = "kr.co.project.board.";

	@Override
	public BoardDto selectOne(BoardDto dto){
		return session.selectOne(namespace + "selectOne", dto);
	}

	@Override
	public List<BoardDto> selectAll(){
		return session.selectList(namespace + "selectAll");
	}

	@Override
	public void insertBoard(BoardDto dto){
		session.insert(namespace + "insertBoard", dto);
		
	}

	@Override
	public void updateBoard(BoardDto dto){
		session.update(namespace + "updateBoard", dto);
	}

	@Override
	public void deleteBoard(BoardDto dto) {
		session.delete(namespace, dto);
		
	}

	@Override
	public int totalCount() {
		return session.selectOne(namespace + "totalCount");
	}


}
