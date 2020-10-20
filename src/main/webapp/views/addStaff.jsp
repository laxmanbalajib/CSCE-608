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
<title>Staff Form</title>
<SCRIPT LANGUAGE="JavaScript">
	function checker() {
		result = document.addStaff.staffId.value;
		var integer = parseInt(result);
		if (!Number.isInteger(integer)) {
			alert("Sorry, that's not a valid staff Id.")
			return false
		}

		result = document.addStaff.staffName.value;

		if (result == null || result == "") {
			alert("Sorry, that's not a valid staff Name")
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
			<c:if test="${submission == 1 }">Your submission wasn't successful (Check your Staff Id)</c:if>
		</p>
		<p class=" d-flex justify-content-center"
			style="background: #00e500; color: white;">
			<c:if test="${submission == 2}">Your submission was successful</c:if>
		</p>

		<div class="container">
			<div class="card border-primary mb-3">
				<div class="card-body">
					<h4 class="card-title d-flex justify-content-center">STAFF
						FORM</h4>
					<p class="card-text">
					<form action="/staff/findAllStaffs" method="post">
						<button type="submit" class="btn btn-primary">Show All
							Staff</button>
					</form>
					</p>
					<p class="card-text">
					<form name="addStaff" action="/staff/addStaffForm/submit"
						method="post" onsubmit="return checker();">
						Enter Staff Id: <input type="text" name="staffId"><br>
						Enter Staff Name: <input type="text" name="staffName"><br>
						Gender: <select name="gender">
							<option>Male</option>
							<option>Female</option>
							<option>Transgender</option>
							<option>Non Binary</option>
						</select> <br>
						<button type="submit" class="btn btn-primary my-3">Add
							Staff</button>
					</form>
					</p>
				</div>
			</div>
		</div>
	</div>
</body>


</html>