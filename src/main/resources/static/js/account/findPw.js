var email_certification = "";
var email_certification_check = false;

function findPw_check_fn() {
	
	var id_check_email = document.getElementById("input_id").value;
    var id = document.getElementById("input_id");
    var email_front = document.getElementById("email_front");
    var email_back = document.getElementById("email_back");
    var certification = document.getElementById("input_certification");
    var pwd = document.getElementById("input_password");
    var pwd_ch = document.getElementById("input_password_check");
	var email = email_front.value +'@'+ email_back.value;
	
    if (id.value == "") {
        alert("아이디를 입력하세요.");
        id.focus();
        return false;
    }
    
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
    
    if (certification.value == "") {
        alert("인증번호를 입력하세요.");
        certification.focus();
        return false;
    }

    if (pwd.value == "") {
        alert("새로운 비밀번호를 입력하세요.");
        pwd.focus();
        return false;
    }

    if (pwd_ch.value == "") {
        alert("비밀번호 확인을 입력하세요.");
        pwd_ch.focus();
        return false;
    }

    if (pwd.value != pwd_ch.value) {
        alert("비밀번호가 일치하지 않습니다.");
        pwd_ch.focus();
        return false;
    }
    
    if (email_certification_check != true) {
        alert("인증번호를 발송해주세요.");
        certification.focus();
        return false;
    }
    /*$.ajax({
		url: "/account/certificationNumber?email=" + email,
		type: "POST",
		success: function(data) {
			
			email_certification = data;
			alert('인증번호가 전송되었습니다.');
			email_certification_check = true;
			
		},
		error: function(data){
			
	        alert('이메일 인증에 실패하였습니다.');
	        return false;
	    }
	});*/
    $.ajax({
		url: "/account/id_email?id=" + id_check_email,
		type: "POST",
		success: function(data) {
			if (data != email) {
				console.log(data);
				alert("인증에 실패하였습니다\n다시한번 확인해주세요.");
				return false;
					
			} else if (data == email) {
				if(email_certification == certification.value){
					document.findPw_frm.submit();
				}else{
					alert('인증번호가 일치하지 않습니다.')
				}
				
			}
		}
	})

}

function email_check_fn() {
	
	var email_front = document.getElementById("email_front");
    var email_back = document.getElementById("email_back");
	var email = email_front.value +'@'+ email_back.value;
	
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
	
	$.ajax({
		url: "/account/certificationNumber?email=" + email,
		type: "POST",
		success: function(data) {
			
			email_certification = data;
			alert('인증번호가 전송되었습니다.');
			email_certification_check = true;
			
		},
		error: function(data){
			
	        alert('이메일 인증에 실패하였습니다.');
	        return false;
	    }
	});
	
}