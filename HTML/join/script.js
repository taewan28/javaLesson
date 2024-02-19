// 작성자 : 김태완

document.getElementById('join').addEventListener('click', function save(){
    
        const id = document.querySelector('input[name="name"]')
        const password = document.querySelector('input[name="password"]')


        let regex = /^[a-zA-Z가-힣]{2,5}$/
        

        let isValid = true              
        if (id.value == '') {
            alert('아이디를 입력하세요')
            id.focus()
            isValid = false 

        }else if(myform.id.value.length == 0){
            alert("아이디가 누락됐습니다.");
            myform.id.focus()
            isValid = false

        }else if (password.value == '') {
            alert('패스워드를 입력하세요')
            password.focus()
            isValid = false 

        }else if(regex.test(password.value)){
            alert('패스워드에 기호나 숫자가 포함되어 있지 않습니다.')
            password.focus()
            isValid = false
            
        }else if (age.value == '') {
            alert('나이를 입력하세요')
            age.focus()
            isValid = false 
        } else if (age.value < 20 || age.value > 100) {
            alert('나이 유효값이 아닙니다.')
            age.focus()
            isValid = false 
        }
        

            document.forms[0].submit();
        })