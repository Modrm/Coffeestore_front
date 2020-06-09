<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<html>
<head>
	<title>咖啡店</title>
	<link href="css/coffeestore.css" rel="stylesheet" type="text/css"/>
</head>
<body>
	<jsp:include page="head.jsp"/>
	<div class="content">
		<div class="left">
			<div class="list_box">
				<div class="list_bk">
					<s:action name="browseCatalog" executeResult="true"/>
				</div>
			</div>
		</div>
		<div class="right">
			<div class="right_box">
				<font face="宋体"></font><font face="宋体"></font><font face="宋体"></font><font face="宋体"></font>
				<div class="banner"></div>
				<div class="info_bk1">
				<div align="center">
				<h1>更新头像页面</h1>
				<s:if test="#session.user.username != null">
					
					<h1>当前用户名是:<s:property value='#session.user.username' /></h1>
						<form action="updateMyHeadImg.action" method="post" name="form2" enctype="multipart/form-data">
							头&nbsp;&nbsp;&nbsp;&nbsp;像:<input type="file" name="headImg" />
							<br>
							<input type="hidden" value="<s:property value='#session.user.userid' />" name="userid">
							<br>
							<input type="submit" value="更新头像"/>
							&nbsp&nbsp&nbsp
  							<input type="reset" name="reset" value="重置">
						</form>
						</s:if>
						<s:else>
							对不起，你还没有登录！
						</s:else>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="foot.jsp"/>
</body>
</html>
