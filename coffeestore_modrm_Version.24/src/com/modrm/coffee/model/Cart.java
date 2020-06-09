package com.modrm.coffee.model;

import java.awt.print.Book;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.modrm.coffee.vo.Coffee;
import com.modrm.coffee.vo.Orderitem;



public class Cart {
	//map 集合表示购物车，保存书的两个属性  订单详细的一个数量属性
	protected Map<Integer, Orderitem> items;
	
	public Cart(){
		if(items==null){
			items = new HashMap<Integer, Orderitem>();
		}
	}
	//添加咖啡到购物车
	public void addCoffee(Integer coffeeid, Orderitem orderitem){
		// 判断购物车内是否有相关的咖啡，如果没有直接 添加，如果有，需要拿出原来的数量+新的数量
		if(items.containsKey(coffeeid)){
			Orderitem _orderitem = items.get(coffeeid);
			orderitem.setQuantity(_orderitem.getQuantity()+orderitem.getQuantity());			
		}
		items.put(coffeeid, orderitem);
	}
	
	//更新购物车的购买数量
	public void updateCart(Integer coffeeid, int quantity){
		Orderitem orderitem =items.get(coffeeid);//因为购物车是个map 
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
