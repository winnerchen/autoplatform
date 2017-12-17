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
<title>add user</title>
</head>
<body>
<div class="breadcrumb">
	<span class="crust"><a href="${basePath}/" class="crumb">Home</a><span class="arrow"><span>&gt;</span></span></span>
	<span class="crust"><a href="${basePath}/user" class="crumb">User manage</a><span class="arrow"><span>&gt;</span></span></span>
	<span class="crust"><a href="" class="crumb">Add user</a><span class="arrow"><span>&gt;</span></span></span>
</div>
<div id="main">
	<form id="form" method="post">
	<table border="1">
		<caption>Add user</caption>
		<tr><td>Username：<font color="#cc0000">*</font></td><td><input id="username" type="text" name="username" placeholder="Required" required="true" maxlength="20" autofocus value=""/></td></tr>
		<tr><td>Password：<font color="#cc0000">*</font></td><td><input id="password" type="password" name="password" placeholder="Required" required="true" maxlength="20" value=""/></td></tr>
		<tr><td>Nickname：<font color="#cc0000">*</font></td><td><input id="nickname" type="text" name="nickname" placeholder="Required" required="true" maxlength="20" value=""/></td></tr>
		<tr>
			<td>Gender：</td>
			<td>
				<select id="sex" name="sex">
					<option value="0">-Select-</option>
					<option value="1">Male</option>
					<option value="2">Female</option>
				</select>
			</td>
		</tr>
		<tr><td></td><td><a href="${basePath}/user">Cancle</a>　<input type="submit" value="Save"/></td></tr>
	</table>
	</form>
	<form id="form2" action="${basePath}/user/upload" method="post" enctype="multipart/form-data">
	<table border="1">
		<caption>Modify avatar</caption>
		<tr><td>Avatar：</td><td><input id="file" type="file" name="file"/></td></tr>
		</tr>
		<tr><td></td><td><input type="submit" value="Upload"/></td></tr>
	</table>
	</form>
</div>
<form:errors path="*" cssStyle="color:red"></form:errors>
<form:errors path="username" cssClass="errorClass"></form:errors>
</body>
</html>