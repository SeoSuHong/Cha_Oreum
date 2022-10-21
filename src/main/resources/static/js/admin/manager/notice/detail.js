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
	let comment_secret = 0;
	if($('#comment_secret').is(":checked")){
		comment_secret = 1;
	}
	console.log(comment_secret);
	if(nickname == null || nickname == '') {
		let check = confirm("회원만 이용이 가능합니다.\n로그인 하시겠습니까?");
		
		if(check)
			location.href="/account/logIn"; return;
	}
	if(contents.val() == null || contents.val() == '') {
		alert("댓글을 입력해 주세요.");
		contents.focus(); return;
	}
	
	$.ajax({
		type : "post",
		url : "/board/contents/comment?no=" + no + "&nickname=" + nickname + "&contents=" + contents.val() + "&comment_secret=" + comment_secret,
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
function sendReply(obj, no, nickname) {
	let contents = $(obj).parent().prev().prev();
	let reply_secret = 0;
	if($(".reply_secret").is(":checked")){
		reply_secret = 1;
	}
	console.log(reply_secret);
	if(nickname == null || nickname == '') {
		let check = confirm("회원만 이용이 가능합니다.\n로그인 하시겠습니까?");
		
		if(check)
			location.href="/account/logIn"; return;
	}
	if(contents.val() == null || contents.val() == '') {
		alert("답글을 입력해 주세요.");
		contents.focus(); return;
	}

	$.ajax({
		type : "post",
		url : "/board/contents/reply?no=" + no + "&nickname=" + nickname + "&contents=" + contents.val() + "&reply_secret=" + reply_secret,
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
			url : "/board/contents/delete_comment?no=" + no,
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
			url : "/board/contents/delete_reply?no=" + no,
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

// 게시물 삭제 시
function delete_post(no) {
	let check = confirm("게시글을 삭제 하시겠습니까?\n삭제된 게시글은 복구할 수 없습니다.");
	
	if(check) {
		location.href="/board/contents/delete_post?no=" + no;
	}
}


