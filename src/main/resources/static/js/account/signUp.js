var id_ch = false;
var nickname_ch = false;

function signup_check() {
    var id = document.getElementById("input_id");
    var pwd = document.getElementById("input_password");
    var pwd_ch = document.getElementById("input_password_check");
    var nickname = document.getElementById("input_nickname");
    var email_front = document.getElementById("input_email_front");
    var email_back = document.getElementById("input_email_back");

    if (id.value == "") {
        alert("아이디를 입력하세요.");
        id.focus();
        return false;
    }

    if (pwd.value == "") {
        alert("비밀번호를 입력하세요.");
        pwd.focus();
        return false;
    }

    if (pwd_ch.value == "") {
        alert("비밀번호 확인을 입력해주세요.");
        pwd_ch.focus();
        return false;
    }

    if (pwd.value != pwd_ch.value) {
        alert("비밀번호가 일치하지 않습니다.");
        pwd_ch.focus();
        return false;
    }

    if (nickname.value == "") {
        alert("닉네임를 입력하세요.");
        nickname.focus();
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

    if (id_ch == "true" && nickname_ch == "true"){
    alert("회원가입 되었습니다.");

    document.signup_frm.submit();
    }
}

function id_check() {
	$.ajax({
		url : "",
		type : "POST",
		dataType : "JSON",
		data : {"id" : $("#input_id").val()},
		success : function (data) {
			if(data == 1){
				alert("중복된 아이디입니다.");
				id_ch = false;
			} else if (data == 0){
				alert("사용가능한 아이디입니다.");
				id_ch = true;
			}
		}
	})
}

function nickname_check() {
	$.ajax({
		url : "",
		type : "POST",
		dataType : "JSON",
		data : {"nickname" : $("#input_nickname").val()},
		success : function (data) {
			if(data == 1){
				alert("중복된 닉네임입니다.");
				id_ch = false;
			} else if (data == 0){
				alert("사용가능한 닉네임입니다.");
				id_ch = true;
			}
		}
	})
}