<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Sign Up & Login</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<link rel="stylesheet" href="css/styles.css">
<body>
	<div class="container mt-5">
		<div class="row">
			<!-- Sign Up Form -->
			<div class="col-md-6 signup-form-outer">
				<div class="card shadow-sm">
					<div class="card-header bg-primary text-white text-center">
						<h4>Sign Up</h4>
					</div>
					<div class="card-body">
						<form action="adduser" method="post" enctype="multipart/form-data">
							<div class="mb-3">
								<label for="signupName" class="form-label">Full Name</label> <input
									type="text" name="fullname" class="form-control"
									id="signupName" placeholder="Enter your full name">
							</div>
							<div class="mb-3">
								<label for="signupEmail" class="form-label">Email
									address</label> <input type="email" name="email" class="form-control"
									id="signupEmail" placeholder="Enter your email">
							</div>
							<div class="mb-3">
								<label for="signupPassword" class="form-label">Password</label>
								<input type="password" name="password" class="form-control"
									id="signupPassword" placeholder="Create a password">
							</div>
							<div class="mb-3">
								<label for="signupConfirmPassword" class="form-label">Confirm
									Password</label> <input type="password" name="cnfpassword"
									class="form-control" id="signupConfirmPassword"
									placeholder="Confirm your password">
							</div>

							<div class="mb-3">
								<label for="signupProfilePic" class="form-label">Profile
									Picture</label> <input type="file" class="form-control"
									id="signupProfilePic" name="profilePic">
							</div>
							<button type="submit" class="btn btn-primary w-100">
								Sign Up</button>
						</form>

						<div class="text-center mt-3">
							<a href="login">Already have an account? Login here</a>
						</div>
					</div>
				</div>
			</div>


		</div>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
