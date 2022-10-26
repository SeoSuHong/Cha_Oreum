// main
// id="file"의 line-height 설정
$(function() {
    const file_height = $('.fileName').height();
    let file_count = $('.fileName').length;

    $('#file').css({"line-height":file_height*file_count+'px'});
})

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
