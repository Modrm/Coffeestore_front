<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<html>
<head>
<title>咖啡店</title>
<link href="css/coffeestore.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
		function dodel(){
			return window.confirm("确认购买？");
		}
	</script>
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
					<s:set var="user" value="#session.user" />
					<h1>你的用户名是:${user.username}</h1>
					<img src="upload/<s:property value='#session.user.headImg'/>"
						width="40px" height="40px">
						
					<!-- 	<h2 value='#user.username'>$session.user.username</h2> -->
					<s:set var="coffees" value="#request.coffees" />
					<s:set var="items" value="#session.cart.items" />
					<s:if test="#items.size != 0">
						<table cellSpacing="2" cellPadding="5" width="95%" align="center" border="0">
							<tr>
								<td bgcolor="rgb(238,238,238)" align="center" width="50%">咖啡名</td>
								<td bgcolor="rgb(238,238,238)" align="center" width="30%">数量</td>
								<td bgcolor="rgb(238,238,238)" align="center" width="20%">单价</td>
							</tr>
							<s:iterator value="#items">
								<tr>
									<td><s:property value="value.coffee.coffeename" /></td>
									<td><s:property value="value.quantity" /></td>
									<td><s:property value="value.coffee.price" />元</td>
								</tr>
							</s:iterator>
						</table>
					
							<h3>总价：<s:property value="#session.cart.totalPrice" />元</h3>
						<br>
						<form action="emptyCart.action" method="post">
							<input type="submit" value="结算" onclick='return dodel()'/>
						</form>
					</s:if>
					<s:else>
					对不起，你的购物车没有咖啡！
				</s:else>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="foot.jsp" />
</body>
</html>
