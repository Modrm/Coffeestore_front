<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
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
				<s:set var="coffees" value="#request.coffees"/>
				<s:if test="#coffees.size!=0">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<font color="blue"><h3>所有符合条件的咖啡</h3></font><br>
					<s:iterator value="#coffees" var="coffee">
						<table width="600" border="0">
							<tr>
								<td width="200" align="center">
									<img src="picture/<s:property value="#coffee.picture"/>" width="100">
								</td>
								<td valign="top" width="400">
									<table>
										<tr>
											<td>
												咖啡名:<s:property value="#coffee.coffeename"/><br>
											</td>
										</tr>
										<tr>
											<td>
												价格:<s:property value="#coffee.price"/>元
												&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
												&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
												&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
												<form action="addToCart.action" method="post">
												数量:
												<input type="text" name="quantity" value="0" size="4"/>
												<input type="hidden" name="coffeeid" value="<s:property value="#coffee.coffeeid"/>">
												<input type="image" name="submit" src="picture/buy.gif"/>
											</form>
											</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</s:iterator>
				</s:if>
				<s:else>
					对不起，没有找到你想要的咖啡！
				</s:else>
			</div>
		</div>
	</div>
	<jsp:include page="foot.jsp"/>
</body>
</html>
