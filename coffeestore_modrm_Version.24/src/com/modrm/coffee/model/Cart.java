package com.modrm.coffee.model;

import java.awt.print.Book;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.modrm.coffee.vo.Coffee;
import com.modrm.coffee.vo.Orderitem;



public class Cart {
	//map ���ϱ�ʾ���ﳵ�����������������  ������ϸ��һ����������
	protected Map<Integer, Orderitem> items;
	
	public Cart(){
		if(items==null){
			items = new HashMap<Integer, Orderitem>();
		}
	}
	//��ӿ��ȵ����ﳵ
	public void addCoffee(Integer coffeeid, Orderitem orderitem){
		// �жϹ��ﳵ���Ƿ�����صĿ��ȣ����û��ֱ�� ��ӣ�����У���Ҫ�ó�ԭ��������+�µ�����
		if(items.containsKey(coffeeid)){
			Orderitem _orderitem = items.get(coffeeid);
			orderitem.setQuantity(_orderitem.getQuantity()+orderitem.getQuantity());			
		}
		items.put(coffeeid, orderitem);
	}
	
	//���¹��ﳵ�Ĺ�������
	public void updateCart(Integer coffeeid, int quantity){
		Orderitem orderitem =items.get(coffeeid);//��Ϊ���ﳵ�Ǹ�map 
		orderitem.setQuantity(quantity);
		items.put(coffeeid, orderitem);
	}
	
	public int getTotalPrice(){
		int totalPrice=0;
		for(Iterator it=items.values().iterator();it.hasNext();){
			Orderitem orderitem =(Orderitem) it.next();
			Coffee coffee= orderitem.getCoffee();
			int quantity =orderitem.getQuantity();
			totalPrice +=coffee.getPrice()*quantity;
		}
		return totalPrice;
	}
	public Map<Integer, Orderitem> getItems() {
		return items;
	}
	public void setItems(Map<Integer, Orderitem> items) {
		this.items = items;
	}
	
	
}
