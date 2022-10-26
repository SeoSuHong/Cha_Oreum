function search() {
	let field = $("#field").val();
	let keyword = $("#keyword");
	
	if(keyword.val() == null || keyword.val() == '') {
		alert("키워드를 입력해 주세요.");
		keyword.focus();
	}
	
	postForm.t.value = '';
	postForm.c.value = '';
	postForm.i.value = '';
	postForm.p.value = '';
	
	if(field === 'title') postForm.t.value = keyword.val();
	else if(field === 'category') postForm.c.value = keyword.val();
	else if(field === 'id') postForm.i.value = keyword.val();
	
	postForm.submit();
}

// 삭제 버튼 클릭 시
function deletePost(no) {
	let check = confirm("게시글 삭제 시 하위 댓글도 전부 삭제됩니다.\n정말 삭제하시겠습니까?");
	
	if(check) location.href = 'delete?no=' + no;
}

// 페이지 클릭 시
$(function() {
	// 첫 페이지로 이동
	$('#firstPage').click(function() {
        postForm.p.value = 1;

        postForm.submit();
    })
    
    $('.page').click(function() {
        let page = $(this).text();
        postForm.p.value = page;

        postForm.submit();
    })
})

// 이전 블럭으로 이동
function movePrevPage(firstPage) {
	postForm.p.value = firstPage - 5;
    postForm.submit();
}

// 다음 블럭으로 이동
function moveNextPage(firstPage) {
	postForm.p.value = firstPage + 5;
    postForm.submit();
}

// 마지막 페이지로 이동
function moveLastPage(endPage) {
	postForm.p.value = endPage;
    postForm.submit();
}