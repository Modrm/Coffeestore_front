package com.modrm.coffee.service;

import java.util.List;

import com.modrm.coffee.vo.Coffee;

public interface ICoffeeService {
	//�������еĿ��ȵļ�¼��
	public int getTotalbyCastalog();
	
	// �������еĿ���
	public List getCoffeeAllHql(int currentPage, int pageSize);

	// ��������ҿ���
	public List getCoffeebyCatalogid(Integer catalogid);

	// �õ��ܵļ�¼��
	public int getTotalbyCastalog(Integer catalogid);

	// ����id��ҳ��ʾ����
	public List getCoffeebyCatalogidPaging(Integer catalogid, int currentPage, int pageSize);

	// �������ȹ���
	public List getRequiredCoffeebyHql(String hql);

	// ���ݿ��ȵ�id���ҵ�Ҫ�������
	public Coffee getCoffeebyId(Integer coffeeid);
}
