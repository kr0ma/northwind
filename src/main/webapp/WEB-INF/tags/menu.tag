<%@ tag language="java" pageEncoding="UTF-8"%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<nav>
	<ul>
		<li><a href="<c:url value='/'/>">Home</a></li>	
		<li><a href="<c:url value='/customers/search.htm' />">Customers</a></li>
		<li><a href="<c:url value='/employees/changeboss.htm' />">Employees</a></li>	
	</ul>
</nav>
