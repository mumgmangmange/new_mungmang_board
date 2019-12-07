package mungmang.java.go.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mungmang.java.go.dao.BoardDao;
import mungmang.java.go.dto.BoardDataDto;

@Service
public class BoardService implements BoardDao {

	@Autowired private BoardDao boardDao;

	public List<BoardDataDto> list(String searchOption, String keyword) {
		return this.boardDao.list(searchOption, keyword);
	}

	public int delete(int idx) {
		return this.boardDao.delete(idx);
	}

	public void write(BoardDataDto BoardDatas) {
		this.boardDao.write(BoardDatas);
	}

	public void modify(BoardDataDto BoardDatas) {
		this.boardDao.modify(BoardDatas);
	}	

	public BoardDataDto read(int seq) {
		return this.boardDao.read(seq);
	}

	public int countUp(int viewcount, int seq) {
		return this.boardDao.countUp(viewcount, seq);
	}

	public boolean passwdCheck(int idx, String password) {
		return this.boardDao.passwdCheck(idx, password);
	}
}
