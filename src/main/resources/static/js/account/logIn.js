function login_check() {
    var id = document.getElementById("input_id");
    var pwd = document.getElementById("input_password");

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

    alert("로그인 되었습니다.");

    document.login_frm.submit();
}