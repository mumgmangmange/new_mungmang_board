package mungmang.java.go.dao;

import java.util.List;

import mungmang.java.go.dto.BoardDataDto;

public interface BoardDao {
	boolean passwdCheck(int idx, String password);
	void write(BoardDataDto boardDatas);
	List<BoardDataDto> list(String searchOption, String keyword);
	BoardDataDto read(int seq);
	int countUp(int viewcount, int seq);
	int delete(int seq);
	void modify(BoardDataDto boardDatas);
}
