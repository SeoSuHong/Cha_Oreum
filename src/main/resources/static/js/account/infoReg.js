var nickname_ch = false;
var defualt_nickname = "";
var join_nickname = "";
var defualt_email = "";
var join_email = "";

function infoReg_check() {
	var pwd = document.getElementById("input_password");
	var pwd_ch = document.getElementById("input_password_check");
	var nickname = document.getElementById("input_nickname");
	var email_front = document.getElementById("input_email_front");
	var email_back = document.getElementById("input_email_back");
	var email = email_front.value + '@' + email_back.value;
	var email_check = false;
	var hidden_nickname = document.getElementById("hidden_nickname");
	var hidden_email = document.getElementById("hidden_email");
	

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
				if(email == hidden_email.value){
					email_check = true;
					join_nickname = document.getElementById("input_nickname").value;
					if(nickname.value == hidden_nickname.value){
						nickname_ch = true;
						nickname_overlap = true;
					}
					if(defualt_nickname == join_nickname) nickname_overlap = true
					if ((nickname_ch == true) && (nickname_overlap && email_check == true)) {
						document.infoReg_frm.submit();
					}else {
						if (nickname_ch != true) {
							alert("닉네임 중복확인을 해주세요");
							return false;
						}
						if (defualt_nickname != join_nickname) {
							alert("닉네임 중복확인을 해주세요");
							return false;
						}

					}
				}else{
					alert("중복된 이메일 입니다.");
					email_front.focus();
					return false;
				}
			} else if (data == 0) {
				email_check = true;
				join_nickname = document.getElementById("input_nickname").value;
				if(nickname.value == hidden_nickname.value){
					nickname_ch = true;
					nickname_overlap = true;
				}
				if(defualt_nickname == join_nickname) nickname_overlap = true;
				if ((nickname_ch == true) && (nickname_overlap && email_check == true)) {
					document.infoReg_frm.submit();
				} else {
					if (nickname_ch != true) {
						alert("닉네임 중복확인을 해주세요");
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


	function nickname_check_f() {
		
		var nickname = document.getElementById("input_nickname");
		var hidden_nickname = document.getElementById("hidden_nickname");
		
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
					
					if(nickname.value == hidden_nickname.value){
						nickname_ch = true;
						alert("고객님께서 사용하고 있는 닉네임입니다.");
					}else{
						alert("중복된 닉네임입니다.");
						nickname.focus();
						nickname_ch = false;
					}
						
				} else if (data == 0) {
					alert("사용가능한 닉네임입니다.");
					defualt_nickname = document.getElementById("input_nickname").value;
					nickname_ch = true;
				}
			}
		})
	}