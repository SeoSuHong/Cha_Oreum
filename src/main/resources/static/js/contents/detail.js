// main
// id="file"의 line-height 설정
$(function() {
    const file_height = $('.fileName').height();
    let file_count = $('.fileName').length;

    $('#file').css({"line-height":file_height*file_count+'px'});
})

// 좋아요
function like(no, id) {
	// 비회원일 시 로그인 유도
	if(id == null || id == '') {
		const guest = confirm("로그인 후 이용 가능합니다.\n로그인 하시겠습니까?");
		if(guest) {
			location.href="/account/logIn";
			return;
		}
	}
	
	const like_url = "/contents/like?no=" + no + "&id=" + id + "&l=like";
	// 좋아요 클릭 시 좋아요 및 이모지 변경
	$.ajax({
		type : "post",
		url : like_url,
		success : function(chk) {
			if(chk) {
				$('#like_wrap').hide();
				$('#unlike_wrap').show();
			} else {
				alert("다시 시도 해 주세요.");				
			}
		}
	});
}

function unlike(no, id) {
	// 좋아요 취소 클릭 시 좋아요 취소 및 이모지 변경
	const unlike_url = "/contents/like?no=" + no + "&id=" + id + "&l=unlike";
	$.ajax({
		type : "post",
		url : unlike_url,
		success : function(chk) {
			if(chk) {
				$('#unlike_wrap').hide();
				$('#like_wrap').show();				
			} else {
				alert("다시 시도 해 주세요.");
			}
		}
	});
}

// 댓글 쓰기 버튼 클릭 시
function comment_focus() {
    $('#comment_txt').focus();
}

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
		url : "/contents/comment?no=" + no + "&nickname=" + nickname + "&contents=" + contents.val(),
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
function sendReply(no, nickname) {
	let contents = $("#reply_txt");
	
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
		url : "/contents/reply?no=" + no + "&nickname=" + nickname + "&contents=" + contents.val(),
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
			url : "/contents/delete_comment?no=" + no,
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
			url : "/contents/delete_reply?no=" + no,
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




