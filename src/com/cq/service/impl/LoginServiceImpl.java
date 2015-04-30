package com.cq.service.impl;

import org.apache.log4j.Logger;

import com.cq.dao.CQUserDao;
import com.cq.service.LoginService;
import com.cq.table.CQUser;

public class LoginServiceImpl implements LoginService {
	static Logger log = Logger.getLogger(LoginServiceImpl.class);
	private String errorMsg;
	
	private CQUserDao userDao;

	@Override
	public boolean logins(String username, String password) {
		boolean b = false;
		CQUser user = userDao.findOnlyByProperty("name", username);
		
		if (user != null && password.equals(user.getPassword())) {
			b = true;
		} else {
			b = false;
		}
		return b;
	}

	public void setUserDao(CQUserDao userDao) {
		this.userDao = userDao;
	}

}
