package com.modrm.coffee.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.modrm.coffee.dao.BaseDAO;
import com.modrm.coffee.dao.ICatalogDAO;



public class CatalogDAO extends BaseDAO implements ICatalogDAO{

	@Override
	public List getAllCatalog() {
		//µ÷ÓÃhibernate µÄAPI  session
		Session session = getSession();
		/*String hql="from Catalog c";*/
		Query query = session.createQuery("from Catalog c");
		List catalogs = query.list();
		session.close();
		return catalogs;
	}
	
}
