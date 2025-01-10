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

			<!-- OTP Verification Form -->
			<div class="row justify-content-center" id="otpVerification">
				<div class="col-md-6 mb-4">
					<div class="card shadow-sm">
						<div class="card-header bg-info text-white text-center">
							<h4>OTP Verification</h4>
						</div>
						<span class="errorClass">${error }</span> <span class="infoClass">${info }</span>
						<div class="card-body">
							<form action="checkotp" method="post">
								<label for="otpInput" class="form-label">Enter OTP</label>
								<div class="d-flex justify-content-center mb-3 otpbox">
									<input type="text" class="form-control text-center me-1"
										id="otp1" name="otp_digit1" maxlength="1" style="width: 50px;">
									<input type="text" class="form-control text-center me-1"
										id="otp2" name="otp_digit2" maxlength="1" style="width: 50px;">
									<input type="text" class="form-control text-center me-1"
										id="otp3" name="otp_digit3" maxlength="1" style="width: 50px;">
									<input type="text" class="form-control text-center me-1"
										id="otp4" name="otp_digit4" maxlength="1" style="width: 50px;">
									<input type="text" class="form-control text-center me-1"
										id="otp5" name="otp_digit5" maxlength="1" style="width: 50px;">
									<input type="text" class="form-control text-center" id="otp6"
										name="otp_digit6" maxlength="1" style="width: 50px;">
								</div>
								<button type="submit" class="btn btn-info w-100">Verify
									OTP</button>
							</form>
							<div class="text-center mt-3">
								<form action="resendotp" method="POST">
									<button type="submit" class="resend-otp-btn">Resend OTP</button>
								</form>
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
