var id_ch = false;
var nickname_ch = false;
var defualt_id = "";
var defualt_nickname = "";
var join_id = "";
var join_nickname = "";

function signup_check() {
	var id = document.getElementById("input_id");
	var pwd = document.getElementById("input_password");
	var pwd_ch = document.getElementById("input_password_check");
	var nickname = document.getElementById("input_nickname");
	var email_front = document.getElementById("input_email_front");
	var email_back = document.getElementById("input_email_back");
	var email = email_front.value + '@' + email_back.value;
	var email_check = false;

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

	$.ajax({
		url: "/account/email_check",
		type: "POST",
		dataType: "JSON",
		data: { "email": email },
		success: function(data) {
			if (data == 1) {
				alert("중복된 이메일 입니다.");
				email_front.focus();
				return false;
			} else if (data == 0) {
				alert("사용가능한 이메일 입니다.");
				email_check = true;
				join_id = document.getElementById("input_id").value;
				join_nickname = document.getElementById("input_nickname").value;
				if ((id_ch == true && nickname_ch == true) && (defualt_id == join_id && defualt_nickname == join_nickname && email_check == true)) {

					document.signup_frm.submit();
				} else {
					if (id_ch != true) {
						alert("아이디 중복확인을 해주세요");
						return false;
					}
					if (nickname_ch != true) {
						alert("닉네임 중복확인을 해주세요");
						return false;
					}
					if (defualt_id != join_id) {
						alert("아이디 중복확인을 해주세요");
						return false;
					}
					if (defualt_nickname != join_nickname) {
						alert("닉네임 중복확인을 해주세요");
						return false;
					}

				}

			}
		}
	})

}

function id_check_f() {
	var id = document.getElementById("input_id");
	if (id.value == "") {
		alert("아이디를 입력하세요.");
		id.focus();
		return false;
	}

	$.ajax({
		url: "/account/id_check",
		type: "POST",
		dataType: "JSON",
		data: { "id": $("#input_id").val() },
		success: function(data) {
			if (data == 1) {
				alert("중복된 아이디입니다.");
				id_ch = false;
				id.focus();
			} else if (data == 0) {
				alert("사용가능한 아이디입니다.");
				defualt_id = document.getElementById("input_id").value;
				id_ch = true;
			}
		}
	})
}

function nickname_check_f() {
	var nickname = document.getElementById("input_nickname");
	if (nickname.value == "") {
		alert("닉네임를 입력하세요.");
		nickname.focus();
		return false;
	}
	$.ajax({
		url: "/account/nickname_check",
		type: "POST",
		dataType: "JSON",
		data: { "nickname": $("#input_nickname").val() },
		success: function(data) {
			if (data == 1) {
				alert("중복된 닉네임입니다.");
				nickname.focus();
				nickname_ch = false;
			} else if (data == 0) {
				alert("사용가능한 닉네임입니다.");
				defualt_nickname = document.getElementById("input_nickname").value;
				nickname_ch = true;
			}
		}
	})
}