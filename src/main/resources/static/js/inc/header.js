// header
$(function() {
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