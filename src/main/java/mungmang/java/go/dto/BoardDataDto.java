package mungmang.java.go.dto;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

@Data
public class BoardDataDto {
	
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
}
