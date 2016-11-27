<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>s
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
		<meta name="viewport" content="width=device-width,initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
  		<title>一页校园</title>
   		<link href="css/bootstrap.min.css" rel="stylesheet"/>
		<link href="css/navbar.css" rel="stylesheet"/>
		<script src="js/jquery-2.1.0.js"></script>
		<script src="js/bootstrap.min.js"></script>
		<script src="js/myRoute.js"></script>
	</head>
	<body>
		<div class="navigation1">
			<a href="javascript:history.go(-1)"><span class="glyphicon glyphicon-chevron-left one-left"></span></a>
		</div>
		<div class="one-inner-2">
			<div class="peo-infor">
				<img class="infor-pic" src="img/usr1.png" />
				<input id="peo-user" type="text" value="<!-- 151XXXXXXXX -->${user.userName}" readonly/>
				<script>
					$('#peo-user').on('tap click',function () {
						window.location.href='inforChange.html';
					})
				</script>
				<a href="inforChange.html" class="btn" role='button'>></a>
			</div>
			<div class="peo-route">
				<a class="img-car" href="Mypinche.html"><img class="" src="img/car.svg" /></a>
				<p><a href="Mypinche.html">我的行程</a></p>
			</div>
		</div>
	</body>
</html>
