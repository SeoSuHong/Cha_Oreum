// main
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

function changeMainCategory() {
	let no = $("#mainCategory").val();
	
	$.ajax({
		type : "post",
		url : "/contents/getScByMc?no=" + no,
		success : function(list) {
			for(let i = 0; i < list.length; i++){				
				console.log(list[i].no);
				console.log(list[i].mainCategory_no);
				console.log(list[i].name);
			}
		}
	})
}