package com.bean;

import org.springframework.web.multipart.MultipartFile;

public class UserBean {
	private String fullname;
	private String email;
	private String password;
	private String cnfpassword;
	private String profile_img_path;
	private String otp;
	private String createdat;
	
	private MultipartFile profilePic;
	
	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getCnfpassword() {
		return cnfpassword;
	}

	public void setCnfpassword(String cnfpassword) {
		this.cnfpassword = cnfpassword;
	}

	public String getProfile_img_path() {
		return profile_img_path;
	}

	public void setProfile_img_path(String profile_img_path) {
		this.profile_img_path = profile_img_path;
	}

	public MultipartFile getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(MultipartFile profilePic) {
		this.profilePic = profilePic;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public String getCreatedat() {
		return createdat;
	}

	public void setCreatedat(String createdat) {
		this.createdat = createdat;
	}
	
	
}
