<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Spring Portlet MVC</h1>

<p>The time on the server is ${serverTime}.</p>

<table>
	<thead>
		<tr>
			<td>User Name</td>
			<td>First Name</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="user" items="${users}">
			<tr>
				<td><c:out value="${user.username}"></c:out></td>
				<td><c:out value="${user.firstName}"></c:out></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
