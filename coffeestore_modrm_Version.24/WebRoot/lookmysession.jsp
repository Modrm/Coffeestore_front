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
	<jsp:include page="head.jsp" />
	<div class="content">
		<div class="left">
			<div class="list_box">
				<div class="list_bk">
					<s:action name="browseCatalog" executeResult="true" />
				</div>
			</div>
		</div>
		<div class="right">
			<div class="right_box">
				<font face="宋体"></font><font face="宋体"></font><font face="宋体"></font><font
					face="宋体"></font>
				<div class="banner"></div>
				<div class="info_bk1">
				<div align="center">
					<h1>个人信息页面</h1>
					<s:if test="#session.user.username != null">
						<table  id="tb" cellSpacing="2" cellPadding="5" width="95%" align="center" border="0">
							<tr>
								<td bgcolor="rgb(238,238,238)" align="center" width="25%">用户名</td>
								<td bgcolor="rgb(238,238,238)" align="center" width="25%">性别</td>
								<td bgcolor="rgb(238,238,238)" align="center" width="25%">年龄</td>
								<td bgcolor="rgb(238,238,238)" align="center" width="25%">邮箱</td>
							</tr>
							<tr>
								<td><s:property value='#session.user.username' /></td>
								<td><s:property value='#session.user.sex' /></td>
								<td><s:property value='#session.user.age' /></td>
								<td><s:property value='#session.user.email' /></td>
							</tr>	
						</table>
					</s:if>
					<s:else>
						对不起，你还没有登录！
					</s:else>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="foot.jsp" />
</body>
</html>
