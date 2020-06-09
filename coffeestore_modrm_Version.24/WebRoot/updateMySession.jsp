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
						<h1>个人信息修改页面</h1>
						<s:if test="#session.user.username != null">
							<h1>
								现在的用户名是:
								<s:property value='#session.user.username' />
								
							</h1>
							<form action="updateMySession.action" method="post">
								<table   id="tb" cellSpacing="2" cellPadding="5" width="95%" align="center" border="0">
									<input type="hidden"
										value="<s:property value='#session.user.userid' />"
										name="userid">

									<tr>
										<td bgcolor="rgb(238,238,238)" align="center" width="50%">密码*</td>
										<td bgcolor="rgb(238,238,238)" align="center" width="50%"><input type="text"
											value="<s:property value='#session.user.password' />"
											name="password"></td>
									</tr>
									<tr>
										<td bgcolor="rgb(238,238,238)" align="center" width="10%">性别*</td>
										<td bgcolor="rgb(238,238,238)" align="center" width="50%"><input type="text"
											value="<s:property value='#session.user.sex' />" name="sex"></td>
									</tr>
									<tr>
										<td bgcolor="rgb(238,238,238)" align="center" width="50%">年龄*</td>
										<td bgcolor="rgb(238,238,238)" align="center" width="50%"><input type="text"
											value="<s:property value='#session.user.age' />" name="age"></td>
									</tr>
									<tr>
										<td bgcolor="rgb(238,238,238)" align="center" width="50%">邮箱*</td>
										<td bgcolor="rgb(238,238,238)" align="center" width="50%"><input type="text"
											value="<s:property value='#session.user.email' />"
											name="email"></td>
									</tr>
									<tr>
										<td align="right" width="100%"><input type="submit" value="提交" /> <input
											type="reset" value="重置" /></td>
									</tr>
								</table>
							</form>
						</s:if>
						<s:else>
							对不起，你还没有登录！
						</s:else>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="foot.jsp"/>
</body>
</html>
