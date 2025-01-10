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
<link rel="stylesheet" href="css/styles.css">
</head>
<body>
	<div class="container mt-5">
		<div class="row login-design">
			<div class="sidebar-img">			
				<img alt="" src="images/sideimg/img1.jpg">
			</div>
			<!-- Login Form -->
			<div class="col-md-6 login-form-outer">
				<div class="card shadow-sm">
					<div class="card-header bg-success text-white text-center">
						<h4>Login</h4>
					</div>
					<span class="errorClass">${error }</span>
					<div class="card-body">
						<form action="authenticate" method="post">
							<div class="mb-3">
								<label for="loginEmail" class="form-label">Email address</label>
								<input type="email" name="email" class="form-control" id="loginEmail"
									placeholder="Enter your email">
							</div>
							<div class="mb-3">
								<label for="loginPassword" class="form-label">Password</label> <input
									type="password" name="password" class="form-control" id="loginPassword"
									placeholder="Enter your password">
							</div>
							<div class="mb-3 form-check">
								<input type="checkbox" class="form-check-input" id="rememberMe">
								<label class="form-check-label" for="rememberMe">Remember
									me</label>
							</div>
							<button type="submit" class="btn btn-success w-100">Login</button>
							<div class="text-center mt-3">
								<a href="forgetpassword">Forgot Password?</a>
							</div>
						</form>
						<div class="text-center mt-3">
                            <a href="signup">Don't have an account? Sign Up here</a>
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
