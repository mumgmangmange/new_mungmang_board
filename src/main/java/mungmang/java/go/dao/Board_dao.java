package mungmang.java.go.dao;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mungmang.java.go.dto.BoardDatas;

@Repository("dao")
public class Board_dao implements Dao{
	
	@Autowired
	private SqlSession sqlSession;

    public void setSqlSession(SqlSession sqlSession){
        this.sqlSession = sqlSession;
    }
    
	public Board_dao() {
	}
	
	//비밀번호 확인
	@Override
	public boolean passwd_chk(int idx, String password) {

		System.out.println(idx + "," + password);
		
	    Map<String, Object> map = new HashMap<String, Object>();
	    map.put("idx", idx);
	    map.put("password", password);
	    
	    String result = sqlSession.selectOne("passwd_chk",map);
	    
	    System.out.println("board_dao::" + result);
	    
	    if(result.equals("0")) {
	    	return false;
	    }
		return true;
	}

	//글쓰기 처리
	@Override
	public void write(BoardDatas boardDatas) {

		sqlSession.insert("insert",boardDatas); //sqlSessionTemplate.insert("write_ok", boardDatas);
	}
	
	//메인리스트
	@Override
	public List<BoardDatas> list(String searchOption, String keyword) {

		// 검색옵션, 키워드 맵에 저장
	    Map<String, String> map = new HashMap<String, String>();
	    map.put("searchOption", searchOption);
	    map.put("keyword", keyword);
		return sqlSession.selectList("list",map);
	}
	
	//읽기
	@Override
	public BoardDatas read(int seq) {
		
		Map<String, Integer> map = new HashMap<String, Integer>();
	    map.put("id", seq);	
		return sqlSession.selectOne("read", map);
	}
	
	//조회수 올리기
	@Override
	public int countUp(int viewcount, int seq) {
		
		Map<String, Integer> map = new HashMap<String, Integer>();
	    map.put("id", seq);
	    map.put("count", viewcount+1);
		return sqlSession.update("countUp", map);		
	}
	
	//삭제
	@Override
	public int delete(int seq) {
		Map<String, Integer> map = new HashMap<String, Integer>();
	    map.put("id", seq);
		return sqlSession.delete("delete",map);			
	}

}
