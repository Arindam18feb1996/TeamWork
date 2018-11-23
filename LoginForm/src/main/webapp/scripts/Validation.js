	function validate(){
	var flag=false;
	var uname = f1.userName.value;
	var upwd  = f1.userPwd.value;
	if(uname==""||uname==null){
	document.getElementById('userErrMsg').innerHTML="*Please enter a Name"
	flag=false;
	}else if(userpasswd==""||userpasswd==null){
		document.getElementById('pwdErrMsg').innerHTML="*Please enter a Password"
			flag=false;
	}else{
	flag=true;
	}return flag;
	}