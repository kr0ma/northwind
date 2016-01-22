<%@ page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix="v" uri='http://vdab.be/tags'%>
<!doctype html>
<html lang='nl'>
<v:head title='Northwind'/>
<body>
	<header>
		<v:menu/>
		<h1>Northwind</h1>		
	</header>
	<c:if test="${not empty countries}">
		<ul>
			<c:forEach var="country" items= "${countries}">
				<c:url value='customers/bycountry.htm' var='url'>
					<c:param name='id' value='${country.id}' />
				</c:url>
				<li><a href="${url}">${country.name}</a></li>
			</c:forEach>
		</ul>
	</c:if>
</body>
</html>