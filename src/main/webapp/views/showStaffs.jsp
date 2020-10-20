<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	rel="stylesheet">
<title>Table of All Staffs</title>
</head>
<body>
	<div class="container">
		<div class="card">
			<div class="card-body">
				<h4 class="card-title d-flex justify-content-center">ALL STAFFS
					REGISTERED IN THE DATABASE</h4>

				<c:if test="${hide == 1}">
					<p class="card-text d-flex justify-content-center">Salary
						Range: ${salaryStart} To ${salaryEnd}</p>
				</c:if>
			</div>
		</div>
	</div>
	<br>
	<div class="d-flex justify-content-end">
		<form action="/staff">
			<button type="submit" class="btn btn-primary">Back</button>
		</form>
	</div>
	<br>
	<table class="table table-striped table-bordered">
		<thead>
			<tr>
				<th scope="col">Staff Id</th>
				<th scope="col">Full Name</th>
				<th scope="col">Gender</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="staff" items="${staffs}">
				<tr>

					<td>${staff.getId()}</td>
					<td>${staff.getName()}</td>
					<td>${staff.getGender()}</td>
				</tr>
			</c:forEach>

		</tbody>
	</table>
	<br>
	<div class="d-flex justify-content-end">
		<form action="/staff">
			<button type="submit" class="btn btn-primary">Back</button>
		</form>
	</div>
</body>

</html>