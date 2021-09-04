
//주소 메서드
function sample4_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var roadAddr = data.roadAddress; // 도로명 주소 변수
                var extraRoadAddr = ''; // 참고 항목 변수

                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample4_postcode').value = data.zonecode;
                document.getElementById("sample4_roadAddress").value = roadAddr;
                document.getElementById("sample4_jibunAddress").value = data.jibunAddress;
                
                // 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
                if(roadAddr !== ''){
                    document.getElementById("sample4_extraAddress").value = extraRoadAddr;
                } else {
                    document.getElementById("sample4_extraAddress").value = '';
                }

                var guideTextBox = document.getElementById("guide");
                // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
                if(data.autoRoadAddress) {
                    var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                    guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
                    guideTextBox.style.display = 'block';

                } else if(data.autoJibunAddress) {
                    var expJibunAddr = data.autoJibunAddress;
                    guideTextBox.innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
                    guideTextBox.style.display = 'block';
                } else {
                    guideTextBox.innerHTML = '';
                    guideTextBox.style.display = 'none';
                }
            }
        }).open();
    }

//회원가입 유효성검사
window.onload = function() {
      var join = document.join; //form데이터를 모두 join변수에 저장
      //var errorIndex;
      
      var input = document.querySelectorAll('.check');
      var errorId = [ "idError", "pwError", "pwCheckError", "nameError", "phoneNumError", "emailError" ];
      var error = document.querySelectorAll('.list > span');
   
      
      // 오류문구 초기화 메서드
      function innerReset(error){
         for (var i = 0; i < error.length; i++) {
            error[i].innerHTML = "";
         }
      }
      innerReset(error);
      //ID 입력문자 유효성검사 
      join.id.onkeydown = idCheck();
      function idCheck() {
         innerReset(error);// 오류문구 초기화
         var idLimit = /^[a-zA-Z0-9-_]{5,20}$/; //정규식(a~z, A~Z, 0~9, -, _만 입력가능)
         if (!idLimit.test(input[0].value)) {
            document.getElementById(errorId[0]).innerHTML = "5~20자의 영문 소대문자, 숫자와 특수기호(_),(-)만 사용 가능합니다.";

         }
      }
      //PW 입력문자 유효성검사 
      join.pw.onkeydown = function(){
         innerReset(error);// 오류문구 초기화
         var pwLimit = /^[a-zA-Z0-9~!@#$%^&*()_-]{10,20}$/; //정규식(a~z, A~Z, 0~9, ~!@#$%^&*()_- 만 입력가능)
         if (!pwLimit.test(input[1].value)) {
            document.getElementById(errorId[1]).innerHTML = " 10~20자의 영문 소대문자, 숫자와 특수기호 '~!@#$%^&*()_-'만 사용 가능합니다.";
         }   
      }
/*      //PW 재확인 입력문자 유효성검사 
      join.pwCheck.onkeydown = function(){
         innerReset(error);// 오류문구 초기화   
         if (join.pw.value != join.pwCheck.value) {//pw, pwCheck가 값이 맞지않다면 
            document.getElementById(errorId[2]).innerHTML = "비밀번호가 일치하지 않습니다.";
         }         
      }*/
      //PW 재확인 입력문자 유효성검사 
      join.pwCheck.offkey = function(){
         innerReset(error);// 오류문구 초기화   
      }
      //휴대폰번호 입력문자 유효성검사 
         join.phoneNum.onkeydown = function(){
         innerReset(error);// 오류문구 초기화
            
            var pnumLimit =  /^01[0|1|6|7|8|9]{1}[0-9]{8}$/; // 정규식(^$--> 문자의미, 01, (6자리중 "1자리"), 0~9--> "8자리")
            if (!pnumLimit.test(input[4].value)) { 
               document.getElementById(errorId[4]).innerHTML = " 올바른 형식이 아닙니다. 다시 확인해주세요.";
            }
         }
         
         //이메일 입력 유효성검사 
         join.email.onkeydown = function(){
            innerReset(error);// 오류문구 초기화
               
            var emailLimit = /[0-9a-zA-Z-_.]/; // 정규식 0~9, a~z, A~Z, -, _, .내에서만 입력가능
               if (!emailLimit.test(input[5].value)) { 
                  document.getElementById(errorId[5]).innerHTML = " 올바른 형식이 아닙니다. 영문,숫자, (-)(_)(.) 입력만 가능합니다.";
               }
            }
         
      //submit 실행시 수행할 동작
      join.onsubmit = function() { //join에서 submit이 실행된다면 수행할 함수         
         var errorStr = [ " 아이디를", " 비밀번호를", " 비밀번호 확인을", " 성함을", " 휴대폰번호를", " 이메일을" ];

         
         innerReset(error); // 오류문구 초기화
         
         // input 값 비어짐 여부 확인
         for (var i = 0; i < input.length - 1; i++) { // -1 == submit제외 
            //console.log(input[i]);
            if (!input[i].value) {
               document.getElementById(errorId[i]).innerHTML = errorStr[i]+ " 입력해 주세요.";
               input[i].focus(); // 포커스 이동
               return false; // 종료 (포커스 이동유지를 위해 false 종료)
               break;
            }
         }         
         
         //유효성검사) input 공백확인
        /* if (flag) {
            for (var i = 0; i < input.length - 1; i++) { // -1 == submit제외 
               if (!input[i].value) { // 해당 input에 값이 없다면
                  // 오류문구 출력
                  document.getElementById(errorId[i]).innerHTML = errorStr[i]+ " 입력해 주세요.";
                  input[i].focus(); // 포커스 이동
                  return false; // 종료 (포커스 이동유지를 위해 false 종료)
               }
            }
         }*/
         
         // 유효성검사) *주소* input 값 비어짐 여부 확인
         {//지역변수 스코프 조정(address) -일회성사용
            var inputAddress = document.querySelectorAll('.addressCheck');
            //inputAddress.splice(4, 1); 
            for(var i = 0; i < inputAddress.length; i++){
               //console.log(inputAddress[i]);
               if(!inputAddress[i].value){
                  document.getElementById("addressError").innerHTML = " 주소 혹은 상세주소를 입력해주세요.";
                  return false;   
               }
            }
         }
         //유효성검사) 비밀번호 재확인
         if (join.pw.value != join.pwCheck.value) {
            document.getElementById("pwCheckError").innerHTML = " 비밀번호가 일치하지 않습니다.";
            join.pwCheck.focus(); // 포커스 이동
            return false;
         }
                  
         var idLimit = /^[a-zA-Z0-9-_]{5,20}$/; //정규식(a~z, A~Z, 0~9, -, _만 입력가능)
         var pwLimit = /^[a-zA-Z0-9~!@#$%^&*()_-]{10,20}$/;///[a-zA-Z0-9]{10, 20}/; //정규식(a~z, A~Z, 0~9,~!@#$%^&*()_-특수문자 만 입력가능)
         var pnumLimit =  /^01[0|1|6|7|8|9]{1}[0-9]{8}$/; // 01로 시작, 0,1,6,7,8,9 중 한자리, 0~9에서 8자리 입력
         var emailLimit = /[0-9a-zA-Z-_.]/; // 정규식 0~9, a~z, A~Z, -, _, .내에서만 입력가능
         
         if (!idLimit.test(input[0].value)) {
            document.getElementById(errorId[0]).innerHTML = " 5~20자의 영문 소대문자, 숫자와 특수기호(_),(-)만 사용 가능합니다.";
            join.id.focus(); // 포커스 이동
            return false;
         }
         if (!pwLimit.test(input[1].value)) {
            document.getElementById(errorId[1]).innerHTML = " 10~20자의 영문 소대문자, 숫자와 특수기호 '~!@#$%^&*()_-'만 사용 가능합니다.";
            //console.log(input[1].value);
            //console.log(pwLimit.test(input[1].value));
            join.pw.focus(); // 포커스 이동
            return false;
         }         
         if (!pnumLimit.test(input[4].value)) { 
            document.getElementById(errorId[4]).innerHTML = " 올바른 형식이 아닙니다. 다시 확인해주세요.";
            join.phoneNum.focus(); // 포커스 이동
            return false;
         }
         if (!emailLimit.test(input[5].value)) { 
            document.getElementById(errorId[5]).innerHTML = " 올바른 형식이 아닙니다. 영문,숫자, (-)(_)(.) 외 입력은 불가합니다.";
            join.email.focus(); // 포커스 이동
            return false;
         }
         if (document.getElementById("mail_Select").value=="이메일 선택") { 
            document.getElementById(errorId[5]).innerHTML = " 이메일을 선택해주세요.";
            return false;
         }
         //console.log(document.getElementById("mail_Select").value);
         
         // 개인정보 동의박스 체크
         var consentCheck = document.getElementById("check");
         //console.log(consentCheck);
         if(!consentCheck.checked){
            document.getElementById("consentError").innerHTML = "개인정보 수집이용 동의를 해주세요.";
            return false;
         }
         
         alert("회원가입이 완료되었습니다. 참치라이더의 멤버가 되신 것을 환영합니다!! :D");


      }//join.onsublit

   }//window