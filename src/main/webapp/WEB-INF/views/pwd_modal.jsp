<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
     <form:form id="edit_ok" method="POST">
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
			      	<input type="password" class="form-control" id="password_chk" name="password_chk" style="width:100%;">
			      </div>
			      <div class="modal-footer">
			        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			        <button type="button" class="btn btn-primary" id="password_confirm">확인</button>
			      </div>
			    </div><!-- /.modal-content -->
			  </div><!-- /.modal-dialog -->
			</div><!-- /.modal -->     
	     </div>
     </form:form>
     
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
		        <button type="button" class="btn btn-warning" id="del_ok" key=${mungmang.idx}>Yes</button>
		      </div>
		    </div><!-- /.modal-content -->
		  </div><!-- /.modal-dialog -->
		</div><!-- /.modal -->     
     </div>