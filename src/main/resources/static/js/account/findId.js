function findid_check() {
    var email_front = document.getElementById("email_front");
    var email_back = document.getElementById("email_back");

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

    document.findid_frm.submit();
}