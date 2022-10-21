function noticeDelete(no) {
	let check = confirm("정말 삭제하시겠습니까?");
	
	if(check) {
		location.href='delete?no=' + no;
	}
}