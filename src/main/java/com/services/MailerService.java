package com.services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAmount;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailerService {

	@Autowired
	JavaMailSender mailSernder;
	
	public void sendMailForOtp(String email, String otp) {
		SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Mail for reset Password");
        message.setText("OTP to reset password : " + otp);
        message.setFrom("hr@srk.com");
        mailSernder.send(message);
	}
}
