<%@ page contentType="text/html;charset=gb2312"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<html>
<head>
<title>管理咖啡</title>
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
					<div align="right"><h4><a href="addshoppingManagement.jsp">添加商品</a></h4></div>
					<div align="center">
						<font color="blue"><h3>咖啡列表</h3></font><br/>
						
						<table id="tb" cellSpacing="2" cellPadding="5" width="100%"
							align="center" border="0">
							<tr>
								<td bgcolor="rgb(238,238,238)" align="center" width="50%"
									height="12">图片</td>
								<td bgcolor="rgb(238,238,238)" align="center" width="15%">咖啡名</td>
								<%--                            <td bgcolor="#666666" align="center" width="15%">数 量</td>--%>
								<td bgcolor="rgb(238,238,238)" align="center" width="15%"><font
									color="gray">定 价</font></td>
								<td bgcolor="rgb(238,238,238)" align="center" width="20%"><font
									color="gray">操作</font></td>

							</tr>
							<%-- <s:set var="allshopping" value="#request.allCoffees" /> --%>
							<%-- <s:iterator value="#request.allCoffees" var="var"> --%>
							<s:iterator value="#request['allCoffees']" var="allCoffees">
								<tr>
									<td><img
										src="picture/<s:property value="#allCoffees.picture"/>"
										width="100"></td>
									<td><s:property value="#allCoffees.coffeename" /></td>
									<td><s:property value="#allCoffees.price" /></td>
									<td><span><a
											href="<!-- modify.action?bookid=<s:property value='value.book.bookid'/> -->">修改</a></span>
										<span><a
											href="<!-- mod.action?bookid=<s:property value='value.book.bookid'/> -->">删除</a></span>
									</td>
								</tr>
							</s:iterator>

						</table>
						<hr />
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<s:set value="#request.pager" var="pager" />
						<s:if test="#pager.hasFirst">
							<a href="searchAllCoffee.action?currentPage=1">首页</a>
						</s:if>
						<s:if test="#pager.hasPrevious">
							<a
								href="searchAllCoffee.action?currentPage=<s:property value="#pager.currentPage-1"/>">
								上一页 </a>
						</s:if>
						<s:if test="#pager.hasNext">
							<a
								href="searchAllCoffee.action?currentPage=<s:property value="#pager.currentPage+1"/>">
								下一页 </a>
						</s:if>
						<s:if test="#pager.hasLast">
							<a
								href="searchAllCoffee.action?currentPage=<s:property value="#pager.totalPage"/>">
								尾页 </a>
						</s:if>
						<br>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						当前第
						<s:property value="#pager.currentPage" />
						页，总共
						<s:property value="#pager.totalPage" />
						页
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="foot.jsp" />
</body>
</html>
