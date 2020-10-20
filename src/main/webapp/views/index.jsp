<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<div
		style="position: absolute; top: 120px; bottom: 0; left: 0; right: 0; margin: auto;">
		<div class="container">
			<div class="card">
				<div class="card-body">
					<h4 class="card-title d-flex justify-content-center">School
						Management System</h4>
					<p class="card-text">
					<form action="/course/" method="post">
						<button type="submit" class="btn btn-primary">Course Info
							Page</button>
					</form>
					</p>
					<p class="card-text">
					<form action="/staff/" method="post">
						<button type="submit" class="btn btn-primary">Staff Info
							Page</button>
					</form>
					</p>
					<p class="card-text">
					<form action="/student/" method="post">
						<button type="submit" class="btn btn-primary">Student
							Info Page</button>
					</form>
					</p>
				</div>
			</div>
		</div>
	</div>

</body>

</html>