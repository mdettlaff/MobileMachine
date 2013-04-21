<%@page pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>${title}</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	</head>
	<body>
		${html}
		<hr>
<c:if test="${pageCount gt 1}">
		Page ${currentPage} of ${pageCount}<br>
</c:if>
<c:if test="${not empty nextPage}">
		<c:url value="/simplified" var="nextPageUrl">
			<c:param name="url" value="${url}" />
			<c:param name="page" value="${nextPage}" />
		</c:url>
		<a href="${nextPageUrl}">Next page</a><br>
</c:if>
		<a href="${url}">Original version of the page</a>
	</body>
</html>
