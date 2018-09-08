<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="false" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <title>게시판 - 읽기</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="css/vendor/bootstrap.min.css" type="text/css" rel="stylesheet">
    <link href="css/vendor/font-awesome.min.css" type="text/css" rel="stylesheet">
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,600' rel='stylesheet' type='text/css'>
    <link href="css/jquery.bdt.css" type="text/css" rel="stylesheet">
    <link href="css/style.css" type="text/css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row">
            <div class="box clearfix">
            <h3><b><a href="./">게시판 - 읽기</a></b></h3>
            <p>~ 뭉망이 스프링 게시판 만들기 :D</p>

            <table class="table table-hover" id="bootstrap-table-read" idx=${mungmang.idx}>
                <tbody>
	                <tr>
	                    <td style="width:30%;text-align:center;">작성일</td>
	                    <td>
	                    	<c:choose>
	                    		<c:when test="${empty mungmang.modify_date}">
	                    			<input type="text" class="form-control" style="background-color:white;" readonly value="${mungmang.created_date}">
	                    		</c:when>
	                    		<c:otherwise>
	                    			<input type="text" class="form-control" style="background-color:white;" readonly value="${mungmang.modify_date}">
	                    		</c:otherwise>
	                    	</c:choose>
	                    	
	                    </td>
	                </tr>
	                <tr>
	                    <td style="text-align:center;">글쓴이</td>
	                    <td>
	                    	<input type="text" class="form-control" style="background-color:white;" readonly value="${mungmang.username}">
	                    </td>
	                </tr>
	                <tr>
	                    <td style="text-align:center;">제목</td>
	                    <td>
	                    	<input type="text" class="form-control" style="background-color:white;" readonly value="${mungmang.subject}">
	                    </td>
	                </tr>
	                <tr>
	                    <td style="text-align:center;">내용</td>
	                    <td>
	                    	<textarea class="form-control"  style="height:400px;background-color:white;" readonly>${mungmang.contents}</textarea>
	                    </td>
	                </tr>
	                <tr>
	                    <td colspan="2" style="text-align:center;">
	                    	<button class="btn btn-default updel" id="modify">수정하기</button>
	                    	<button class="btn btn-danger updel" id="delete">삭제하기</button>
	                    	<button class="btn btn-default" id="front_page">뒤로</button>
	                    </td>
	                </tr>   
                </tbody>
            </table>
	            
        </div>
     </div>
	<%@include file="pwd_modal.jsp" %>
</div>


<%@include file="bottom.jsp" %>