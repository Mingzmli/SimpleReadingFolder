package com.simple.reading.validate;

import com.simple.reading.admin.form.model.UserInfo;

public class SimpleValidate {

	public static boolean UserValidate(UserInfo formDb, UserInfo user,
			String formVcode, String sessionVcode) {

		if (!formVcode.equalsIgnoreCase(sessionVcode)) {
			return false;
		}
		if (!formDb.getUsername().equals( user.getUsername())
				|| formDb.getPassword().equals(user.getPassword())) {
			return false;
		}

		return true;
	}
}
