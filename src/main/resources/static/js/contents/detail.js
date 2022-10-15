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

    $(reply_btn).click(function() {
        $($(this).parent().parent().next()).show();
    })
})

// 댓글 입력 버튼 클릭 시
