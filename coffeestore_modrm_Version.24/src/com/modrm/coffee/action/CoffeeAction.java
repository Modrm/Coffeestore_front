package com.modrm.coffee.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.modrm.coffee.service.ICatalogService;
import com.modrm.coffee.service.ICoffeeService;
import com.modrm.coffee.util.Pager;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class CoffeeAction extends ActionSupport {
	private ICatalogService catalogService;
	protected Integer catalogid;

	protected ICoffeeService coffeeService;
	// ��ǰҳ
	private Integer currentPage = 1;

	private String coffeename;

	// ��ӿ���
	
	// ��ѯ���п���
	public String searchAllCoffee() {
//		List allCoffees = coffeeService.getCoffeeAllHql();
		int totalSize = coffeeService.getTotalbyCastalog();
		Pager pager = new Pager(currentPage, totalSize);
		List allCoffees = coffeeService.getCoffeeAllHql(currentPage, pager.getPageSize());
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("allCoffees", allCoffees);
		request.put("pager", pager);
		return SUCCESS;
	}

	// ��ѯ����
	public String searchCoffee() {
		System.out.println("��������" + coffeename);
		StringBuffer hql = new StringBuffer("from Coffee c ");
		if (coffeename != null && coffeename.length() != 0) {
			hql.append("where c.coffeename like '%" + coffeename + "%'");
		}
		List coffees = coffeeService.getRequiredCoffeebyHql(hql.toString());

		Map request = (Map) ActionContext.getContext().get("request");
		request.put("coffees", coffees);

		return SUCCESS;

	}

	// ��ҳ��ʾ�ķ���
	public String browseCoffeePaging() {
		int totalSize = coffeeService.getTotalbyCastalog(catalogid);
		Pager pager = new Pager(currentPage, totalSize);
		List coffees = coffeeService.getCoffeebyCatalogidPaging(catalogid, currentPage, pager.getPageSize());
		// System.out.println(currentPage);
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("coffees", coffees);
		request.put("pager", pager);
		return SUCCESS;
	}

	// ������
	public String browseCoffee() {
		List coffees = coffeeService.getCoffeebyCatalogid(catalogid);
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("coffees", coffees);
		return SUCCESS;
	}

	// �������
	public String browseCatalog() {
		List catalogs = catalogService.getAllCatalog();

		Map request = (Map) ActionContext.getContext().get("request");
		request.put("catalogs", catalogs);
		return SUCCESS;

	}

	public String getCoffeename() {
		return coffeename;
	}

	public void setCoffeename(String coffeename) {
		this.coffeename = coffeename;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public ICoffeeService getCoffeeService() {
		return coffeeService;
	}

	public void setCoffeeService(ICoffeeService coffeeService) {
		this.coffeeService = coffeeService;
	}

	public ICatalogService getCatalogService() {
		return catalogService;
	}

	public void setCatalogService(ICatalogService catalogService) {
		this.catalogService = catalogService;
	}

	public Integer getCatalogid() {
		return catalogid;
	}

	public void setCatalogid(Integer catalogid) {
		this.catalogid = catalogid;
	}

}
