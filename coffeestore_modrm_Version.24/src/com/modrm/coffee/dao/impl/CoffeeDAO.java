package com.modrm.coffee.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.hibernate.Query;
import org.hibernate.Session;
import com.modrm.coffee.dao.BaseDAO;
import com.modrm.coffee.dao.ICoffeeDAO;
import com.modrm.coffee.vo.Coffee;
import com.modrm.coffee.vo.Orderitem;

public class CoffeeDAO extends BaseDAO implements ICoffeeDAO {
	protected Map<Integer, Orderitem> items;

	// 获取总记录数
	@Override
	public int getTotalbyCastalog() {
		Session session = getSession();
		Query query = session.createQuery("from Coffee c");
		List coffees = query.list();
		int totalSize = coffees.size();
		System.out.println("总数" + totalSize);
		session.close();
		return totalSize;
	}

	// 查找所有咖啡
	public List getCoffeeAllHql(int currentPage, int pageSize) {

		/*Session session = getSession();
		String hql = "from Coffee c";
		Query query = session.createQuery(hql);
		List allCoffees = query.list();*/
		/*
		 * for (int i=0;i<allCoffees.size();i++){ Coffee coffee = new Coffee();
		 * coffee.setCoffeename(coffee.getPicture());
		 * 
		 * }
		 */
		Session session = getSession();
		Query query = session.createQuery("from Coffee c");
		int startRow = (currentPage - 1) * pageSize;
		query.setFirstResult(startRow);
		query.setMaxResults(pageSize);
		List allCoffees = query.list();
		session.close();
		return allCoffees;

	}

	// 根据id显示对应的coffee列表
	@Override
	public List getCoffeebyCatalogid(Integer catalogid) {
		Session session = getSession();
		String hql = "from Coffee c where c.catalog.catalogid=?";
		Query query = session.createQuery(hql);
		query.setParameter(0, catalogid);
		List coffees = query.list();
		session.close();
		return coffees;
	}

	// 获取总记录数
	@Override
	public int getTotalbyCastalog(Integer catalogid) {
		Session session = getSession();
		Query query = session.createQuery("from Coffee c where c.catalog.catalogid=?");
		query.setParameter(0, catalogid);
		List coffees = query.list();
		int totalSize = coffees.size();
		System.out.println("总数" + totalSize);
		session.close();
		return totalSize;
	}

	// 分页的方法
	@Override
	public List getCoffeebyCatalogidPaging(Integer catalogid, int currentPage, int pageSize) {
		// 难点 分页的实现 需要记住几个方法 hibernate 分页的方法
		Session session = getSession();
		Query query = session.createQuery("from Coffee c where c.catalog.catalogid=?");
		query.setParameter(0, catalogid);
		// hibernate 几步
		// 如果当前页是1的话 1-1 0
		int startRow = (currentPage - 1) * pageSize;
		query.setFirstResult(startRow);
		query.setMaxResults(pageSize);
		List coffees = query.list();
		session.close();
		return coffees;
	}

	// 查询
	@Override
	public List getRequiredCoffeebyHql(String hql) {
		Session session = getSession();
		Query query = session.createQuery(hql);
		List coffees = query.list();
		return coffees;

	}

	// 购物车
	@Override
	public Coffee getCoffeebyId(Integer coffeeid) {
		Session session = getSession();
		Coffee coffee = (Coffee) session.get(Coffee.class, coffeeid);
		session.close();
		return coffee;
	}
	
	//每次 

}
