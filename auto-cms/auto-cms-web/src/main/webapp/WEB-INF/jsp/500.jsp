<%@ page contentType="text/html; charset=utf-8" isErrorPage="true"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<fmt:setLocale value="zh_CN"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
<title>500</title>
</head>
<body>
<center style="margin:50px auto">
	<p>error code：500<%//=request.getAttribute("javax.servlet.error.status_code")%></p>
	<p>Something wrong with this page！</p>
	<p>cause：${error.message}</p>
	<p>error content：${error}</p>
	<p>redirect to <a href="${pageContext.request.contextPath}/">home page</a>！</p>
</center>
<%
/**
monitor IP address
String ip = request.getHeader(" x-forwarded-for");
if (ip == null || ip.length() == 0 || " unknown".equalsIgnoreCase(ip)) {
	ip = request.getHeader(" Proxy-Client-IP"); // get proxy ip
}
if (ip == null || ip.length() == 0 || " unknown".equalsIgnoreCase(ip)) {
	ip = request.getHeader(" WL-Proxy-Client-IP"); // get proxy ip
}
if (ip == null || ip.length() == 0 || " unknown".equalsIgnoreCase(ip)) {
	ip = request.getRemoteAddr(); // get real ip
}
//out.println(ip+"<br/><br/>Your address is：<br/><br/>");

Document doc = Jsoup.connect("http://ip.chinaz.com/?IP="+ip).timeout(9000).get();
Element e = doc.select("#status").first();
//out.println(e);
*/
%>
</body>
</html>