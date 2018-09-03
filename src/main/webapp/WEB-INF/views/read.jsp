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

            <table class="table table-hover" id="bootstrap-table-read" idx="${mungmang.idx}">
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
     
     <form action="./edit" method="post" id="edit_ok">
	     <!-- 비밀번호 입력 -->
	     <div id = "passwd_div">
			<div class="modal" id="password_modal" style="display:none;">
			  <div class="modal-dialog">
			    <div class="modal-content">
			      <div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			        <h4 class="modal-title">비밀번호를 입력하세요.</h4>
			      </div>
			      <div class="modal-body">
			        <input type="hidden" id="idx" name = "idx" value="${mungmang.idx}">
			      	<input type="password" class="form-control" id="password_chk" style="width:100%;" key="">
			      </div>
			      <div class="modal-footer">
			        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			        <button type="button" class="btn btn-primary" id="password_confirm">확인</button>
			      </div>
			    </div><!-- /.modal-content -->
			  </div><!-- /.modal-dialog -->
			</div><!-- /.modal -->     
	     </div>
     </form>
     
     <!-- 삭제여부 confirm -->
     <div id = "del_confirm">
		<div class="modal" id="del_confirm_inner" style="display:none;">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		        <h4 class="modal-title">삭제하시겠습니까?</h4>
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-primary" data-dismiss="modal">No</button>
		        <button type="button" class="btn btn-warning" id="del_ok">Yes</button>
		      </div>
		    </div><!-- /.modal-content -->
		  </div><!-- /.modal-dialog -->
		</div><!-- /.modal -->     
     </div>
</div>


<script src="http://code.jquery.com/jquery-2.1.1.min.js" type="text/javascript"></script>
<script src="js/vendor/bootstrap.min.js" type="text/javascript"></script>
<script src="js/vendor/jquery.sortelements.js" type="text/javascript"></script>
<script src="js/jquery.bdt.min.js" type="text/javascript"></script>

<script src="js/board.js" type="text/javascript"></script>
</body>
</html>