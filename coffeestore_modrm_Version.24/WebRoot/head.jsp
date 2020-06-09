<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<html>
<head>
<title>咖啡店</title>
<link href="css/coffeestore.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="head">
		<div class="head_left">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#">  
				<s:if test="#session.user == null || #session.user.headImg == null">
    				<img src="picture/logo.jpg" width="100px" height="60px">
 				</s:if>
				<s:if test="#session.user.headImg != null && #session.user.headImg !='' ">
    				<img src="upload/<s:property value='#session.user.headImg'/>"  width="100px" height="60px">
 				</s:if>
			</a> <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;咖啡店提供专业服务
		</div>
		<div class="head_right">
			<div class="head_right_nei">
				<div class="head_top">
					<div class="head_buy">
						<strong> <a href="showCart.jsp"> <img
								height="15" src="picture/buy01.jpg" width="16">&nbsp;购物车
						</a>
						</strong> | <a href="#">用户FAQ</a>
					</div>
				</div>
				<div class="head_middle">
					<a class="title01" href="index.jsp"> <span>&nbsp;&nbsp;首页&nbsp;&nbsp;</span>
					</a>
					<s:if test="#session.user==null">
						<a class="title01" href="login.jsp"> <span>&nbsp;&nbsp;登录&nbsp;&nbsp;</span>
						</a>
					</s:if>
					<s:else>
						<a class="title01" href="logout.action"> <span>&nbsp;&nbsp;注销&nbsp;&nbsp;</span>
						</a>
					</s:else>
					<a class="title01" href="register.jsp"> <span>&nbsp;&nbsp;注册&nbsp;&nbsp;</span>
					</a> <a class="title01" href="lookmysession.jsp"> <span>&nbsp;查看个人信息&nbsp;&nbsp;&nbsp;</span>
					</a> <a class="title01" href="updateMySession.jsp"> <span>&nbsp;修改个人信息&nbsp;&nbsp;&nbsp;</span>
					</a>
					<a class="title01" href="updateMyHeadImg.jsp"> <span>&nbsp;修改头像&nbsp;&nbsp;&nbsp;</span></a>
					<a class="title01" href="searchAllCoffee.action"> <span>&nbsp;管理模式&nbsp;&nbsp;&nbsp;</span></a>
				</div>
				<div class="head_bottom">
					<form action="searchCoffee.action" method="post">
						<input type="text" name="coffeename" size="50" align="middle" /> <input
							type="image" name="submit" src="picture/search02.jpg" align="top"
							style="width: 48px; height: 22px" />
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>