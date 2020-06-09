package com.modrm.coffee.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.modrm.coffee.vo.User;

public interface IUserService {
	public void saveUser(User user);
	public User validateUser(String username,String password);
	public boolean issureUser(String username);
	public int updateUser(User user);
	public boolean updateHeadImg(User user);
	public void addCookie(HttpServletResponse response, String name, String pwd);;
}
