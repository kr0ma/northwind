<%@ page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix="v" uri='http://vdab.be/tags'%>
<!doctype html>
<html lang='nl'>
<v:head title='Northwind employees'/>
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
		<h1>Northwind Employees</h1>		
	</header>
	<form>
		<label>Id</label>
			
			<label><input name='id'
			value='${param.id}' type="number" min="1" autofocus><span>${errors.id}</span></label>
		
		<input type='submit' value='Zoeken'>
	</form>
	<c:if test='${not empty param and empty errors and empty employee}'>
		Employee not found
	</c:if>
	<c:if test="${not empty employee}">	
		<dl>
			<dt>Id</dt>
			<dd>${employee.id}</dd>
			
			<dt>Name</dt>
			<dd>${employee.name}</dd>	
			
			<dt>City</dt>
			<dd>${employee.address.city}</dd>
			
			<dt>Boss</dt>
			<dd>${employee.boss.name}</dd>			
		</dl>		
	</c:if>
	<c:if test="${not empty bosses}">
		<form method="post">
			<label>New boss:
			<span>${errors.boss}</span> 
			<select name='bossId' size='${bosses.size()}' required>
				<c:forEach items='${bosses}' var='boss'>
					<option value='${boss.id}'> ${boss.id} (${boss.name})</option>
				</c:forEach>
			</select>
			
		</label>
			<input type='submit' value='Change boss' id='changeButton'>
			<c:if test="${not empty error}">
			<span>${error}</span></c:if>
		</form>
	</c:if>
</body>
</html>