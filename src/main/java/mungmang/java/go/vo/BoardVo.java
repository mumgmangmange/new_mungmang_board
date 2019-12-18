package mungmang.java.go.vo;

import lombok.Data;

@Data
public class BoardVo {

    private String subject;
    private String username;
    private String contents;
    private String password;
    private String modify_date;
    private String created_date;
    private int idx;
    private int viewcount;
}
