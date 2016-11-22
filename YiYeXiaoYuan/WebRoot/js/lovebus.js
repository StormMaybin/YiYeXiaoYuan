$(function(){
		$('#love-sub').on('tap click',function(ev){
		ev.preventDefault();
		var radio1=	$('input:radio[name="where"]:checked').val();
		var radio2=	$('input:radio[name="date"]:checked').val();
		var radio3=	$('input:radio[name="time"]:checked').val();
		var mes1=$('#love-sushe').val();
		var mes2=$('#love-name').val();
		var reg=/^.{0,4}$/;
		var usr_id=window.sessionStorage.getItem('usr_id');
			if(usr_id==null){											//判断登陆
				$('#dialog-login').fadeIn(300);
		        setTimeout(function () {	
		            window.location.href='login.html'
		        },1500);	
					        
			}else if(radio1==null||radio2==null||radio3==null||reg.test(mes1)==true||mes2==null){			//radio判断
				$('#dialog-radio').fadeIn(300);
					setTimeout(function () {
			     		$('#dialog-radio').fadeOut(300);
					},2000);

								
			}else{

				$('#dialog-confirm').fadeIn(300);
				$(".dialog-btn a:eq(0)").on('click tap',function () {
					$.ajax({
						method:'post',
						url:'',
						data:{
							'love-end':radio1,
							'love-date':radio2,
							'love-time':radio3,
							'love-name':mes2,
							'love-sushe':mes1
						},
						dataType:'json',									
					        success: function (data) {
					            //
					        },
					        error: function (jqXHR) {
					            // alert('wrong' + jqXHR.status + jqXHR.readyState);
//					               alert('发布成功！（模拟）');
					        }
					});//发送表单数据至后台
					$("#dialog-confirm").css("display", "none");
					$('#dialog-success').fadeIn(300);
						setTimeout(function () {
							$('#dialog-success').fadeOut(300);
							window.location.href='myRoute.html';
						},500);
							});
				$("#dialog-confirm a:eq(1)").on('click tap',function () {
					$(".one-dialog").css("display", "none");
				});
			}
						
		});//判断
})