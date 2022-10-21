// aside
// 카테고리 숨기기 클릭 시 카테고리 숨김
$(function() {
    $('.hide_btn').click(function() {
        $('aside').animate({width:'0px'}, 500);
        $('#hideMenu').hide();
        setTimeout(function() {
            $('#showMenu').show();
            $('aside').css({"border-right":'none'});
        }, 500);
    })
    $('.show_btn').click(function() {
        $('aside').animate({width:'300px'}, 500);
        $('#showMenu').hide();
        setTimeout(function() {
            $('#hideMenu').show();
        }, 500)
        $('aside').css({"border-right":'2px solid #AEAEAE'});
    })
})