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

// 페이지 클릭 시
$(function() {
    $('.page').click(function() {
        let page = $(this).text();
        $('#page').val(page);

        indexForm.submit();
    })
})

function scrollToTop() {
    let timeOut;

    if (document.body.scrollTop!=0 || document.documentElement.scrollTop!=0){
        window.scrollBy(0,-50);
        timeOut=setTimeout('scrollToTop()',10);
    }
    else clearTimeout(timeOut);
}