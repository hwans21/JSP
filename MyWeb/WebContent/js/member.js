
function joinConfirm(){
	
	//alert('ㅎㅎ~!')//경고문
	
	
	//자바스크립트는 태그의 이름을 참조하여 태그에 접근하는 형태로 사용됩니다.
	//document는 문서를 뜻합니다.
	//문서 내에 태그 이름이 reg_form이라는 태그 내부에 name속성이 id인 값의 여부.
	if(document.reg_form.id.value == '') {
		alert("아이디는 필수 사항입니다");
		reg_form.id.focus(); //태그안에 마우스 포커스
		return; //입력값 유효성이 잘못되었으므로 메서드 강제 종료
	}
	
	if(document.reg_form.pw.value == '') {
		alert("비밀번호는 필수 사항입니다");
		reg_form.pw.focus();
		return;
	}
	
	if(document.reg_form.name.value == '') {
		alert("이름은 필수 사항입니다");
		reg_form.name.focus();
		return;
	}
	
	//id의 값의 길이
	if(document.reg_form.id.value.length < 4) {
		alert("아이디는 4글자 이상이어야 합니다");
		reg_form.id.focus();
		return;
	}
	
	if(document.reg_form.pw.value.length < 4) {
		alert("비밀번호는 4글자 이상이어야 합니다");
		reg_form.pw.focus();
		return;
	}
	
	if(document.reg_form.pw.value != document.reg_form.pw_check.value){
		alert("비밀번호가 틀렸습니다. 비밀번호 확인란을 확인하세요");
		reg_form.pw_check.focus();
		return;
	}
	
	//confirm()메서드는 확인, 취소 여부를 물어보는 JS 메서드입니다.
	//확인버튼 클릭시 true, 취소 버튼 클릭시 false
	if(confirm("회원가입 하시겠습니까?")) {
		reg_form.submit(); //자바스크립트의 submit
	} else {
		return;
	}
	
	
	
	
	
	
	
	
}

