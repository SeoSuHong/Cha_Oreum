function findid_check() {
    var email_front = document.getElementById("email_front");
    var email_back = document.getElementById("email_back");
	var email = email_front.value + '@' + email_back.value;
	var exptext = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;
	
    if (email_front.value == "") {
        alert("이메일을 입력하세요.");
        email_front.focus();
        return false;
    }

    if (email_back.value == "") {
        alert("이메일을 입력하세요.");
        email_back.focus();
        return false;
    }
    
    if (exptext.test(email) == false) {
		alert("이메일형식이 올바르지 않습니다.");
		email_front.focus();
		return false;
	}

    document.findid_frm.submit();
}