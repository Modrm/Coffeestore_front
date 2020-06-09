<%@ page contentType="text/html;charset=gb2312" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<html>
<head>
	<title>购物车</title>
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
			<div class="info_bk1">
			<div align="center">
				<s:set var="items" value="#session.cart.items"/>
				<s:if test="#items.size != 0">
					<font color="blue"><h3>您购物车中的咖啡</h3></font><br/>
					     
							 <form action="updateCart.action" method="post"> 
							<table id="tb" cellSpacing="2" cellPadding="5" width="95%" align="center" border="0">
								<tr>
									<td bgcolor="rgb(238,238,238)" align="center" width="50%" height="12">咖啡名</td>
									<td bgcolor="rgb(238,238,238)" align="center" width="15%" >定 价</td>
									<td bgcolor="rgb(238,238,238)" align="center" width="15%">数 量</td>
									<td bgcolor="rgb(238,238,238)" align="center" width="20%">
										<font color="gray">操 作</font>
									</td>
								</tr>
							
								<s:iterator value="#items">
									<tr>
										<td>
											<s:property value="value.coffee.coffeename"/>
										</td>
										<td>
											<s:property value="value.coffee.price"/>
										</td>
										<td>
											<input type="text" name="quantity" value="<s:property value="value.quantity"/>" size="4"/>
											<input type="hidden" name="coffeeid" value="<s:property value="value.coffee.coffeeid"/>"/>
										</td>
										<td>
											 <input type="submit" value="更新"/>
										</td>
									</tr>
								</s:iterator>
							</table>
							
									<!-- <a href="settlementCenter.jsp"><img src="picture/count.gif"/></a> -->
							</form>
						<hr/>
				
						消费金额:<s:property value="#session.cart.totalPrice"/>元&nbsp;&nbsp;&nbsp;
						<form action="goCart.action" method="post"> 
						<input type="submit" value="结算"/>
						</form>
				</s:if>
				<s:else>
					对不起，您还没有选购咖啡！
				</s:else>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="foot.jsp"/>
</body>
</html>
