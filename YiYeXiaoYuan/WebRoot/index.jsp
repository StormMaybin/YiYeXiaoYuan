<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="length" value="${fn:length(list)}" />
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<title>一页校园</title>
<link href="css/bootstrap.min.css" rel="stylesheet" />
<link href="css/navbar.css" rel="stylesheet" />
<link href="css/pullToRefresh.css" rel="stylesheet" />
<link href="http://cdn.amazeui.org/amazeui/2.7.2/css/amazeui.min.css"
	rel="stylesheet" />
<script src="js/jquery-2.1.0.js"></script>
<script src="js/iscroll.js"></script>
<script src="js/pullToRefresh.js"></script>
<script src="http://cdn.amazeui.org/amazeui/2.5.0/js/amazeui.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/1.js"></script>

<c:if test="${list == null }">
	<jsp:forward page="servlet/IndexServlet"></jsp:forward>
</c:if>
<script type="text/javascript">
	var length = "${fn:length(list)}";
	//alert(length);
</script>
</head>
<body>
	<div class="navigation1">
		<span class="glyphicon glyphicon-user" id="user1"></span>
	</div>
	<div class="one-inner">

		<div class="one-faqi">
			<a href="newCar.html" role="button" class="btn btn-block">发起新的拼车</a>
		</div>
		<div class="one-datechoose">
			<label class="one-choose" for="rili-date"><span
				class="glyphicon glyphicon-chevron-right"></span> </label> <input
				type="text" class="one-date" id="rili-date" onchange="fresh_page()"
				readonly />
		</div>

		<c:forEach items="${list}" var="li">
			<div id="wrapper">
				<ul class="list-unstyled">
					<li>
						<div class="one-information">
							<div class="information-time">
								<span>时间:</span> <span class="time-date startDate"> <!-- 2016-10-21 -->${li.startDate}</span>
								<span class="time-time startTime"> <c:choose>
										<c:when test="${li.startTime_min_hour < 10 }">0${li.startTime_min_hour }:</c:when>
										<c:when test="${li.startTime_min_hour >= 10 }">${li.startTime_min_hour }:</c:when>
									</c:choose> <c:choose>
										<c:when test="${li.startTime_min_min < 10 }">0${li.startTime_min_min }-</c:when>
										<c:when test="${li.startTime_min_min >= 10 }">${li.startTime_min_min }-</c:when>
									</c:choose> <c:choose>
										<c:when test="${li.startTime_max_hour < 10 }">0${li.startTime_max_hour }:</c:when>
										<c:when test="${li.startTime_max_hour >= 10 }">${li.startTime_max_hour }:</c:when>
									</c:choose> <c:choose>
										<c:when test="${li.startTime_max_min < 10 }">0${li.startTime_max_min }</c:when>
										<c:when test="${li.startTime_max_min >= 10 }">${li.startTime_max_min }</c:when>
									</c:choose> </span>
							</div>
							<div class="information-where">
								<span>出发: <span class="where-start startPos">${li.startPos
										}</span> </span> <span class="where-end">到达:</span> <span
									class="where-finish arrivePos">${li.arrivePos }</span>
							</div>
							<div class="information-people">
								<span class="glyphicon glyphicon-user people-applied"></span> <span
									class="glyphicon glyphicon-user"></span> <span
									class="glyphicon glyphicon-user"></span> <span
									class="glyphicon glyphicon-user"></span> <span
									class="glyphicon glyphicon-user"></span> <span
									class="people-number">上限
									<p class="maxMember" style="display: inline;">${li.maxMember
										}</p>人，已有
									<p class="curtMember" style="display: inline;">${li.curtMember
										}</p>人</span>
							</div>
							<div class="information-remark">
								<span>备注:</span> <span class="remark-content message">${li.message
									}</span>
							</div>
							<div class="information-issue">
								发布于<span class="issue-date pubtime">${li.pubTime }</span>
							</div>
							<div class="information-button">
								<button href="#" role=button
									class="issue-btn btn btn-block sign-btn">报名</button>
							</div>
						</div> <!--拼车数据1-->
					</li>
				</ul>
			</div>
		</c:forEach>
		<div class="one-dialog" id="dialog-confirm">
			<div class="dialog-inner">
				<span>确定报名？</span>
			</div>
			<div class="dialog-btn btn-group">
				<a class="btn" role="button">是</a> <a class="btn" role="button">否</a>
			</div>
		</div>
		<!--弹窗 是否确认报名-->
		<div class="one-dialog" id="dialog-login">
			<p>请先登录您的账号</p>
			<p>正在跳转至登录界面</p>
			<img src="img/loading.gif" />
		</div>
		<!--未登录弹窗-->
		<div class="one-dialog" id="dialog-success">
			<div class="dialog-inner">
				<span>报名成功。</span> <span>在我的行程查看拼车信息</span><br> <img
					src="img/loading.gif" />
			</div>
		</div>
		<!--弹窗报名成功-->
		<div class="one-dialog" id="dialog-error">
			<div class="dialog-inner">
				<span>开始新的拼车前请取消已有拼车</span>
			</div>
		</div>
		<!--弹窗报名之前请取消已有报名-->
		<div class="one-dialog" id="dialog-error2">
			<div class="dialog-inner">
				<span>没有更多拼车数据了</span>
			</div>
		</div>
		<!--没有更多数据-->
		<div id="dialog-love">
			<span>取消</span> <span>进入</span>
		</div>
	</div>
	<script>
		var ticker = 0;//计算完整循环复制次数
		var ticker2 = 0;//阻止多次刷新
		refresher.init({
			id : "wrapper",//<------------------------------------------------------------------------------------┐
			pullDownAction : Refresh,
			pullUpAction : Load

		});
		function Refresh() {
			setTimeout(function() { // <-- Simulate network congestion, remove setTimeout from production!
				//上拉刷新
				$.ajax({
					type : 'get',
					url : 'servlet/IndexServlet',
					data : {
						'status' : '1'
					},
					success : function() {
						window.location.reload();
						return true;
					},
					error : function() {
						console.log('net wrong');
					}
				});
				wrapper.refresh();
				/****remember to refresh after  action completed！ ---yourId.refresh(); ----| ****/

			}, 1000);

		}

		function Load() {
			setTimeout(function() {// <-- Simulate network congestion, remove setTimeout from production!
				//上拉加载更多数据
				//函数写这里
				for ( var i = 0; i <= 9; i++) {
					if (ticker * 10 + i + 4 > length || ticker2 == 1) {
						//没有更多数据
						$('#dialog-error2').fadeIn(300);
						setTimeout(function() {
							$('#dialog-error2').fadeOut(300);
						}, 2000);
						ticker2 = 1;
						wrapper.refresh();
						return false;
					} else {
						$('.list-unstyled').append(
								$('.list-unstyled>li:eq(0)').clone(true));
					}
				}
				ticker += 1;
				wrapper.refresh();
				/****remember to refresh after action completed！！！   ---id.refresh(); --- ****/

			}, 0);
		}
	</script>
</body>
</html>