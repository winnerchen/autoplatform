<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set var="basePath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
<title><spring:message code="user.list"/>user list</title>
</head>
<body>
<div class="breadcrumb">
	<span class="crust"><a href="${basePath}/" class="crumb">Home</a><span class="arrow"><span>&gt;</span></span></span>
	<span class="crust"><a href="${basePath}/user" class="crumb">User manage</a><span class="arrow"><span>&gt;</span></span></span>
	<span class="crust"><a href="" class="crumb">Add user</a><span class="arrow"><span>&gt;</span></span></span>
</div>
<div id="main">
	<table id="datagrid" class="datagrid" border="1">
		<caption><i class="fa fa-list-ol"></i> user list <a href="${basePath}/user/add">add</a></caption>
		<thead>
			<tr>
				<th>ID</th>
				<th>username</th>
				<th>password</th>
				<th>nickname</th>
				<th>gender</th>
				<th>create time</th>
				<th>operation</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="user" items="${users}">
			<tr>
				<td>${user.id}</td>
				<td>${user.username}</td>
				<td>${user.password}</td>
				<td>${user.nickname}</td>
				<td>
					<c:if test="${user.sex==1}">male</c:if>
					<c:if test="${user.sex==2}">female</c:if>
				</td>
				<td>
					<%-- 
					<fmt:parseDate value="${user.ctime}" var="date" pattern="yyyyMMddHHmm"/> 
					<fmt:formatDate value="${date}" type="both" pattern="yyyy-MM-dd HH:mm:ss" timeZone="Asia/Shanghai"/>
					 --%>
					${user.ctime}
				</td>
				<td>
					<a href="${basePath}/book/list/${user.id}">book management</a>
					<a href="${basePath}/user/update/${user.id}">edit</a>
					<a href="${basePath}/user/delete/${user.id}" onclick="return confirm('confirm delete？');">delete</a>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="pages">${paginator.html}</div>
</div>
</body>
</html>