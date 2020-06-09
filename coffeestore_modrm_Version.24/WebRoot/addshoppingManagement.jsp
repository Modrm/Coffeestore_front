<%@ page contentType="text/html;charset=gb2312"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<html>
<head>
<title>添加咖啡</title>
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
				<div class="info_bk1">
					<div align="center">
						<font color="blue"><h3>添加商品</h3></font><br />

					
						<form action="register.action" method="post" name="form1" enctype="multipart/form-data">
							用户名:<input type="text" id="name" name="user.username" size="20"/><br>
							密&nbsp;&nbsp;&nbsp;&nbsp;码:<input type="password" name="user.password" size="21"/><br>
							性&nbsp;&nbsp;&nbsp;&nbsp;别:<input type="text" name="user.sex" size="20"/><br>
							年&nbsp;&nbsp;&nbsp;&nbsp;龄:<input type="text" name="user.age" size="20"/><br>
							邮&nbsp;&nbsp;&nbsp;&nbsp;箱:<input type="text" name="user.email" size="20"/><br>
							头&nbsp;&nbsp;&nbsp;&nbsp;像:<input type="file" name="headImg"><br>
							<input type="submit" value="注册"/>
						</form>

						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="foot.jsp" />
</body>
</html>
