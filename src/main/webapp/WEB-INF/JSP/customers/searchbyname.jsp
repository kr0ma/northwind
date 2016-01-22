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
	<form>
		<label>Name</label>
			<div class="radioGroup">
			<label><input name="method"
				value="1" type="radio" ${param.method == "1" ? "checked" : "" }>Is
			</label>
			<label> <input name="method"
				value="2" type="radio" ${param.method == "2" ? "checked" : "" }>Contains
			</label>
			<label> <input name="method"
				value="3" type="radio" ${param.method == "3" ? "checked" : "" }>Starts with
				<span>${errors.method}</span>
			</label>
			</div>
			<label><input name='name'
			value='${param.name}' autofocus><span>${errors.name}</span></label>
		
		<input type='submit' value='Zoeken'>
	</form>
	<c:if test='${not empty param and empty errors and empty customers}'>
		Customer not found
	</c:if>
	<c:if test="${not empty customers}">		
		<table>
			<thead>
				<tr>
					<th>Id</th>	
					<th>Name</th>
					<th>Country</th>					
				</tr>
			</thead>
			<tbody>
				<c:forEach var="customer" items= "${customers}">	
						<tr>
							<td>${customer.id}</td>
							<td>${customer.name}</td>
							<td>${customer.country.name}</td>							
						</tr>					
				</c:forEach>
			</tbody>
		</table>
	</c:if>
</body>
</html>