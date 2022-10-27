

function deleteMember(id) {
	let check = confirm("정말 "+ id +" 님을 추방하시겠습니까?");
	if(check) {
		location.href='delete?id=' + id;
	}
}

function upgradeMember(id, role) {
	let check = confirm("정말 "+ id +" 님 권한을 변경하시겠 습니까?");
	if(check) {
		location.href='upgrade?id=' + id + '&role_=' + role;
	}
}

function search() {
	let field = $("#field").val();
	let keyword = $("#keyword");
	
	if(keyword.val() == null || keyword.val() == '') {
		alert("키워드를 입력해 주세요.");
		keyword.focus();
	}
	
	postForm.e.value = '';
	postForm.n.value = '';
	postForm.i.value = '';
	postForm.p.value = '';
	
	if(field === 'email') postForm.e.value = keyword.val();
	else if(field === 'nickname') postForm.n.value = keyword.val();
	else if(field === 'id') postForm.i.value = keyword.val();
	
	postForm.submit();
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