<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Mobile Machine</title>
	</head>
	<body>
		<c:url value="/simplified" var="sampleUrl">
			<c:param name="url" value="http://tvtropes.org/pmwiki/pmwiki.php/VideoGame/DungeonKeeper" />
			<c:param name="page" value="0" />
		</c:url>
		<a href="${sampleUrl}">Test page</a>
	</body>
</html>
