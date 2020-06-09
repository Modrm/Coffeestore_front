package com.modrm.coffee.service.impl;

import javax.servlet.http.HttpServletResponse;

import com.modrm.coffee.dao.IUserDAO;

import com.modrm.coffee.service.IUserService;
import com.modrm.coffee.vo.User;


public class UserService implements IUserService{
	private IUserDAO userDAO;
	public void saveUser(User user){
		this.userDAO.saveUser(user);
	}
	public User validateUser(String username,String password){
		return userDAO.validateUser(username, password);
	}
	public boolean issureUser(String username){
		return userDAO.issureUser(username);
	}
	public IUserDAO getUserDAO(){
		return userDAO;
	}
	public void setUserDAO(IUserDAO userDAO){
		this.userDAO=userDAO;
	}
	@Override
	public int updateUser(User user) {
		return userDAO.updateUser(user);
	}
	@Override
	public boolean updateHeadImg(User user) {
		// TODO Auto-generated method stub
		return userDAO.updateHeadImg(user);
	}
	@Override
	
	public void addCookie(HttpServletResponse response, String name, String pwd)  {
		userDAO.addCookie(response, name, pwd);
		
	}
}
