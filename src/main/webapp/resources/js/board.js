$(document).ready( function () {
    
	$('#bootstrap-table').bdt({
        showSearchForm: 0,
        showEntriesPerPageField: 0
    });
	
	
	//모달 창 열릴때 초기화
	$('#passwd_div').on('shown.bs.modal', function () {
		$('#password_chk').val("");
	})

	// 테이블 클릭->글읽기페이지로 이동
    $('#table_datas tr').on('click',function(){
    	
    	var tr_key = $(this).attr('key');
    	location.href = "./read?id="+tr_key;
    });
    
    //글쓰기 이동
    $('#write_page').on('click',function(){
    	location.href = "./write";
    });
    
	// 수정하기, 삭제하기 버튼 클릭 
    $('#modify, #delete').on('click',function(){
    	
    	var id = $(this).attr('id');
    	$('#password_chk').attr('key',id);
    	$('#password_modal').modal('show');
    });
    
    //비밀번호 입력
    $('#password_confirm').on('click',function(){
    	
    	var pwd = $('#password_chk').val(),
    		idx = location['search'].split("=")[1],
    		updel = $("#password_chk").attr('key'),
    		send_json = {'password':pwd, 'idx':idx, 'updel':updel};

    	$.ajax({
            url:'./passwd_chk',
            type:'post',
            data:send_json,
            datatype:'json',
            success:function(data, status){
            	
            	if(data.result == true && updel == 'delete') {
            		
            		$('#del_confirm_inner').modal('show');

            	} else if(data.result == true && updel == 'modify') {
            		
            		$('#edit_ok').attr("method","POST");
            		$('#edit_ok').attr("action","./modify?id="+idx);

            		$('#edit_ok').submit();
            		
            	} else {
            		
            		alert('비밀번호가 일치하지 않습니다.');
            		return;
            	}
            }
        });    	
    });
    
    //삭제하시겠습니까?
    $('#del_confirm').on('click','#del_ok',function(){
    	
    	var idx = $('#del_ok').attr('key'),
    		send_json = {'idx':idx};

    	$.ajax({
            url:'./delete_ok',
            type:'post',
            data:send_json,
            datatype:'json',
            success:function(data, status){

            	if(data.result == 1) {
            		alert('삭제완료!!');
            	} else {
            		alert('삭제실패!!');
            	}
            	location.href = "./";
            }
        });     	
    });

    // -1 page 이동
    $('#front_page').on('click',function(){
    	history.go(-1);
    });
    
    //수정확인버튼 클릭시 유효성 체크
    $('#modify_ok').on('click',function(){
    	if($("#username").val().length <= 0) {
    		alert("글쓴이 명을 입력해 주세요.");
    		return false;
    	}
    	if($("#subject").val().length <= 0) {
    		alert("제목을 입력해 주세요.");
    		return false;
    	}
    	if($("#contents").val().length <= 0) {
    		alert("내용을 입력해 주세요.");
    		return false;
		}
    	if($("#password").val().length <= 0) {
    		alert("비밀번호를 입력해 주세요.");
    		return false;
    	}
    	
    	$("#frm").submit();
    });

});
