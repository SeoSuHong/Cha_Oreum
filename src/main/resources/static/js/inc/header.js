// header
$(function() {
	const userInfo_width = 130;
	let userNick_width = $("#userNick").outerWidth();
	let userInfo_right = -((userInfo_width - userNick_width) / 2);
	
	$("#userInfo").css("right", userInfo_right + "px");
	
    $("#userNick").hover(function() {
        $('#userInfo').stop().slideDown();
    }, function() {
        $('#userInfo').stop().slideUp();
    });
    $("#userInfo").hover(function() {
        $(this).stop().slideDown();
    }, function() {
        $(this).stop().slideUp();
    });
})

function logOut() {
	let url = '/';
	var form = $('<form action="' + url + '" method="post"></form>');
	$('body').append(form);
	form.submit();
}