package com.modrm.coffee.service.impl;

import java.util.List;

import com.modrm.coffee.dao.ICatalogDAO;
import com.modrm.coffee.dao.ICoffeeDAO;
import com.modrm.coffee.dao.impl.CatalogDAO;
import com.modrm.coffee.service.ICoffeeService;
import com.modrm.coffee.vo.Coffee;

public class CoffeeService implements ICoffeeService{
	private ICoffeeDAO coffeeDAO;

	@Override
	public List getCoffeebyCatalogid(Integer catalogid) {
		return coffeeDAO.getCoffeebyCatalogid(catalogid);
	}

	public ICoffeeDAO getCoffeeDAO() {
		return coffeeDAO;
	}

	public void setCoffeeDAO(ICoffeeDAO coffeeDAO) {
		this.coffeeDAO = coffeeDAO;
	}

	@Override
	public int getTotalbyCastalog(Integer catalogid) {
		
		return coffeeDAO.getTotalbyCastalog(catalogid);
	}

	@Override
	public List getCoffeebyCatalogidPaging(Integer catalogid, int currentPage, int pageSize) {
		return coffeeDAO.getCoffeebyCatalogidPaging(catalogid, currentPage, pageSize);
	}

	@Override
	public List getRequiredCoffeebyHql(String hql) {
		return coffeeDAO.getRequiredCoffeebyHql(hql);
	}

	@Override
	public Coffee getCoffeebyId(Integer coffeeid) {
		
		return coffeeDAO.getCoffeebyId(coffeeid);
	}

	@Override
	public List getCoffeeAllHql(int currentPage, int pageSize) {
		return coffeeDAO.getCoffeeAllHql(currentPage, pageSize);
	}

	@Override
	public int getTotalbyCastalog() {
		
		return coffeeDAO.getTotalbyCastalog();
	}
	
}
