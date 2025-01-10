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
		<div class="row">
			<!-- Reset Password Form -->
			<div class="row justify-content-center reset-form-outers" id="resetPassword">
				<div class="col-md-6 mb-4">
					<div class="card shadow-sm">
						<div class="card-header bg-danger text-white text-center">
							<h4>Reset Password</h4>
						</div>
						<div class="card-body">
							<form action="resetpassword" method="post">
								<div class="mb-3">
									<label for="resetPasswordNew" class="form-label">New
										Password</label> <input type="password" class="form-control"
										id="resetPasswordNew" name="new_password"
										placeholder="Enter new password">
								</div>
								<div class="mb-3">
									<label for="resetPasswordConfirm" class="form-label">Confirm
										Password</label> <input type="password" class="form-control"
										id="resetPasswordConfirm" name="confirm_password"
										placeholder="Confirm new password">
								</div>
								<button type="submit" class="btn btn-danger w-100">Reset
									Password</button>
							</form>
							<div class="text-center mt-3">
								<a href="login">Back to Login</a>
							</div>
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
