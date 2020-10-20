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
<title>Table of All Courses</title>
</head>
<body>
	<div class="container">
		<div class="card">
			<div class="card-body">
				<h4 class="card-title d-flex justify-content-center">ALL COURSES
					REGISTERED IN THE DATABASE</h4>
			</div>
		</div>
	</div>
	<br>
	<div class="d-flex justify-content-end">
		<form action="/course">
			<button type="submit" class="btn btn-primary">Back</button>
		</form>
	</div>
	<br>
	<table class="table table-striped table-bordered">
		<thead>
			<tr>
				<th scope="col">Course Number</th>
				<th scope="col">Course Name</th>
				<th scope="col">Course Fee</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="course" items="${courses}">
				<tr>

					<td>${course.getCourseNumber()}</td>
					<td>${course.getCourseName()}</td>
					<td>${course.getCourseFee()}</td>

				</tr>
			</c:forEach>

		</tbody>
	</table>
	<br>
	<div class="d-flex justify-content-end">
		<form action="/course">
			<button type="submit" class="btn btn-primary">Back</button>
		</form>
	</div>
</body>

</html>