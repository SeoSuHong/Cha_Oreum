// main
// 파일 삭제 클릭 시
function file_delete(obj) {
    let del = $(obj).parent();
    $(del).remove();
}

// summernote 에디터
$(document).ready(function() {
	$('#contents').summernote({
		  height: 500,
		  minHeight: null,
		  maxHeight: null,
		  lang: "ko-KR",
		  placeholder: '내용을 입력해 주세요.'
	});
});