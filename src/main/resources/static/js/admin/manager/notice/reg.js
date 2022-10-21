// main
// summernote 에디터
$(document).ready(function() {
	$('#contents').summernote({
		  height: 500,
		  minHeight: null,
		  maxHeight: null,
		  lang: "ko-KR",
		  placeholder: '내용을 입력해 주세요.',
		  callbacks : {
			onImageUpload : function(files) {
				for(let i = files.length - 1; i >= 0; i--) {
					sendFile(files[i], this);
				}
			}
		}
	});
});

function sendFile(file, el) {
	let adminId = $("#adminId").val();
	let form_data = new FormData();
	
	form_data.append('file', file);
	form_data.append('id', adminId);
	$.ajax({
		data : form_data,
		type : "post",
		url : "notice_fileUpload",
		cache : false,
		contentType : false,
		encType : "multipart/form-data",
		processData : false,
		success : function(img_name) {
			$(el).summernote('editor.insertImage', img_name);
		}
	})
}

// 작성 버튼 클릭 시
function regPost() {
	if(regForm.title.value == '') {
		alert("제목을 입력해 주세요.");
		regForm.title.focus(); return;
	}
	if(regForm.contents.value == '') {
		alert("내용을 입력해 주세요.");
		regForm.contents.focus(); return;
	}
	regForm.submit();
}