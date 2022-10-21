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
		url : "/board/contents/contents_fileUpload",
		cache : false,
		contentType : false,
		encType : "multipart/form-data",
		processData : false,
		success : function(img_name) {
			$(el).summernote('editor.insertImage', img_name);
		}
	})
}

// 메인 카테고리 선택 시 서브 카테고리 가져옴
function changeMainCategory() {
	let no = $("#mainCategory").val();
	
	if(no != null && no != '') {
		$.ajax({
			type : "post",
			url : "/board/contents/getScByMc?no=" + no,
			success : function(list) {
				$("#subCategory option").remove();
				$("#subCategory").append("<option value=''> -- 선택해 주세요 -- </option>");				
				for(let i = 0; i < list.length; i++){
					$("#subCategory").append("<option value='" + list[i].no +"'>" + list[i].name + "</option>");
				}
			}
		})
	} else {
		$("#subCategory option").remove();
		$("#subCategory").append("<option value=''> -- 선택해 주세요 -- </option>");
	}
}

// 작성 버튼 클릭 시
function regPost() {
	if(regForm.mainCategory.value == '') {
		alert("Main Category를 선택해 주세요.");
		regForm.mainCategory.focus(); return;
	}
	if(regForm.subCategory.value == '') {
		alert("Sub Category를 선택해 주세요.");
		regForm.subCategory.focus(); return;
	}
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