package mungmang.java.go.command;

import java.util.List;

import mungmang.java.go.dto.BoardDatas;
import mungmang.java.go.dto.Passwd_chk;


public interface BoardCommand {
	
	public List<BoardDatas> list(String searchOption, String keyword);

	public int delete(int idx);

	public void write(BoardDatas BoardDatas);
	
	public void modify(BoardDatas BoardDatas);

	public BoardDatas read(int seq);	
	
	public int countUp(int viewcount, int seq);

	public boolean passwd_chk(Passwd_chk passwd_chk);
	
}
