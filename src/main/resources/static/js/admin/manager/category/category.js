// 메인 카테고리 관리
function appendMain() {
	let mainTbl = $("#mainCategory");
	let appendHtml = 
				"<tr class='categoryTr'>" + 
					"<th></th>" +
					"<th><input class='addName'></th>" +
					"<th>0</th>" + 
					"<th id='categoryBtn'>" +
						"<input type='button' class='btn' value='추가' onclick='appendMainBtn(this)'>" +
					"</th>" + 
				"</tr>";
	
	mainTbl.append(appendHtml);
}

function appendMainBtn(obj) {
	let name = $(obj).parent().prev().prev().find(".addName");
	if(name.val() == null || name.val() === '') {
		alert("이름을 입력해 주세요.");
		name.focus(); return;
	}
	
	$.ajax({
		url : "regMainCategory",
		type : "POST",
		data : {"name": name.val()},
		success : function(result){
			if(result) {
				location.reload();
			} else {
				alert("다시 시도해 주세요.");
				name.focus();
			}
		},
		error : function() {
			alert("다시 시도해 주세요.");
			name.focus();
		}
	})
}

function editMain(obj, no) {
	let name = $(obj).parent().prev().prev().find(".name");
	let prev_nameVal = $(name).val();
	let buttonCss = {"border":"none", "padding-left":"0"};
	let textCss = {"border":"2px solid black", "border-radius":"5px", "padding-left":"10px"};
	
	$(name).prop("type", "text");
	$(name).css(textCss);
	$(name).focus().val('').val(prev_nameVal);
	
	$(name).keydown(function(e) {
		if(e.keyCode == 13) {
			$(name).blur();
		}
	})

	$(name).one("blur", function() {
		$(name).css(buttonCss);
		$(name).prop("type", "button");
		
		let curr_nameVal = $(name).val();
		if(prev_nameVal !== curr_nameVal) {
			$.ajax({
				url : "editMainCategory",
				type : "POST",
				data : {"no": no, "name": curr_nameVal},
				success : function(result) {
					if(!result) {
						alert("수정에 실패하였습니다.\n다시 시도해 주세요.");
						$(name).val(prev_nameVal);
					}
				},
				error : function() {
					alert("수정에 실패하였습니다.\n다시 시도해 주세요.");
					$(name).val(prev_nameVal);
				}
			})
		}
	})
}

function deleteMain(no) {
	let check = confirm("삭제 시 하위 카테고리 및 게시글이 전부 삭제됩니다.\n정말로 삭제하시겠습니까?");
	
	if(check) {
		$.ajax({
			url : "deleteMainCategory",
			type : "POST",
			data : {"no": no},
			success: function(result) {
				if(result) {
					location.reload();
				} else {
					alert("다시 시도해 주세요");
				}
			},
			error : function() {
				alert("다시 시도해 주세요.");
			}
		})
	}
}

// 서브 카테고리 관리
function appendSub() {
	let subTbl = $("#subCategory");
	let appendHtml = 
				"<tr class='categoryTr'>" + 
					"<th></th>" +
					"<th><input class='addMainCategory_no'></th>" +
					"<th><input class='addName'></th>" +
					"<th>0</th>" + 
					"<th id='categoryBtn'>" +
						"<input type='button' class='btn' value='추가' onclick='appendSubBtn(this)'>" +
					"</th>" + 
				"</tr>";
	
	subTbl.append(appendHtml);
}

function appendSubBtn(obj) {
	let mainCategory_no = $(obj).parent().prev().prev().prev().find(".addMainCategory_no");
	let name = $(obj).parent().prev().prev().find(".addName");
	
	if(mainCategory_no.val() == null || mainCategory_no.val() === '') {
		alert("메인 카테고리 번호를 입력해 주세요.");
		mainCategory_no.focus(); return;
	}
	if(name.val() == null || name.val() === '') {
		alert("이름을 입력해 주세요.");
		name.focus(); return;
	}
	
	$.ajax({
		url : "regSubCategory",
		type : "POST",
		data : {
			"mainCategory_no": mainCategory_no.val(),
			"name": name.val()
			},
		success : function(result){
			if(result) {
				location.reload();
			} else {
				alert("다시 시도해 주세요.");
				name.focus();
			}
		},
		error : function() {
			alert("메인 카테고리 번호가 존재하지 않습니다.\n다시 시도해 주세요.");
			name.focus();
		}
	})
}

function editSub(obj, no) {
	let mainCategory_no = $(obj).parent().prev().prev().prev().find(".mainCategory_no");
	let name = $(obj).parent().prev().prev().find(".name");
	let prev_mainCategoryVal = $(mainCategory_no).val();
	let prev_nameVal = $(name).val();
	let buttonCss = {"border":"none", "padding-left":"0"};
	let textCss = {"border":"2px solid black", "border-radius":"5px", "padding-left":"10px"};
	
	$(mainCategory_no).prop("type", "text");
	$(mainCategory_no).css(textCss);
	
	$(name).prop("type", "text");
	$(name).css(textCss);
	$(name).focus().val('').val(prev_nameVal);
	
	
	$(mainCategory_no).attr("id", "checkEle");
	$(name).attr("id", "checkEle");
	
	$(mainCategory_no).keydown(function(e) {
		if(e.keyCode == 13) {
			$(name).blur();
			$(mainCategory_no).blur();
		}
	})
	$(name).keydown(function(e) {
		if(e.keyCode == 13) {
			$(name).blur();
			$(mainCategory_no).blur();
		}
	})
	
	$('body').on("click || keydown", function(){
		if($(':focus').attr('id') != 'checkEle') {
			$(mainCategory_no).css(buttonCss);
			$(mainCategory_no).prop("type", "button");
			
			$(name).css(buttonCss);
			$(name).prop("type", "button");
		
			let curr_mainCategoryVal = $(mainCategory_no).val();
			let curr_nameVal = $(name).val();
			if(prev_mainCategoryVal != curr_mainCategoryVal || prev_nameVal !== curr_nameVal) {
				$.ajax({
					url : "editSubCategory",
					type : "POST",
					data : {"no": no, "mainCategory_no": curr_mainCategoryVal, "name": curr_nameVal},
					success : function(result) {
						if(!result) {
							alert("수정에 실패하였습니다.\n다시 시도해 주세요.");
							$(mainCategory_no).val(prev_mainCategoryVal);
							$(name).val(prev_nameVal);
						}
					},
					error : function() {
						alert("수정에 실패하였습니다.\n다시 시도해 주세요.");
						$(mainCategory_no).val(prev_mainCategoryVal);
						$(name).val(prev_nameVal);
					}
				})
			}
			$(mainCategory_no).removeAttr("id");
			$(name).removeAttr("id");
			$('body').off('keydown');
			$('body').off('click');
		}
	});
}

function deleteSub(no) {
	let check = confirm("삭제 시 하위 게시글이 전부 삭제됩니다.\n정말로 삭제하시겠습니까?");
	
	if(check) {
		$.ajax({
			url : "deleteSubCategory",
			type : "POST",
			data : {"no": no},
			success: function(result) {
				if(result) {
					location.reload();
				} else {
					alert("다시 시도해 주세요");
				}
			},
			error : function() {
				alert("다시 시도해 주세요.");
			}
		})
	}
}