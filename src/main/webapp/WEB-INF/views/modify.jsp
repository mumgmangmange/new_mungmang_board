<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="false" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <title>게시판 - 내용수정</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="css/vendor/bootstrap.min.css" type="text/css" rel="stylesheet">
    <link href="css/vendor/font-awesome.min.css" type="text/css" rel="stylesheet">
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,600' rel='stylesheet' type='text/css'>
    <link href="css/jquery.bdt.css" type="text/css" rel="stylesheet">
    <link href="css/style.css" type="text/css" rel="stylesheet">
<style type="text/css">

.table-column {
    text-align: center;
    font-size: 14px;
    background-color: #ddffaa;
}
.error {
    margin-left: 5px;
    color: red;
    font-size: 12px;
}
 
</style>
</head>
<body>
<div class="container">
    <div class="row">
            <div class="box clearfix">
            <h3><b><a href="./">내용수정</a></b></h3>
            <p>~ 뭉망이 스프링 게시판 만들기 :D</p>
			
			<form:form name="frm" id="frm" method = "post" modelAttribute="boardDatas" action="./modify">
				<input type="hidden" name="idx" value="${idx}">
	            <table class="table table-hover" id="bootstrap-table-read">
	                <tbody>
		                <tr>
		                    <td style="width:30%;text-align:center;">글쓴이</td>
		                    <td>
		                    	<form:errors path="username" cssClass="error"/>
		                    	<form:input path="username" class="form-control" id="username" name="username" value="${username}"/>
		                    </td>
		                </tr>
		                <tr>
		                    <td style="text-align:center;">제목</td>
		                    <td>
		                    	<form:errors path="subject" cssClass="error"/>
		                    	<form:input class="form-control" path="subject" id="subject" name="subject" value="${subject}"/>
		                    </td>
		                </tr>
		                <tr>
		                    <td style="text-align:center;">내용</td>
		                    <td>
		                    	<form:errors path="contents" cssClass="error"/>
		                    	<textarea class="form-control"  style="height:400px;" id="contents" name="contents">${contents}</textarea>
		                    </td>
		                </tr>
		                <tr>
		                    <td style="text-align:center;">비밀번호 입력</td>
		                    <td>
		                    	<form:errors path="password" cssClass="error"/>
		                    	<form:password class="form-control" path="password" id="password" name = "password" value=""/>
		                    </td>
		                </tr>	                
		                <tr>
		                    <td colspan="2" style="text-align:center;">
		                    	<button class="btn btn-default" id="modify_ok">내용수정</button>
		                    	<button class="btn btn-danger" id="front_page">뒤로</button>
		                    </td>
		                </tr>   
	                </tbody>
	            </table>
	        </form:form>
        </div>
     </div>
</div>

<%@include file="bottom.jsp" %>