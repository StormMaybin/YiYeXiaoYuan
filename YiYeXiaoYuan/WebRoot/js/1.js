//by yzy
console.log('x');
// 日历处理
function GetDateStr() {
    var dd = new Date();
    var y = dd.getFullYear();
    var m = dd.getMonth() + 1;
    if (m < 10) {
        m = '0' + m;
    }
    var d = dd.getDate();
    if (d < 10) {
        d = '0' + d;
    }
    return y + "-" + m + "-" + d;
}
var dateToday = GetDateStr();
$("#rili-date").attr("value", dateToday);// 今日日期

var nowTemp = new Date();
var nowDay = new Date(nowTemp.getFullYear(), nowTemp.getMonth(),
    nowTemp.getDate(), 0, 0, 0, 0).valueOf();
var nowAfterDay = nowDay + 31 * 2 * 24 * 60 * 60 * 1000;
// alert(nowTemp);
var nowMoth = new Date(nowTemp.getFullYear(), nowTemp.getMonth(),
    1, 0, 0, 0, 0).valueOf();
var nowYear = new Date(nowTemp.getFullYear(), 0, 1, 0, 0, 0, 0)
    .valueOf();
var $myStart2 = $('#rili-date');

var checkin = $myStart2.datepicker({
    theme : "danger",
    onRender : function(date, viewMode) {
        // 默认 days 视图，与当前日期比较
        var viewDate = nowDay;

        switch (viewMode) {
            // moths 视图，与当前月份比较
            case 1:
                viewDate = nowMoth;
                break;
            // years 视图，与当前年份比较
            case 2:
                viewDate = nowYear;
                break;
        }
        return date.valueOf() > nowAfterDay ? 'am-disabled' : ''
        || date.valueOf() < viewDate ? 'am-disabled' : '';

    }

});//date

			var usr_id = window.sessionStorage.getItem('userName');// 取id
			// 用户头像click
			$('#user1').on('tap click', function() {
				if (usr_id != null) {
					window.location.href = 'myRoute.html';
				} else {
					window.location.href = 'login.html';
				}
			});

			// sessionStorage.setItem("timer", true);
			// $("#rili-date").change(function() {
			// 			var $date = $('#rili-date').val();
			// 			$.ajax({
			// 				method:'post',
			// 				url:'servlet/PubTimeServlet',
			// 				dataType:'json',
			// 				data:{
			// 					'pubTime': $date
			// 				},
			// 				success:function(data){
			// 					var carData = data;
			// 					$('.list-unstyled').children('.child').remove();//remove function!!!!
			// 					for ( var i = 0; i < data.length; ++i) {
			// 						$('#dataUl')
			// 								.append(
			// 										'<li class="child"><div class="one-information"><div class="information-time"><span>时间:</span><span class="time-date startDate">'
			// 												+ carData[i].startDate
			// 												+ '</span><span class="time-time startTime">'
			// 												+ carData[i].startTime_min_hour
			// 												+ ':'
			// 												+ carData[i].startTime_min_min
			// 												+ '-'
			// 												+ carData[i].startTime_max_hour
			// 												+ ':'
			// 												+ carData[i].startTime_max_min
			// 												+ '</span></div><div class="information-where"><span>出发:<span class="where-start startPos">'
			// 												+ carData[i].startPos
			// 												+ '</span></span><span class="where-end">到达:</span><span class="where-finish arrivePos">'
			// 												+ carData[i].arrivePos
			// 												+ '</span></div><div class="information-people"><span class="glyphicon glyphicon-user people-applied"></span><span class="glyphicon glyphicon-user"></span><span class="glyphicon glyphicon-user"></span><span class="glyphicon glyphicon-user"></span><span class="glyphicon glyphicon-user"></span><span class="people-number">上限<p class="maxMember" style="display: inline;">'
			// 												+ carData[i].maxMember
			// 												+ '</p>人，已有<p class="curtMember"  style="display: inline;">'
			// 												+ carData[i].curtMember
			// 												+ '</p>人</span></div><div class="information-remark"><span>备注:</span><span class="remark-content message">'
			// 												+ carData[i].message
			// 												+ '</span></div><div class="information-issue">发布于<span class="issue-date pubtime">'
			// 												+ carData[i].pubTime
			// 												+ '</span></div><div class="information-button"><button href="#" role=button class="issue-btn btn btn-block sign-btn" id="">报名</button></div></div></li>');
			// 					}
			// 				},
			// 				error:function(){
			// 					alert("net wrong");
			// 				}
			//
			// 			});
			//
			//
			//
			//
			//
			// 			var $arr = [ '2017-01-13', '2017-01-14', '2017-01-15',
			// 					'2017-01-16' ];
			// 			var timer = sessionStorage.getItem('timer');
			// 			for ( var i = 0; i < $arr.length; ++i) {
			// 				if (($arr[i] == $date) && (timer == "true")) {
			// 					$('#dialog-love').fadeIn(300);
			// 					sessionStorage.setItem("timer", false)
			// 				}
			// 			}
			// 		});

			// 报名按钮事件 yzy
			$('.issue-btn').on('click tap', function() {
				var that = $(this);
				$("#dialog-confirm").css("display", "block");// 弹窗提示
				$(".dialog-btn a:eq(0)").on('click tap', function() {
					$("#dialog-confirm").css("display", "none");
					var enlist_error = function() {
						$('#dialog-error').fadeIn(300);
						setTimeout(function() {
							$('#dialog-error').fadeOut(300);
						}, 2000);
					};// 不合报名规则
					var enlist_success = function() {
						$('#dialog-success').fadeIn(300);
						setTimeout(function() {
							$('#dialog-success').fadeOut(300);
							window.location.href = 'myRoute.html';
						}, 2000);
					};// 报名成功提示

					// console.log(get_enlist_startTime()[2]);
					if (usr_id != null) {
						$.ajax({
							method : 'post',
							url : '',
							data : {
							// usr_id
							// info_id
                                'uid': window.sessionStorage.getItem('userId'),
                                'id':  that.find('#carId').html()
							},
							dataType : 'json',
							success : function(data) {
								// 返回状态码
								// 出发地点相同1出发地点不同0
								// 出发地点相同时间相差小于一天10
								// 出发地点相同时间相差大于一天11
								// 出发地点不同时间相差小于2小时00
								// 出发地点不同时间相差大于2小时01
								switch (data.status) {
								case '10':
									enlist_error();
									break;
								case '11':
									enlist_success();
									that.css("background-color", "#000000");
									that.attr('disabled', 'disabled');
									that.html('已报名');
									window.location.href = 'myRoute.html';
									break;
								case '00':
									enlist_error();
									break;
								case '01':
									enlist_success();
									console.log(sessionStorage);
									that.css("background-color", "#000000");
									that.attr('disabled', 'disabled');
									that.html('已报名');
									break;
								}
							},
							error : function() {
								// console.log('net wrong -1');
								enlist_success();
								that.css("background-color", "#000000");
								that.attr('disabled', 'disabled');
								that.html('已报名');

							}
						});
					} else {
						//引导至注册面
						//点击报名未登录
                        // console.log(that.find('#carId').html());
						$('#dialog-login').fadeIn(300);
						setTimeout(function() {
							location.href = 'login.html';
						}, 2000)
					}

				});//选择报名

				$(".dialog-btn a:eq(1)").on('click tap', function() {
					$(".one-dialog").css("display", "none");
				});//放弃报名
			});
			//选择日期之后的事件处理

			//真爱跳转
			$('#trueLove').on('click tap', function() {
				window.location.href = 'trueLove-bus.html'
			});

			$("#dialog-love span:eq(0)").on("tap click", function() {
				$("#dialog-love").css("display", "none");
			});
			$("#dialog-love span:eq(1)").on("tap click", function() {
				window.location.href = 'trueLove-bus.html';
			});

			//goTop
			var $goTop = $('.scroller').css('transform').replace(/[^0-9\-,]/g,
					'').split(',');
			$('#goTop').on('tap click', function() {
				$('.scroller').css('transform', 'matrix(1, 0, 0, 1, 0, -40)');
			});

