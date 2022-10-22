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
	let userId = $("#userId").val();
	let form_data = new FormData();
	
	form_data.append('file', file);
	form_data.append('id', userId);
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

// 수정 버튼 클릭 시
function edit() {
	if(editForm.title.value == null || editForm.title.value == '') {
		alert("제목을 입력해 주세요.");
		editForm.title.focus(); return;
	}
	if(editForm.contents.value == null || editForm.contents.value == '') {
		alert("내용을 입력해 주세요.");
		editForm.contents.focus(); return;
	}
	
	editForm.submit();
}