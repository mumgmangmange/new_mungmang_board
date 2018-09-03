<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="false" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <title>게시판 - ${btn_one_text}</title>
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
            <h3><b><a href="./">${title}</a></b></h3>
            <p>~ 뭉망이 스프링 게시판 만들기 :D</p>
			
			<form:form action="./${next_page}" method = "post" modelAttribute="boardDatas">
	            <table class="table table-hover" id="bootstrap-table-read">
	                <tbody>
		                <tr>
		                    <td style="width:30%;text-align:center;">글쓴이</td>
		                    <td>
		                    	<form:input path="username" class="form-control" id="username" name="username" value="${username}"/>
		                    	<form:errors path="username" cssClass="error" />
		                    </td>
		                </tr>
		                <tr>
		                    <td style="text-align:center;">제목</td>
		                    <td>
		                    	<form:input class="form-control" path="subject" id="subject" name="subject" value="${subject}"/>
		                    	<form:errors path="subject" cssClass="error" />
		                    </td>
		                </tr>
		                <tr>
		                    <td style="text-align:center;">내용</td>
		                    <td>
		                    	<textarea class="form-control"  style="height:400px;" id="contents" name="contents">${contents}</textarea>
		                    	<form:errors path="contents" cssClass="error" />
		                    </td>
		                </tr>
		                <tr>
		                    <td style="text-align:center;">비밀번호 입력</td>
		                    <td>
		                    	<form:password class="form-control" path="password" id="password" name = "password"/>
		                    	<form:errors path="password" cssClass="error" />
		                    </td>
		                </tr>	                
		                <tr>
		                    <td colspan="2" style="text-align:center;">
		                    	<button class="btn btn-default" id="${btn_one_id}">${btn_one_text}</button>
		                    	<button class="btn btn-danger" id="front_page">뒤로</button>
		                    </td>
		                </tr>   
	                </tbody>
	            </table>
	        </form:form>
        </div>
     </div>
</div>


<script src="http://code.jquery.com/jquery-2.1.1.min.js" type="text/javascript"></script>
<script src="js/vendor/bootstrap.min.js" type="text/javascript"></script>
<script src="js/vendor/jquery.sortelements.js" type="text/javascript"></script>
<script src="js/jquery.bdt.min.js" type="text/javascript"></script>

<script src="js/board.js" type="text/javascript"></script>
</body>
</html>