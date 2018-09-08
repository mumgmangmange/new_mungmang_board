package mungmang.java.go.command;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import mungmang.java.go.dao.Dao;
import mungmang.java.go.dto.BoardDatas;

@Service("boardCommand")
public class BoardCommandService implements BoardCommand{
	
	//@Autowired
	@Resource(name="dao")
	private Dao dao;

	@Override
	public List<BoardDatas> list(String searchOption, String keyword) {
		
		return dao.list(searchOption, keyword);
	}
	
	@Override
	public int delete(int idx) {
		
		return dao.delete(idx);
	}

	@Override
	public void write(BoardDatas BoardDatas) {
		
		dao.write(BoardDatas);
	}
	

	@Override
	public void modify(BoardDatas BoardDatas) {
		dao.modify(BoardDatas);
	}	
	
	@Override
	public BoardDatas read(int seq) {
		
		return dao.read(seq);
	}
	
	@Override
	public int countUp(int viewcount, int seq) {
		
		return dao.countUp(viewcount, seq);
	}

	@Override
	public boolean passwd_chk(int idx, String password) {
	
		return dao.passwd_chk(idx, password);
	}

}
