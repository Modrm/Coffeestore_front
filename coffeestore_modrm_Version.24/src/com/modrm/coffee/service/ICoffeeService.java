package com.modrm.coffee.service;

import java.util.List;

import com.modrm.coffee.vo.Coffee;

public interface ICoffeeService {
	//查找所有的咖啡的记录数
	public int getTotalbyCastalog();
	
	// 查找所有的咖啡
	public List getCoffeeAllHql(int currentPage, int pageSize);

	// 根据类别找咖啡
	public List getCoffeebyCatalogid(Integer catalogid);

	// 得到总的记录数
	public int getTotalbyCastalog(Integer catalogid);

	// 根据id分页显示咖啡
	public List getCoffeebyCatalogidPaging(Integer catalogid, int currentPage, int pageSize);

	// 搜索咖啡功能
	public List getRequiredCoffeebyHql(String hql);

	// 根据咖啡的id号找到要购买的书
	public Coffee getCoffeebyId(Integer coffeeid);
}
