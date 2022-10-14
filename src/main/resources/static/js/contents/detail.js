// main
// id="file"의 line-height 설정
$(function() {
    const file_height = $('.fileName').height();
    let file_count = $('.fileName').length;

    $('#file').css({"line-height":file_height*file_count+'px'});
})

// 댓글 쓰기 버튼 클릭 시
function comment_focus() {
    $('#comment_txt').focus();
}

// 답글 쓰기 버튼 클릭 시
$(function() {
    let reply_btn = $('.reply_btn');

    $(reply_btn).click(function() {
        $($(this).parent().parent().next()).show();
    })
})