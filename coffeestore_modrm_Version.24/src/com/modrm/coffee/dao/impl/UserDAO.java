package com.modrm.coffee.dao.impl;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.modrm.coffee.dao.BaseDAO;
import com.modrm.coffee.dao.IUserDAO;

import com.modrm.coffee.vo.User;
import com.mysql.jdbc.PreparedStatement;

public class UserDAO extends BaseDAO implements IUserDAO {
	public void saveUser(User user) {
		Session session = getSession();
		Transaction tx = session.beginTransaction();
		session.save(user);
		tx.commit();
		session.close();
	}

	public User validateUser(String username, String password) {
		String sql = "from User u where u.username=? and u.password=?";
		Session session = getSession();
		Query query = session.createQuery(sql);
		query.setParameter(0, username);
		query.setParameter(1, password);
		List users = query.list();
		if (users.size() != 0) {
			User user = (User) users.get(0);
			return user;
		}
		session.close();
		return null;
	}

	public boolean issureUser(String username) {
		Session session = getSession();
		String hql = "from User u where u.username=? ";
		Query query = session.createQuery(hql);
		query.setParameter(0, username);
		List users = query.list();
		if (users.size() != 0) {
			User user = (User) users.get(0);
			return true;
		}
		session.close();
		return false;
	}

	@Override
	public int updateUser(User user) {
		int n = 1;
		/*
		 * String sql =
		 * "update User u set u.password=?,u.sex=?,u.age=?,u.email=? where u.username=?"
		 * ; Session session = getSession(); Query
		 * query=session.createQuery(sql);
		 * query.setParameter(0,ub.getPassword());
		 * query.setParameter(1,ub.getSex()); query.setParameter(2,ub.getAge());
		 * query.setParameter(3,ub.getEmail());
		 * query.setParameter(4,ub.getUsername()); List users = query.list(); n
		 * = users.size();
		 */

		/*
		 * Session session=getSession(); String
		 * hql="update User u set u.password=?,u.sex=?,u.age=?,u.email=? where u.username=?"
		 * ; Query query=session.createQuery(hql);
		 * query.setParameter(0,u.getPassword());
		 * query.setParameter(1,u.getSex()); query.setParameter(2,u.getAge());
		 * query.setParameter(3,u.getEmail()); query.setParameter(4,name); List
		 * users=query.list(); if(users.size()!=0){ User
		 * user=(User)users.get(0); return true; } session.close(); return
		 * false;
		 */
		/*
		 * Session session = getSession(); User user = new User();
		 * System.out.println("-------------------");
		 * System.out.println(ub.getPassword());
		 * user.setPassword(ub.getPassword()); user.setSex(ub.getSex());
		 * user.setAge((ub.getAge())); user.setEmail(ub.getEmail()); Transaction
		 * tx = session.beginTransaction(); session.save(user); tx.commit();
		 * session.close();
		 */
		/*
		 * Session session = getSession(); Transaction tx =
		 * session.beginTransaction(); session.update(ub); tx.commit();
		 * session.close();
		 */
		// -------------------------
		Session session = getSession();
		Transaction tx = session.beginTransaction();
		String hql = "update User u set u.password=?,u.sex=?,u.age=?,u.email=? where u.userid=?";
		// String hql = "update CheckIn ch set ch.state = :state where ch.id=
		// :id";
		Query query = session.createQuery(hql);
		query.setString(0, user.getPassword());
		query.setString(1, user.getSex());
		query.setInteger(2, user.getAge());
		query.setString(3, user.getEmail());
		query.setInteger(4, user.getUserid());
		/*
		 * System.out.println("userdao-----------------");
		 * System.out.println(ub.getPassword());
		 * System.out.println(ub.getSex()); System.out.println(ub.getAge());
		 * System.out.println(ub.getEmail()); System.out.println(ub.getId());
		 */
		query.executeUpdate();
		tx.commit();
		session.close();

		return n;
	}

	@Override
	public boolean updateHeadImg(User user) {
		Session session = getSession();
		Transaction tx = session.beginTransaction();
		String hql = "update User u set u.headImg=? where u.userid=?";
		Query query = session.createQuery(hql);
		query.setString(0, user.getHeadImg());
		query.setInteger(1, user.getUserid());
		query.executeUpdate();
		tx.commit();
		session.close();

		return true;
	}

	@Override
	public void addCookie(HttpServletResponse response, String name, String pwd) {
		// 1.创建cookie对象
		System.out.println("addCooki"+name+pwd);
		Cookie nameCookie = new Cookie("username", name);
		Cookie passwordCookie = new Cookie("password", pwd);
		// 2.设置时间
		nameCookie.setMaxAge(24 * 3600 * 7);
		passwordCookie.setMaxAge(24 * 3600 * 7);
		// 3.传送到客户端
		response.addCookie(nameCookie);
		response.addCookie(passwordCookie);
		
	}


}
