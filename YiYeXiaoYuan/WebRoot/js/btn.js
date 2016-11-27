
				// 报名按钮事件 yzy
			$('.issue-btn').on('click tap', function() {
				var that = $(this);
				$("#dialog-confirm").css("display", "block");// 弹窗提示
				$(".dialog-btn a:eq(0)").on('click tap', function() {
					$("#dialog-confirm").css("display", "none");
					var enlist_error = function() {
						$('#dialog-error').fadeIn(300);
						that.attr('disabled',true);
						setTimeout(function() {
							that.attr('disabled',false);
							$('#dialog-error').fadeOut(300);
						}, 500);
					};// 不合报名规则
					var enlist_success = function() {
						that.attr('disabled',true);
						$('#dialog-success').fadeIn(300);
						setTimeout(function() {
							that.attr('disabled',false);
							$('#dialog-success').fadeOut(300);
							window.location.href = 'myRoute.html';
						}, 2000);
					};// 报名成功提示

					// console.log(get_enlist_startTime()[2]);
					if (usr_id != null) {
						$.ajax({
							method : 'post',
							url : 'servlet/SignUpInformationServlet',
							data : {
							// usr_id
							// info_id
                                'uId': window.sessionStorage.getItem('userId'),
                                'iId':  that.find('#carId').html()
							},
							dataType : 'json',
							success : function(data) {
								// 返回状态码
								//	0 不满足报名规则
								//	1 报名成功
								//	-1 第二次点击同一个拼车信息
								if(data.status==1){//success
									enlist_success();
									that.css("background-color", "#000000");
									that.attr('disabled', true);
									that.html('已报名');
                                    setTimeout(function() {
                                    	that.attr('disabled',false);
                                    	window.location.href = 'myRoute.html';
                                    }, 2000);
								}
								if(data.status==0){//fail
                                    enlist_error();
								}
								if(data.status==-1){//已报名
                                    $('#dialog-error3').fadeIn(300);
                                    that.attr('disabled',true);
                                    setTimeout(function() {
                                    	that.attr('disabled',false);
                                        $('#dialog-error3').fadeOut(300);
                                    }, 500);
								}
							},
							error : function() {
								// console.log('net wrong -1');
								alert("net Wrong");

							}
						});
					} else {
						//引导至注册面
						//点击报名未登录
                        // console.log(that.find('#carId').html());
						$('#dialog-login').fadeIn(300);
						that.attr('disabled',true);
						setTimeout(function() {
							that.attr('disabled',false);
							location.href = 'login.html';
						}, 500)
					}

				});//选择报名

				$(".dialog-btn a:eq(1)").on('click tap', function() {
					$(".one-dialog").css("display", "none");
				});//放弃报名
			});
			
			
			
			