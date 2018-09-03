package mungmang.java.go.dto;

import org.apache.ibatis.type.Alias;
import org.hibernate.validator.constraints.NotEmpty;


@Alias("boardDatas")
public class BoardDatas {
	
	@NotEmpty(message="제목을 입력해 주세요.")
	String subject;
	
	@NotEmpty(message="작성자를 입력해 주세요.")
	String username;
	
	@NotEmpty(message="내용을 입력해 주세요.")
	String contents;

	@NotEmpty(message="비밀번호를 입력해 주세요.")
	String password;
	
	String modify_date;
	String created_date;
	
	int idx;
	int viewcount;

	public String getModify_date() {
		return modify_date;
	}
	public void setModify_date(String modify_date) {
		this.modify_date = modify_date;
	}
	public String getCreated_date() {
		return created_date;
	}
	public void setCreated_date(String created_date) {
		this.created_date = created_date;
	}
	public int getViewcount() {
		return viewcount;
	}
	public void setViewcount(int viewcount) {
		this.viewcount = viewcount;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
}
