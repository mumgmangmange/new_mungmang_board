<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="false" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <title>게시판</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="css/vendor/bootstrap.min.css" type="text/css" rel="stylesheet">
    <link href="css/vendor/font-awesome.min.css" type="text/css" rel="stylesheet">
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,600' rel='stylesheet' type='text/css'>
    <link href="css/jquery.bdt.css" type="text/css" rel="stylesheet">
    <link href="css/style.css" type="text/css" rel="stylesheet">
	<style type="text/css">
		.container-4{
		  overflow: hidden;
		  width: 500px;
		  vertical-align: middle;
		  white-space: nowrap;
		  margin-left:10px;
		  margin-bottom:10px;
		}
		.container-4 input#search{
		  width: 500px;
		  height: 50px;
		  background: #F0F0F0;
		  border: none;
		  font-size: 10pt;
		  float: left;
		  color: black;
		  padding-left: 15px;
		  -webkit-border-radius: 5px;
		  -moz-border-radius: 5px;
		  border-radius: 5px;
		}
		.container-4 input#search::-webkit-input-placeholder {
		   color: #65737e;
		}
		 
		.container-4 input#search:-moz-placeholder { /* Firefox 18- */
		   color: #65737e;  
		}
		 
		.container-4 input#search::-moz-placeholder {  /* Firefox 19+ */
		   color: #65737e;  
		}
		 
		.container-4 input#search:-ms-input-placeholder {  
		   color: #65737e;  
		}
		.container-4 button.icon{
		  -webkit-border-top-right-radius: 5px;
		  -webkit-border-bottom-right-radius: 5px;
		  -moz-border-radius-topright: 5px;
		  -moz-border-radius-bottomright: 5px;
		  border-top-right-radius: 5px;
		  border-bottom-right-radius: 5px;
		 
		  border: none;
		  background: #232833;
		  height: 50px;
		  width: 50px;
		  color: #4f5b66;
		  opacity: 0;
		  font-size: 10pt;
		 
		  -webkit-transition: all .55s ease;
		  -moz-transition: all .55s ease;
		  -ms-transition: all .55s ease;
		  -o-transition: all .55s ease;
		  transition: all .55s ease;
		}
		.container-4:hover button.icon, .container-4:active button.icon, .container-4:focus button.icon{
		    outline: none;
		    opacity: 1;
		    margin-left: -50px;
		  }
		 
		.container-4:hover button.icon:hover{
		  background: black;
		}
	</style>   
</head>
<body>
<div class="container">
    <div class="row">
            <div class="box clearfix">
            <h3><b><a href="./">게시판</a></b></h3>
            <p>~ 뭉망이 스프링 게시판 만들기 :D</p>
            	
            	<span style="float:right;margin-right:20px;">
            		<button class="btn btn-default" id="write_page">글쓰기</button>
            	</span>
            	
				<div class="box">
				  <div class="container-4">
				    <input type="search" id="search" placeholder="Search..." />
				    <button class="icon"><i class="fa fa-search"></i></button>
				  </div>
				</div>   
				         	
	            <table class="table table-hover" id="bootstrap-table">
	                <thead>
		                <tr>
		                    <th style="width:10%;">번호</th>
		                    <th>제목</th>
		                    <th style="width:20%;">글쓴이</th>
		                    <th style="width:10%;">조회수</th>
		                </tr>
	                </thead>
	                <tbody id = "table_datas">
						<c:forEach items="${mungmang.list}" var="data">
						<tr id="tr_${data.idx}" key="${data.idx}">
							<td>${data.idx}</td>
							<td>${data.subject}</td>
							<td>${data.username}</td>
							<td>${data.viewcount}</td>
						<tr>
						</c:forEach>
	                </tbody>
	            </table>
	            
        </div>
     </div>
 </div>

<%@include file="bottom.jsp" %>