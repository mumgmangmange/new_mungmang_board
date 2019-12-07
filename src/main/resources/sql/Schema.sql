CREATE TABLE mungmang_board (
  idx         INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  subject    VARCHAR(255) NULL,
  username    VARCHAR(255) NULL,
  contents     VARCHAR(1000) NULL,
  password    VARCHAR(255) NOT NULL,
  created_date  TIMESTAMP NULL,
  modify_date  TIMESTAMP NULL,
  viewcount      INT null,
);