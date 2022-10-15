
function secession_fn() {
	
	if (confirm("정말로 탈퇴 하시겠습니까?\n회원님의 모든 정보와 데이터가 손실됩니다.")) {
              document.secession.submit(); 
        }   
        else {
            return false;
        }
 
}