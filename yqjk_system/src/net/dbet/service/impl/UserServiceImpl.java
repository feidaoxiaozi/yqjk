package net.dbet.service.impl;

import java.util.List;

import net.dbet.service.UserService;
import net.dbet.yqjk.User;
import net.dbet.yqjkdao.UserDao;

public class UserServiceImpl implements UserService{

	private UserDao userDao;
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public void delUser(User user) {
		this.userDao.delUser(user);
		
	}

	public List<User> findAllUserxx() {
		
		return this.userDao.findAllUserxx();
	}

	public User findUserxxById(int userId) {
		
		return this.userDao.findUserxxById(userId);
	}

	public void insertUserxx(User user) {
		
		this.userDao.insertUserxx(user);
	}

	public void updateUserxx(User user) {
		this.userDao.updateUserxx(user);
		
	}

	public boolean verifyUser(String username,String password) {
		int result = userDao.verifyUser(username, password);
		if (1 == result) {
			return true;
		} else {
			return false;
		}
	}

}
