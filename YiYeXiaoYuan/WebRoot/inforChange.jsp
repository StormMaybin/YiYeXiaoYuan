<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
  		<title>一页校园</title>
   		<link href="css/bootstrap.min.css" rel="stylesheet"/>
		<link href="css/navbar.css" rel="stylesheet"/>
		<script src="js/jquery-2.1.0.js"></script>
		<script src="js/bootstrap.min.js"></script>	
	</head>
	<body>
		<div class="navigation1">
			<a href="javascript:history.go(-1)"><span class="glyphicon glyphicon-chevron-left one-left"></span></a>
		</div>
		<div class="one-inner-2">
			<div class="one-change">
				<div class="change-username">
					<img src="img/yonghu.svg"/>
					<span id="username">${user.userName }</span>
					<a href="setUsername.html" id="changed" class="change-right" >></a>
				</div>
				<div class="change-password">
					<img src="img/iconfontlock.svg"/>
					<span>修改登录密码</span>
					<a href="setPassword.html" class="change-right" >></a>
				</div>
				<div class="userTel">
					<img src="img/shouji.svg"/>
					<span>已绑定手机号</span>
					<span id="userTel" class="infor-rig" value="${user.mobile }"><!-- 153xxxxxxxx --></span>
				</div>
				<div class="change-QQ">
					<img src="img/QQ.svg"/>
					<span>用户QQ号</span>
					<span id="userQQ">拼车信息选填</span>
					<a href="setQQ.html" class="change-right" value="${user.qq }">></a>
				</div>	
			</div>
			<a id="left-login" class="btn btn-block" role="button">退出登录</a>
		</div>
		<div class="one-dialog" id="dialog-exit">
			<div class="dialog-inner">
				<span>退出成功</span>
				<span>正在转向首页...</span><br>
				<img src="img/loading.gif"/>
			</div>
		</div>
		<script src="js/myRoute.js"></script>
	</body>
</html>