// main
// 필터 검색 기능
function search() {
    let field = $('#field').val();
    let keyword = $('#keyword').val();

    if(keyword == '') {
        alert('검색 키워드를 입력해 주세요.');
    } else {
        if(field === 'title') {
            $('#title').val(keyword);
            $('#nickname').val('');
        } else {
            $('#nickname').val(keyword);
            $('#title').val('');
        }
        indexForm.submit();
    }
}

// 정렬 기능
function sort(s) {
    $('#sort').val(s);
    indexForm.submit();
}

// 공지사항 show and hide
$(function() {
	$("#notice_btn").click(function() {
		if($("#notice").is(':visible')) {
			$('#notice').stop().slideUp();
			$("#notice_btn").val("공지사항 펼치기");
		} else {
			$('#notice').stop().slideDown();
			$("#notice_btn").val("공지사항 숨기기");
		}
	})
});

// 페이지 클릭 시
$(function() {
	// 첫 페이지로 이동
	$('#firstPage').click(function() {
        $('#page').val(1);

        indexForm.submit();
    })
    
    $('.page').click(function() {
        let page = $(this).text();
        $('#page').val(page);

        indexForm.submit();
    })
})

// 이전 블럭으로 이동
function movePrevPage(firstPage) {
	$('#page').val(firstPage - 5);
    indexForm.submit();
}

// 다음 블럭으로 이동
function moveNextPage(firstPage) {
	$('#page').val(firstPage + 5);
    indexForm.submit();
}

// 마지막 페이지로 이동
function moveLastPage(endPage) {
	$('#page').val(endPage);
    indexForm.submit();
}

function scrollToTop() {
    let timeOut;

    if (document.body.scrollTop!=0 || document.documentElement.scrollTop!=0){
        window.scrollBy(0,-50);
        timeOut=setTimeout('scrollToTop()',10);
    }
    else clearTimeout(timeOut);
}