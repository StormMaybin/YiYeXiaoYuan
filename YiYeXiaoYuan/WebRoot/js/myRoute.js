/** * Created by p on 2016/11/15. */$(function () {    //拿值    var usr_id=window.sessionStorage.getItem('userName');    var usr_tel=window.sessionStorage.getItem('userTel');    var usr_qq=window.sessionStorage.getItem('userQQ');    var isChange=window.sessionStorage.getItem('isChange');    //    alert(usr_id+','+usr_tel+','+usr_qq);    //填值    $('#peo-user').val(usr_id);    $('#username').html(usr_id);    $('#userTel').html(usr_tel);    if(isChange==1){    	$('#changed').css('display','none');    }    if(usr_qq!=null){        $('#userQQ').html(usr_qq);    }    $('#left-login').on('click tap',function (e) {        e.preventDefault();        var that=$(this);        window.sessionStorage.clear();        $('#dialog-exit').fadeIn(300);        that.attr('disabled','disabled');        setTimeout(function () {            $('#dialog-exit').fadeOut(300);            that.attr('disabled',false);            window.location.href='index.html';        },500);    });//清除session  并退出登录    $('#userQQ').on('tap click',function () {        window.location.href='setQQ.html';    });    //修改登录密码js  //修改登录密码js  //修改登录密码js    $('#login-get').on('tap click',function (e) {        e.preventDefault();        var that=$(this);        var $set_password1=$('#set_password1').val();        var $set_password2=$('#set_password2').val();        //先判断两个的长度 然后判断两个是否相等        if(($set_password1.length<6||$set_password1.length>16)||($set_password2.length<6||$set_password2.length>16)){            $('#dialog-password_error1').fadeIn(300);            that.attr('disabled',true);            setTimeout(function () {                $('#dialog-password_error1').fadeOut(300);                that.attr('disabled',false);            },100);            return false;        }else{            if($set_password1!=$set_password2){                $('#dialog-password_error2').fadeIn(300);                that.attr('disabled',true);                setTimeout(function () {                    $('#dialog-password_error2').fadeOut(300);                    that.attr('disabled',false);                },400);                return false;            }else{                $.ajax({                    type:'post',                    url:'servlet/RegisterServlet',                    dataType:'json',                    data:{                    	'type':window.sessionStorage.getItem('type'),                        'mobile':usr_tel,                        'passWord':$set_password1                    },                    success:function (data) {                        //0失败  1 成功                        if(data.type==1){                            if(data.status==0){                                $('#dialog-password_error3').fadeIn(300);                                that.attr('disabled',true);                                setTimeout(function () {                                	that.attr('disabled',false);                                    $('#dialog-password_error3').fadeOut(300);                                },1000);                                return false;                            }                            if(data.status==1){                                $('#dialog-password_success').fadeIn(300);                                that.attr('disabled',true);                                setTimeout(function () {                                	that.attr('disabled',false);                                    $('#dialog-password_success').fadeOut(300);                                    window.location.href='myRoute.html';                                },1000);                            }                        }//注册时设置密码                        if(data.type==2){                            $('#dialog-password_error4').fadeIn(300);                            that.attr('disabled',true);                            setTimeout(function () {                            	that.attr('disabled',false);                                $('#dialog-password_error4').fadeOut(300);                                window.history.go(-1);                            },1000);                            return false;                        }//注册后改变密码                        if(data.type==3){                            $('#dialog-password_error5').fadeIn(300);                            that.attr('disabled',true);                            setTimeout(function () {                            	that.attr('disabled',false);                                $('#dialog-password_error5').fadeOut(300);                                window.location.href='login.html';                            },1000);                            return false;                        }//重置密码                    },                    error:function () {                        alert('net wrong');                    }                });            }        }    });    //设置用户名    //setUsername    $('#user-name').on('click tap',function(e){        e.preventDefault();        var that=$(this);        var $userName=$('#input-name').val();        var regUser1=/[a-zA-Z]{4,16}/;        var regUser2=/[\u4e00-\u9fa5]{2,8}/;        if(regUser1.test($userName)==true||regUser2.test($userName)==true){            $.ajax({                type:'post',                url:'servlet/updateUserNameServlet',                data:{                    'mobile':usr_tel,                    'userName':$userName                    //发送原id 和改过的id                },                dataType:'json',                success:function (data) {                    if(data.status==1){                        $('#set_rsp_txt').html('修改成功！');                        $('#set_rsp').slideDown(300);                        window.sessionStorage.setItem('userName',$userName);                        window.sessionStorage.setItem('isChange',1);                        that.attr('disabled',true);                        setTimeout(function () {                        	that.attr('disabled',false);                            $('#set_rsp').slideUp(300);                            history.go(-1);                        },500);                    }                    if(data.status==0){                        $('#set_rsp_txt').html('用户名已被他人使用！');                        $('#set_rsp').slideDown(300);                        that.attr('disabled',true);                        setTimeout(function () {                        	that.attr('disabled',false);                            $('#set_rsp').slideUp(300);                        },1000);                    }                },                error:function () {                    alert('net wrong'+XHR.readyState+XHR.status);                }            });        }else{            $('#set_rsp_txt').html('用户名格式不对');            $('#set_rsp').slideDown(300);            that.attr('disabled',true);            setTimeout(function () {            	that.attr('disabled',false);                $('#set_rsp').slideUp(300);            },3000);        }    });    //set qq    $('#set_qq').on('tap click',function (e) {        e.preventDefault();        var that=$(this);        var $set_qq=$('#input-QQ').val();        if ($set_qq==''){            $('#setqq_rsp_txt').html('QQ不能为空！');            $('#setqq_rsp').slideDown(300);            that.attr('disabled',true);            setTimeout(function () {            	that.attr('disabled',false);                $('#setqq_rsp').slideUp(300);            },1000);            return false;        }        $.ajax({            type:'post',            url:'servlet/SetQQServlet',            data:{                'qq':$set_qq,                'mobile':usr_tel            },            dataType:'json',            success:function (data) {                if(data.status==1){                	that.attr('disabled',true);                    window.sessionStorage.setItem('userQQ',$set_qq);                    $('#setqq_rsp_txt').html('设置成功');                    $('#setqq_rsp').slideDown(300);                    setTimeout(function () {                    	that.attr('disabled',false);                        history.go(-1);                        $('#setqq_rsp').slideUp(300);                    },500);                }                if(data.status==0){                	that.attr('disabled',true);                    $('#setqq_rsp_txt').html('设置失败');                    $('#setqq_rsp').slideDown(300);                    setTimeout(function () {                    	that.attr('disabled',false);                        $('#setqq_rsp').slideUp(300);                    },2000);                    return false;                }            },            error:function (XHR) {                alert('net wrong');            }        });    })});