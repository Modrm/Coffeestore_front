<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<html>
<head>
	<title>咖啡店</title>
	<link href="css/bookstore.css" rel="stylesheet" type="text/css"/>
</head>
<body>
	<ul class=point02>
		<li>
			<strong>咖啡分类</strong>
		</li>
		<s:iterator value="#request['catalogs']" var="catalog">
			<li>
				<a href="browseCoffeePaging.action?currentPage=1&&catalogid=<s:property value="#catalog.catalogid"/>" target=_self>
					<s:property value="#catalog.catalogname"/>
				</a>
			</li>
		</s:iterator>
	</ul>
</body>
</html>