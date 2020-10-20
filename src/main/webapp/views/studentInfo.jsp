<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	rel="stylesheet">
<title>Student Info</title>
<SCRIPT LANGUAGE="JavaScript">
	function checker() {
		result = document.form1.studentId.value;
		var integer = parseInt(result);
		if (!Number.isInteger(integer)) {
			alert("Sorry, that's not a valid student Id.")
			return false
		} else {
			document.form1.submit()
		}

	}
</SCRIPT>
</head>
<body>

	<div
		style="position: absolute; top: 120px; bottom: 0; left: 0; right: 0; margin: auto;">
		<div class="container">
			<div class="card">
				<div class="card-body">
					<h4 class="card-title d-flex justify-content-center">STUDENT
						INFO PAGE</h4>
					<p class="card-text">
					<form action="/student/findAllStudents" method="post">
						<button type="submit" class="btn btn-primary">Show All
							Students Personal Info</button>
					</form>
					</p>
					<p class="card-text">
					<form action="/student/findAllStudents/Tuition" method="post">
						<button type="submit" class="btn btn-primary">Show All
							Students Tuition Info</button>
					</form>
					</p>

					<p class="card-text">
					<form name="form1" action="/student/findStudentById" method="post"
						onsubmit="return checker();">
						Enter Student Id: <input type="text" name="studentId"><br>
						<button type="submit" class="btn btn-primary">Submit</button>
					</form>
					</p>
					<p class="card-text">
					<form action="/student/addStudentForm">

						<button type="submit" class="btn btn-primary">Form for
							adding a new Student</button>
					</form>

					</p>

					<p class="card-text">
					<form action="/student/updateStudentForm">

						<button type="submit" class="btn btn-primary">Form for updating Student</button>
					</form>

					</p>
					
					<p class="card-text">
					<form action="/student/register">

						<button type="submit" class="btn btn-primary">Form for registering course</button>
					</form>

					</p>

				</div>
			</div>
		</div>

		<c:if test="${hide == 1}">
			<table class="table table-striped table-bordered my-3">
				<thead>
					<tr>
						<th scope="col">Student Id</th>
						<th scope="col">Full Name</th>
						<th scope="col">Gender</th>
					</tr>
				</thead>
				<tbody>

					<tr>
						<td>${student.getId()}</td>
						<td>${student.getName()}</td>
						<td>${student.getGender()}</td>
					</tr>

				</tbody>
			</table>
			<form action="/student/findCoursesByStudent" method="post">
				<input type="hidden" name="studentName" value="${student.getName()}">
				<button type="submit" class="btn btn-primary"
					value="${student.getId()}" name="studentId">Find Courses</button>
			</form>
		</c:if>

		<c:if test="${hide == 2}">
			<div class="d-flex justify-content-center my-3">
				<p>
					<b>Student Id: </b>${studentId} <span style="paddingLeft: 10px;"></span>
					<b>Student Name:</b>${studentName}
				</p>
			</div>

			<table class="table table-striped table-bordered my-3">
				<thead>
					<tr>
						<th scope="col">Course Name</th>
						<th scope="col">Course Id</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach var="course" items="${courses}">
						<tr>


							<td>${course.getCourseName()}</td>
							<td>${course.getCourseNumber()}</td>

						</tr>
					</c:forEach>


				</tbody>
			</table>
		</c:if>

	</div>







</body>


</html>