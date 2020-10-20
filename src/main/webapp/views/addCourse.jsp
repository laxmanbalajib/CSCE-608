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
<title>Course Form</title>
<SCRIPT LANGUAGE="JavaScript">
	function checker() {
		result = document.addCourse.courseId.value;
		var integer = parseInt(result);
		if (!Number.isInteger(integer)) {
			alert("Sorry, that's not a valid course Id.")
			return false
		}

		result = document.addCourse.courseName.value;

		if (result == null || result == "") {
			alert("Sorry, that's not a valid course Name")
			return false
		}

	}
</SCRIPT>
</head>
<body>
	<div
		style="position: absolute; top: 150px; bottom: 0; left: 0; right: 0; margin: auto;">
		<p class=" d-flex justify-content-center"
			style="background: #FF0000; color: white;">
			<c:if test="${submission == 1 }">Your submission wasn't successful (Check your Course Id)</c:if>
		</p>
		<p class=" d-flex justify-content-center"
			style="background: #00e500; color: white;">
			<c:if test="${submission == 2}">Your submission was successful</c:if>
		</p>

		<div class="container">
			<div class="card border-primary mb-3">
				<div class="card-body">
					<h4 class="card-title d-flex justify-content-center">COURSE
						FORM</h4>
					<p class="card-text">
					<form action="/course/findAllCourses" method="post">
						<button type="submit" class="btn btn-primary">Show All
							Course</button>
					</form>
					</p>
					<p class="card-text">
					<form name="addCourse" action="/course/addCourseForm/submit"
						method="post" onsubmit="return checker();">
						Enter Course Number: <input type="text" name="courseNumber"><br>
						Enter Course Name: <input type="text" name="courseName"><br>
						Enter Course Fee: <input type="text" name="courseFee"><br>
						<button type="submit" class="btn btn-primary my-3">Add
							Course</button>
					</form>
					</p>
				</div>
			</div>
		</div>
	</div>
</body>


</html>