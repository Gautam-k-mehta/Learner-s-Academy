<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<header>
	<nav class="navbar navbar-expand-md navbar-dark"
		style="background-color: green">
		<div>
			<a href="https://www.xadmin.net" class="navbar-brand"> Learner's
				Academy </a>
		</div>

		<ul class="navbar-nav">
		</ul>
	</nav>
</header>
<body>
	<div id="login">
		<h3 class="text-center text-white pt-5">Login form</h3>
		<div class="container">
			<div id="login-row"
				class="row justify-content-center align-items-center">
				<div id="login-column" class="col-md-6">
					<div id="login-box" class="col-md-12">
						<form id="login-form" class="form" action="" method="post">
							<h3 class="text-center text-info" style="color:green">Login</h3>
							<div class="form-group">
								<label for="username" class="text-info" style="color:green">Username:</label><br>
								<input type="text" name="username" id="username"
									class="form-control">
							</div>
							<div class="form-group">
								<label for="password" class="text-info">Password:</label><br>
								<input type="text" name="password" id="password"
									class="form-control"> <br>
									<input type="submit"
								name="submit" class="btn btn-info btn-md" value="submit">
							</div>

						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>