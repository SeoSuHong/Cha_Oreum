function login_check() {
    var id = login_frm.id;
    var pwd = login_frm.password;

    if (id.value == "") {
        alert("아이디를 입력해 주세요.");
        id.focus();
        return;
    }

    if (pwd.value == "") {
        alert("비밀번호를 입력해 주세요.");
        pwd.focus();
        return;
    }

    login_frm.submit();
}