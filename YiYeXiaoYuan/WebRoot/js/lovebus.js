$(function(){
		$('#love-sub').on('tap click',function(ev){
		ev.preventDefault();
//		var usr_id=window.sessionStorage.getItem('usr_id');
		var n 
		var radio1=	$('input:radio[name="where"]:checked').val();
		var radio2=	$('input:radio[name="date"]:checked').val();
		var radio3=	$('input:radio[name="time"]:checked').val();
		var mes1=$('#love-sushe').val();
		var mes2=$('#love-name').val();
		var reg=/^.{0,8}$/;
		var usr_id=window.sessionStorage.getItem('userId');
		alert(radio2,radio3,mes1,mes2,usr_id);
		alert(radio3,mes1,mes2,usr_id)
		alert(mes1,mes2,usr_id)
		alert(mes2,usr_id)
		alert(usr_id)
			if(usr_id==null){											//判断登陆
				$('#dialog-login').fadeIn(300);
		        setTimeout(function () {	
		            window.location.href='login.html'
		        },1500);	
					        
			}else if(radio1==null||radio2==null||radio3==null||mes1==null||mes2==null){			//radio判断
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
							'arrive':radio1,
							'startDate':radio2,
							'startTime':radio3,
							'name':mes2,
							'address':mes1,
							'amount':num1,
							'moible':usr_id
						},
						dataType:'json',									
					        success: function (data) {
					            $("#dialog-confirm").css("display", "none");
								$('#dialog-success').fadeIn(300);
									setTimeout(function () {
										$('#dialog-success').fadeOut(300);
										window.location.href='myRoute.html';
									},500);
							$("#dialog-confirm a:eq(1)").on('click tap',function () {
								$(".one-dialog").css("display", "none");
							});
					        },
					        error: function (jqXHR) {
					            // alert('wrong' + jqXHR.status + jqXHR.readyState);
//					               alert('发布成功！（模拟）');
					        }
					});//发送表单数据至后台						
		});//判断
		}
	});
	$('.love-where label').click(function(){
	    var radioId = $(this).attr('name');
	    $('.love-where label').removeAttr('class') && $(this).attr('class', 'checked');
	    $('.love-where input[type="radio"]').removeAttr('checked') && $('#' + radioId).attr('checked', 'checked');
  	});//radio
  	$('.love-date label').click(function(){
	    var radioId = $(this).attr('name');
	    $('.love-date label').removeAttr('class') && $(this).attr('class', 'checked');
	    $('.love-date input[type="radio"]').removeAttr('checked') && $('#' + radioId).attr('checked', 'checked');
  	});//radio
  	$('.love-time label').click(function(){
	    var radioId = $(this).attr('name');
	    $('.love-time label').removeAttr('class') && $(this).attr('class', 'checked');
	    $('.love-time input[type="radio"]').removeAttr('checked') && $('#' + radioId).attr('checked', 'checked');
  	});//radio
  	
  	$('#jia').on('click tap',function(){
  		var $numb1=parseInt($('#numb1').val());
  		if($numb1<10){
  			$numb1+=1;
  		}
  		
  		$('#numb1').val($numb1);
  	});
  	  	$('#jian').on('click tap',function(){
  		var $numb1=parseInt($('#numb1').val());
  		if($numb1>1){
  			$numb1+=-1;
  		}
  		
  		$('#numb1').val($numb1);
  	});
  	
  		$('.love-date input[type="radio"]').on('click tap',function(){
  			var val=$('input:radio[name="date"]:checked').val();
  			var val1='2017-1-13';
  			var val2='2017-1-16';
  			if(val==val1){
  				$('.love-time label').removeAttr('class');
  				$('.love-time label').css('display','none');
  				$('#label1').css('display','inline');
  				$('.love-time input[type="radio"]').removeAttr('checked');
  				$('.yingcang').css('display','none');
  				$('#xiugai').text('16:30');
  				$('#time1').val('16:30');
  				}
  			else if (val==val2){
  				$('.love-time label').removeAttr('class');
  				$('.love-time label').css('display','none');
  				$('#label1').css('display','inline');
  				$('.love-time input[type="radio"]').removeAttr('checked');
  				$('.yingcang').css('display','none');
 				$('#xiugai').text('7:00');
  				$('#time1').val('7:00');
  				 
  			}
  			else if(val!==val1||val!==val2){
  				$('.love-time label').addClass('yingcang');
  				$('.yingcang').css('display','inline');
  				$('#label1').css('display','inline')
 				$('#xiugai').text('6:00');
  				$('#time1').val('6:00');
  				
  			}
  		});
  	
})