package com.modrm.coffee.dao;

import java.util.List;

import com.modrm.coffee.vo.Coffee;


public interface ICoffeeDAO {
	//�õ����п��ȵļ�¼��
	public int getTotalbyCastalog();
	//�������еĿ���
	public List getCoffeeAllHql(int currentPage, int pageSize);
	// ��������ҿ���
	public List getCoffeebyCatalogid(Integer catalogid);
	// �õ��ܵļ�¼��
	public int getTotalbyCastalog(Integer catalogid);
	// ����id��ҳ��ʾ����
	public List getCoffeebyCatalogidPaging(Integer catalogid, int currentPage, int pageSize);
	//�������ȹ���
	public List getRequiredCoffeebyHql(String hql);
	//���ݿ��ȵ�id���ҵ�Ҫ����Ŀ���
	public Coffee getCoffeebyId(Integer coffeeid);
	//ÿ����ӵ����ﳵ��ʱ�򣬰����ݴ浽���ݿ���ȡ
/*	public List setCoffeeOrderitem()*/
	//���������ʱ�� �ѹ��ﳵ��Ķ�����ӵ����ݿ�����
	
}
