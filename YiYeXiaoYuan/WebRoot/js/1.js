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
console.log('1');
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
//			var $goTop = $('.scroller').css('transform').replace(/[^0-9\-,]/g,'').split(',');
			$('#goTop').on('tap click', function() {
				$('.scroller').css('transform', 'matrix(1, 0, 0, 1, 0, -40)');
			});

