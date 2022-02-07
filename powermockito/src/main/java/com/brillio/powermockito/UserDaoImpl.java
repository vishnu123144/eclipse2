package com.brillio.powermockito;

public class UserDaoImpl implements UserDao{

	@Override
	public String findNameById(Integer id) {
		
		return "vishnu";
	}

	@Override
	public String findEmailById(Integer id) {
		
		return "vishnu@gmail.com";
	}

}
