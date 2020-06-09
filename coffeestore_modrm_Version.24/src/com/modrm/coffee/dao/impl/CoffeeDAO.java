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

	// ��ȡ�ܼ�¼��
	@Override
	public int getTotalbyCastalog() {
		Session session = getSession();
		Query query = session.createQuery("from Coffee c");
		List coffees = query.list();
		int totalSize = coffees.size();
		System.out.println("����" + totalSize);
		session.close();
		return totalSize;
	}

	// �������п���
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

	// ����id��ʾ��Ӧ��coffee�б�
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

	// ��ȡ�ܼ�¼��
	@Override
	public int getTotalbyCastalog(Integer catalogid) {
		Session session = getSession();
		Query query = session.createQuery("from Coffee c where c.catalog.catalogid=?");
		query.setParameter(0, catalogid);
		List coffees = query.list();
		int totalSize = coffees.size();
		System.out.println("����" + totalSize);
		session.close();
		return totalSize;
	}

	// ��ҳ�ķ���
	@Override
	public List getCoffeebyCatalogidPaging(Integer catalogid, int currentPage, int pageSize) {
		// �ѵ� ��ҳ��ʵ�� ��Ҫ��ס�������� hibernate ��ҳ�ķ���
		Session session = getSession();
		Query query = session.createQuery("from Coffee c where c.catalog.catalogid=?");
		query.setParameter(0, catalogid);
		// hibernate ����
		// �����ǰҳ��1�Ļ� 1-1 0
		int startRow = (currentPage - 1) * pageSize;
		query.setFirstResult(startRow);
		query.setMaxResults(pageSize);
		List coffees = query.list();
		session.close();
		return coffees;
	}

	// ��ѯ
	@Override
	public List getRequiredCoffeebyHql(String hql) {
		Session session = getSession();
		Query query = session.createQuery(hql);
		List coffees = query.list();
		return coffees;

	}

	// ���ﳵ
	@Override
	public Coffee getCoffeebyId(Integer coffeeid) {
		Session session = getSession();
		Coffee coffee = (Coffee) session.get(Coffee.class, coffeeid);
		session.close();
		return coffee;
	}
	
	//ÿ�� 

}
