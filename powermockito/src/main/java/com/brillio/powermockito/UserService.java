package com.brillio.powermockito;

public class UserService {

	private UserDao userDao;
	
	public UserService() {
		
	}

	public UserService(UserDao userDao) {
		super();
		this.userDao = userDao;
	}
	
	public String getNameByUserId(Integer id) {
		String name=userDao.findNameById(id);
		return name;
	}
	
	public String getEmailByUserId(Integer id) {
		String email=userDao.findEmailById(id);
		return email;
	}
}
