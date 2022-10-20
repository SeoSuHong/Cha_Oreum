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

// 메인 카테고리 클릭 시 서브 카테고리 슬라이드
$(function() {
    $('.mainCategory').click(function() {
        let sub = $(this).next();
        let sub_cnt = $(sub).children().length;
        const sub_height = 42;

        if($(sub).css('height') === '0px') {
            $(sub).animate({height:sub_cnt*sub_height+"px"}, 300);
        } else {
            $(sub).animate({height:'0'}, 300);
        }
    })
})

// My 클릭 시
function myContents(nickname) {
	if(nickname != null && nickname != '') {
		location.href = "/?n=" + nickname;
	} else {
		const message = confirm('회원만 이용이 가능합니다.\n로그인 하시겠습니까?');
		
		if(message) {
			location.href = "/account/logIn";
		}
	}
}

// 카테고리 클릭 시 parameter 전달
function category(category_no, nickname) {
	let path;
	
	if(nickname != '') {
	    path = '/?c=' + category_no + '&n=' + nickname;
	} else {
		path = '/?c=' + category_no;
	}
	
	location.href = path;
}