package com.modrm.coffee.dao;

import javax.servlet.http.HttpServletResponse;

import com.modrm.coffee.vo.User;

public interface IUserDAO {
	public void saveUser(User user);

	public User validateUser(String username, String password);

	public boolean issureUser(String username);

	public int updateUser(User user);

	public boolean updateHeadImg(User user);

	// ÆßÌì²»µÇÂ¼
	public void addCookie(HttpServletResponse response, String name, String pwd);
}
