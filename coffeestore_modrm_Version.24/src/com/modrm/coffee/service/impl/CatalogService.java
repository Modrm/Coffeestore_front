package com.modrm.coffee.service.impl;

import java.util.List;

import com.modrm.coffee.dao.ICatalogDAO;
import com.modrm.coffee.service.ICatalogService;



public class CatalogService implements ICatalogService	{
	private ICatalogDAO catalogDAO;
	//øß∑»¡–±Ì
	@Override
	public List getAllCatalog() {
		// TODO Auto-generated method stub
		return catalogDAO.getAllCatalog();
	}
	public ICatalogDAO getCatalogDAO() {
		return catalogDAO;
	}
	public void setCatalogDAO(ICatalogDAO catalogDAO) {
		this.catalogDAO = catalogDAO;
	}
	
}
