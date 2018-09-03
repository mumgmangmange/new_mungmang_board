package mungmang.java.go.command;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import mungmang.java.go.dao.Dao;
import mungmang.java.go.dto.BoardDatas;
import mungmang.java.go.dto.Passwd_chk;

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
	public BoardDatas read(int seq) {
		
		return dao.read(seq);
	}
	
	@Override
	public int countUp(int viewcount, int seq) {
		
		return dao.countUp(viewcount, seq);
	}

	@Override
	public boolean passwd_chk(Passwd_chk passwd_chk) {
	
		
		int idx = passwd_chk.getIdx();
		String password = passwd_chk.getPassword();

		System.out.println(idx + ",," + password);
		
		boolean result_chk = dao.passwd_chk(idx, password);
		
		return result_chk;
		//return null;
	}
}
