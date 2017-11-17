/* 登录界面JS脚本程序 */

$(function(){
	//为登录按钮绑定单击事件
	$('#login').click(loginAction);
	$('#count').focus().blur(checkName);
	$('#password').blur(checkPassword);

    $('#regist_button').click(registAction);
    $('#regist_username').blur(checkRegistUsername);
    $('#regist_password').blur(checkRegistPassword);
    $('#final_password').blur(checkFinalPassword);
});
//登录按钮的动作
function loginAction(){
	console.log('login click!');
	//收集用户名和密码数据
	var name = $('#count').val();
	var password = $('#password').val();
	//验证用户名和密码
	var pass = checkName()+checkPassword();  
	if(pass!=2){
		return;
	}
	var paramter={'name':name, 
			'password':password};
	//发送Ajax请求
	$.ajax({
		url:'user/login.do',
		data:paramter,
		dataType:'json',
		type:'POST',
		success:function(result){
			//{state:0,data:, message}
			if(result.state==0){//SUCCESS
				console.log("SUCCESS");
				console.log(result.data);
				window.location.href='edit.html';
				return;
			}else if(result.state==2){
				//用户名错误
				$('#count-msg').html(result.message);
				return;
			}else if(result.state==3){
				//密码错误
				$('#password-msg').html(result.message);
				return;
			}
			alert(result.message);
		},
		error:function(){
			alert('Ajax请求失败');
		}
	});
	
}

function checkName(){
	var name = $('#count').val();
	if(name==null || name==""){
		//提示错误
		$('#count-msg').html('不能空');
		return false;
	}
	var reg = /^\w{3,10}$/;
	if(! reg.test(name)){
		$('#count-msg').html('长度不对');
		return false;
	}
	$('#count-msg').empty();
	return true;
} 

function checkPassword(){
	var password = $('#password').val();
	if(password==null || password==""){
		//提示错误
		$('#password-msg').html('不能空');
		return false;
	}
	var reg = /^\w{3,10}$/;
	if(! reg.test(password)){
		$('#password-msg').html('长度不对');
		return false;
	}
	$('#password-msg').empty();
	return true;
}




function registAction(){
    console.log("registAction");
    var pass=checkRegistUsername()+
        checkRegistPassword()+
        checkFinalPassword();
    console.log('pass'+pass);
    if(pass!=3){
        //测试///
        return;
    }
    var url="user/regist.do";
    var name=$('#regist_username').val();
    var nick=$('#nickname').val();
    var pwd=$('#regist_password').val();
    var confirm=$('#final_password').val();
    //向服务器发送
    var data={name:name, nick:nick,
        password:pwd, confirm:confirm};
    console.log("url:"+url);
    console.log("data:"+data);
    $.post(url, data, function(result){
        if(result.state==0){
            var user=result.data;
            console.log(user);
            $('#back').click();
            $('#count').val(user.name);
            $('#password').focus();
        }else if(result.state==2){
            $('#warning_1 span')
                .html(result.message)
                .parent().show();
        }else if(result.state==3){
            $('#warning_2 span')
                .html(result.message)
                .parent().show();
        }else{
            alert(result.message);
        }
    });
}

function checkRegistUsername(){
    console.log("checkRegistUsername");
    var name=$('#regist_username').val();
    var reg = /^\w{3,10}$/;
    if(! reg.test(name)){
        $('#warning_1 span')
            .html("不合规则")
            .parent().show();
        return false;
    }
    $('#warning_1').hide();
    return true;
}
function checkRegistPassword(){
    console.log('checkRegistPassword');
    var pwd = $('#regist_password').val();
    var reg = /^\w{3,10}$/;
    if(! reg.test(pwd)){
        $('#warning_2 span').html('不合规则')
            .parent().show();
        return false;
    }
    $('#warning_2').hide();
    return true;
}
function checkFinalPassword(){
    console.log("checkFinalPassword");
    var confirm = $('#final_password').val();
    var pwd = $('#regist_password').val();
    if(confirm != pwd){
        $('#warning_3 span').html('不一致')
            .parent().show();
        return false;
    }
    $('#warning_3').hide();
    return true;
}












































