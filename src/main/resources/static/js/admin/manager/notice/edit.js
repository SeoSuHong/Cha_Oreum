// main
// 첫 화면 서브 카테고리 설정
$(function() {
	let mainCategory = $("#mainCategory").val();
	let subCategory = $("#prevSubCategory").val();
	
	$.ajax({
		type : "post",
		url : "/board/contents/getScByMc?no=" + mainCategory,
		success : function(list) {				
			for(let i = 0; i < list.length; i++){
				$("#subCategory").append("<option value='" + list[i].no +"'>" + list[i].name + "</option>");
				if(list[i].name === subCategory) {
					$("#subCategory").val(list[i].no).prop("selected", true);
				}
			}
		}
	})
})

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

// 파일 삭제 클릭 시
function file_delete(obj, fileName) {
	$("#edit_btn").append("<input type='hidden' name='remove_fileName' value='" + fileName + "'>");
	
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

// 수정 버튼 클릭 시
function edit() {
	if(editForm.mainCategory.value == null || editForm.mainCategory.value == '') {
		alert("mainCategory를 선택해 주세요.");
		editForm.mainCategory.focus(); return;
	}
	if(editForm.subCategory.value == null || editForm.subCategory.value == '') {
		alert("subCategory를 선택해 주세요.");
		editForm.subCategory.focus(); return;
	}
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