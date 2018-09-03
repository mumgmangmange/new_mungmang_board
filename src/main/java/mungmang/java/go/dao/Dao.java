package mungmang.java.go.dao;

import java.util.List;

import mungmang.java.go.dto.BoardDatas;

public interface Dao {

	//비밀번호 확인
	public boolean passwd_chk(int idx, String password);

	//글쓰기 처리
	public void write(BoardDatas boardDatas);
	
	//리스트
	public List<BoardDatas> list(String searchOption, String keyword);
	
	//읽기
	public BoardDatas read(int seq);
	
	//조회수올리기
	public int countUp(int viewcount, int seq);
	
	//삭제
	public int delete(int seq);
	
}
