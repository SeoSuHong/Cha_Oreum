// main
// 답글 쓰기 버튼 클릭 시
$(function() {
    let reply_btn = $('.reply_btn');
    let reply = $(".reply");

    $(reply_btn).click(function() {
		$(reply).hide();
        $($(this).parent().parent().next()).show();
    })
})

// 댓글 입력 버튼 클릭 시
function sendComment(no, nickname) {
	let contents = $("#comment_txt");
	let secret = false;
	
	if(nickname == null || nickname == '') {
		let check = confirm("회원만 이용이 가능합니다.\n로그인 하시겠습니까?");
		
		if(check)
			location.href="/account/logIn"; return;
	}
	if(contents.val() == null || contents.val() == '') {
		alert("댓글을 입력해 주세요.");
		contents.focus(); return;
	}
	
	if($('#comment_secret').is(":checked")) {
		secret = true;
	}
	
	$.ajax({
		type : "post",
		url : "/board/notice/comment?no=" + no + "&nickname=" + nickname + "&contents=" + contents.val() + "&secret=" + secret,
		success : function(result) {
			if(result) {
				location.reload();
			} else {
				alert("다시 시도 해 주세요.");
			}
		}
	})
}

// 답글 입력 버튼 클릭 시
function sendReply(obj, notice_no, comment_no, nickname) {
	let contents = $(obj).parent().prev().prev();
	let secret = false;
	
	if(nickname == null || nickname == '') {
		let check = confirm("회원만 이용이 가능합니다.\n로그인 하시겠습니까?");
		
		if(check)
			location.href="/account/logIn"; return;
	}
	if(contents.val() == null || contents.val() == '') {
		alert("답글을 입력해 주세요.");
		contents.focus(); return;
	}
	if($(".reply_secret").is(":checked")){
		secret = true;
	}

	$.ajax({
		type : "post",
		url : "/board/notice/reply?notice_no=" + notice_no + "&comment_no=" + comment_no + "&nickname=" + nickname + "&contents=" + contents.val() + "&secret=" + secret,
		success : function(result) {
			if(result) {
				location.reload();
			} else {
				alert("다시 시도 해 주세요.");
			}
		}
	})
}

// 댓글 삭제 시
function deleteComment(no) {
	let delete_chk = confirm("댓글을 삭제하시겠습니까?");
	
	if(delete_chk) {
		$.ajax({
			type : "post",
			url : "/board/notice/deleteComment?no=" + no,
			success : function(result) {
				if(result) {
					location.reload();
				} else {					
					alert("다시 시도 해 주세요.");
				}
			}
		})
	}
}

// 답글 삭제 시
function deleteReply(no) {
	let delete_chk = confirm("답글을 삭제하시겠습니까?");
	
	if(delete_chk) {
		$.ajax({
			type : "post",
			url : "/board/notice/deleteReply?no=" + no,
			success : function(result) {
				if(result) {
					location.reload();
				} else {					
					alert("다시 시도 해 주세요.");
				}
			}
		})
	}
}