<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Class</th>
						<th>Subject</th>
						<th>Teacher</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach var="user" items="${searchUser}">

						<tr>
							<td><c:out value="${user.id}" /></td>
							<td><c:out value="${user.sname}" /></td>
							<td><c:out value="${user.sclass}" /></td>
							<td><c:out value="${user.subject}" /></td>
							<td><c:out value="${user.teacher}" /></td>
							<td><a href="edit?id=<c:out value='${user.id}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="delete?id=<c:out value='${user.id}' />">Delete</a></td>
						</tr>
					</c:forEach>

					<c:if test=""></c:if>

				</tbody>

			</table>
</body>
</html>