$(document).ready( function () {
    
	$('#bootstrap-table').bdt({
        showSearchForm: 0,
        showEntriesPerPageField: 0
    });

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
    	
    	$('#password_chk').val("");
    	
    	var pwd = $('#password_chk').val(),
    		location_search = location['search'],
    		location_search_data = location_search.split('=')[1],
    		updel = $("#password_chk").attr('key'),
    		send_json = {'password':pwd, 'idx':location_search_data, 'updel':updel};
    	
    	$.ajax({
            url:'./passwd_chk',
            type:'post',
            data:send_json,
            datatype:'json',
            success:function(data, status){
            	
            	var updel = data.updel,
            		chk = data.chk;

            	if(chk == true && updel == 'delete') {
            		
            		//$('#password_modal').modal('close');
            		$('#del_confirm_inner').modal('show');

            	} else if(chk == true && updel == 'modify') {
            		
            		$('#edit_ok').attr("action","./modify");
            		$('#edit_ok').submit();
            		//location.href = "./edit?idx="+location_search_data+"&key="+encodeURIComponent(location_search_data);
            		
            	} else {
            		
            		alert('비밀번호가 일치하지 않습니다.');
            		return;
            	}
            }
        });    	
    });
    
    //삭제하시겠습니까?
    $('#del_confirm').on('click','#del_ok',function(){
    	
    	var idx = $('#bootstrap-table-read').attr('idx'),
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

});
