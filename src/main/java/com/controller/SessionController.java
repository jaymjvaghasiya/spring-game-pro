package com.controller;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bean.OtpBean;
import com.bean.UserBean;
import com.dao.UserDao;
import com.services.MailerService;
import com.services.OtpGeneratorService;

import jakarta.servlet.http.HttpSession;

@Controller
public class SessionController {
	
	@Autowired
	UserDao userdao;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	OtpGeneratorService generateOtp;
	
	@Autowired
	MailerService mailerService;
	
	@GetMapping("login")
	public String getLoginPage() {
		return "login";
	}
	
	@GetMapping("signup")
	public String getSignupPage() {
		return "signup";
	}
	
	@PostMapping("adduser")
	public String addUser(UserBean user, Model model) {
		if(!user.getPassword().equals(user.getCnfpassword())) {
			model.addAttribute("error", "Please enter same password.");
			return "signup";
		}
		
		File newFile = new File("F:\\2.Royal\\Spring - Tejas Sir\\SpringGamePro\\src\\main\\webapp\\images\\"+user.getEmail(), user.getProfilePic().getOriginalFilename());
		if(!user.getProfilePic().getContentType().startsWith("image")) {
			model.addAttribute("Only Images accepted.");
		} else {
			try {
				FileUtils.writeByteArrayToFile(newFile, user.getProfilePic().getBytes());
				user.setProfile_img_path("images/"+user.getEmail()+"/"+user.getProfilePic().getOriginalFilename());
				user.setPassword(passwordEncoder.encode(user.getPassword()));
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		Integer i = userdao.addUser(user);
		if(i > 0) {
			return "login";
		}
		return "signup";
	}
	
	@PostMapping("authenticate")
	public String authenticateUser(UserBean user, Model model) {
		UserBean dbuser = userdao.getUserByEmail(user.getEmail());
		if(dbuser != null) {
			boolean flag = passwordEncoder.matches(user.getPassword(), dbuser.getPassword());
			System.out.println("Created time : " + dbuser.getCreatedat());
			if(flag) {
				return "dashboard";
			} else {
				model.addAttribute("error", "Invalide Credential, Please try again");
			}
		} else {
			model.addAttribute("error", "Invalide Credential, Please try again");
		}
		return "login";
	}
	
	@GetMapping("forgetpassword")
	public String gotoForgetPass() {
		return "forgetpass";
	}
	
	@PostMapping("checkuser")
	public String checkUser(UserBean user, Model model, HttpSession session) {
		if(user.getEmail().trim().length() == 0) {
			model.addAttribute("error", "Please enter email address first");
			return "forgetpass";
		}
		UserBean dbuser = userdao.getUserByEmail(user.getEmail());
		if(dbuser != null) {
			String otp = generateOtp.generateOtp(6);
			session.setAttribute("email", user.getEmail());
			
			LocalDateTime dateTime = LocalDateTime.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			model.addAttribute("info", "OTP will be expired after 10 minutes.");
			
			Integer i = userdao.updateUserOtp(user.getEmail(), otp, dateTime.format(formatter));
			mailerService.sendMailForOtp(user.getEmail(), otp);
//			System.out.println("I : " + i);
			return "otp";
		} else {
			model.addAttribute("error", "The email doen not exists, Please Register first.");
		}
		return "forgetpass";
	}
	
	@PostMapping("resendotp")
	public String resendOtp(Model model, HttpSession session) {
		String email = (String) session.getAttribute("email");
		UserBean dbuser = userdao.getUserByEmail(email);
		
		if(dbuser != null) {
			String otp = generateOtp.generateOtp(6);
			
			LocalDateTime dateTime = LocalDateTime.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			model.addAttribute("info", "OTP will be expired after 10 minutes.");
			
			Integer i = userdao.updateUserOtp(email, otp, dateTime.format(formatter));
			mailerService.sendMailForOtp(email, otp);
//			System.out.println("I : " + i);
			return "otp";
		} else {
			model.addAttribute("error", "The email doen not exists, Please Register first.");
		}
		return "forgetpass";
	}
	
	@PostMapping("checkotp")
	public String checkOTP(OtpBean otpBean, Model model, HttpSession session) {
		StringBuilder strotp = new StringBuilder();
		strotp.append(otpBean.getOtp_digit1());
		strotp.append(otpBean.getOtp_digit2());
		strotp.append(otpBean.getOtp_digit3());
		strotp.append(otpBean.getOtp_digit4());
		strotp.append(otpBean.getOtp_digit5());
		strotp.append(otpBean.getOtp_digit6());
		
		String otp;
		
		LocalDateTime dateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String currentTimeStr = dateTime.format(formatter);
		LocalDateTime currentTime = LocalDateTime.parse(currentTimeStr, formatter);
		
		try {
			otp = strotp.toString();
			String email = (String) session.getAttribute("email");
			UserBean dbuser = userdao.getUserByEmail(email);
			
			LocalDateTime dbtime = LocalDateTime.parse(dbuser.getCreatedat(), formatter);
			if(ChronoUnit.MINUTES.between(dbtime, currentTime) > 10) {
				model.addAttribute("error", "Your OTP has been expired !");
				return "login";
			}
			
			if(otp.equals(dbuser.getOtp())) {
				return "resetpass";
			} else {
				model.addAttribute("error", "Please enter valid OTP.");
			}
		} catch(Exception e) {
			e.printStackTrace();
			model.addAttribute("error", "Please enter valid OTP.");
		}
		return "otp";
	}
	
	@PostMapping("resetpassword")
	public String resetPassword(@RequestParam String new_password, @RequestParam String confirm_password, HttpSession session, Model model) {
		String email = (String) session.getAttribute("email");
		if(!new_password.equals(confirm_password)) {
			model.addAttribute("error", "Please enter valid password!");
		}
		String encodedPass = passwordEncoder.encode(confirm_password);
		Integer i = userdao.updateUserPassword(email, encodedPass);
		if(i > 0) {
			return "login";
		}
		
		return "resetpass";
	}
}
