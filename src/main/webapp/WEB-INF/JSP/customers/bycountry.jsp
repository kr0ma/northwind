<%@ page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix="v" uri='http://vdab.be/tags'%>
<!doctype html>
<html lang='nl'>
<v:head title='Northwind customers'/>
<style>
td {
	text-align: right;
}

td:nth-child(2) {
	text-align: left;
}
</style>
<body>
	<header>
		<v:menu/>
		<h1>Northwind Customers</h1>		
	</header>
	<c:if test="${not empty country}">
		<h2>${country.name}</h2>
		<table>
			<thead>
				<tr>
					<th>Name</th>
					<th>City</th>					
				</tr>
			</thead>
			<tbody>
				<c:forEach var="customer" items= "${country.customers}">	
						<tr>
							<td>${customer.name}</td>
							<td>${customer.address.city}</td>							
						</tr>					
				</c:forEach>
			</tbody>
		</table>
	</c:if>
</body>
</html>