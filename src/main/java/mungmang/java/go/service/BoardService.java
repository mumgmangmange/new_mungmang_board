package mungmang.java.go.service;

import java.util.List;

import mungmang.java.go.dao.BoardDaoMybatis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mungmang.java.go.dto.BoardDataDto;

@Service
public class BoardService {

	@Autowired private BoardDaoMybatis boardDaoMybatis;

	public List<BoardDataDto> list(String searchOption, String keyword) {
		return this.boardDaoMybatis.list(searchOption, keyword);
	}

	public int delete(int idx) {
		return this.boardDaoMybatis.delete(idx);
	}

	public void write(BoardDataDto BoardDatas) {
		this.boardDaoMybatis.write(BoardDatas);
	}

	public void modify(BoardDataDto BoardDatas) {
		this.boardDaoMybatis.modify(BoardDatas);
	}	

	public BoardDataDto read(int seq) {
		return this.boardDaoMybatis.read(seq);
	}

	public int countUp(int viewcount, int seq) {
		return this.boardDaoMybatis.countUp(viewcount, seq);
	}

	public boolean passwdCheck(int idx, String password) {
		return this.boardDaoMybatis.passwdCheck(idx, password);
	}
}
