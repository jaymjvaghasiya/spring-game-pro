package com.services;

import org.springframework.stereotype.Service;

@Service
public class OtpGeneratorService {

	public String generateOtp(Integer size) {
		StringBuilder sb = new StringBuilder("");
		String seed = "0123456789";
		
		for(int i = 0; i < size; i++) {
			Integer index = (int) (Math.random() * seed.length());
			if(i == 0 && index == 0) i--;
			sb.append(seed.charAt(index));
		}
		return sb.toString();
	}
}
