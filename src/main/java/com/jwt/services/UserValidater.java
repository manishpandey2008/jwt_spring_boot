package com.jwt.services;

import java.util.regex.Pattern;

public class UserValidater {
	
	public Boolean nameValidation(String name) {
		if(name.length()<=30) return true;
		return false;
	}
	public Boolean emailValidation(String email) {
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";
		Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
	}
	public Boolean usernameValidation(String username) {
		if(username.length()<=20)return true;
		return false;
	}
	public Boolean phoneValidation(String phone) {
		if(phone.matches("[0-9]+") && phone.length()==10)return true;
		return false;
	}
	public Boolean passwordValidation(String password) {
		if(password.length()<=30)return true;
		return false;
	}
}
