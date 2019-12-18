package mungmang.java.go.dao;

import mungmang.java.go.dto.BoardDataDto;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BoardDaoMybatis implements BoardDao {

    @Autowired private SqlSessionTemplate sqlSessionTemplate;

    public List<BoardDataDto> list(String searchOption, String keyword) {
        //return this.sqlSessionTemplate.selectList(searchOption, keyword);
        return this.sqlSessionTemplate.selectList("list", keyword);
    }

    public int delete(int idx) {
        return this.sqlSessionTemplate.delete("delete", idx);
    }

    public void write(BoardDataDto BoardDatas) {
        this.sqlSessionTemplate.insert("insert", BoardDatas);
    }

    public void modify(BoardDataDto BoardDatas) {
        this.sqlSessionTemplate.update("update", BoardDatas);
    }

    public BoardDataDto read(int seq) {
        return this.sqlSessionTemplate.selectOne("select", seq);
    }

    public int countUp(int viewcount, int seq) {
        return this.sqlSessionTemplate.update("countUp", seq);
    }

    public boolean passwdCheck(int idx, String password) {
        return this.sqlSessionTemplate.selectOne("passwdCheck", idx);
    }
}
