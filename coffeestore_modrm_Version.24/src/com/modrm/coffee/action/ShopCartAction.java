package com.modrm.coffee.action;

import java.util.Map;

import org.hibernate.Session;

import com.modrm.coffee.model.Cart;
import com.modrm.coffee.service.ICoffeeService;
import com.modrm.coffee.vo.Coffee;
import com.modrm.coffee.vo.Orderitem;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;



public class ShopCartAction extends ActionSupport{
	//咖啡 订单 列表
	private ICoffeeService coffeeService;
	private Integer coffeeid;
	private int quantity;
	/*添加订单*/
	public String addorderitem(){
		
		return "success";
	}
	//结算中心
	public String goCart(){
		Map session =ActionContext.getContext().getSession();
		Cart cart =(Cart) session.get("cart");
		cart.updateCart(coffeeid, quantity);
		session.put("cart", cart);
		return SUCCESS;
	}
	//清空购物车
	public String emptyCart(){
		Map session = ActionContext.getContext().getSession();
		session.remove("cart");
		return "success";
	}
	//添加购物车
	public String updateCart(){
		Map session =ActionContext.getContext().getSession();
		Cart cart =(Cart) session.get("cart");
		cart.updateCart(coffeeid, quantity);
		session.put("cart", cart);
		return SUCCESS;
	}
	
	//----------截胡---------
	//如何把添加到 购物车的数据 直接存到数据库里取
	public String addToCart(){
		//cart   放到session内  3个参数
		Coffee coffee =coffeeService.getCoffeebyId(coffeeid);
		//这个地方 没有和数据国库关联上
		Orderitem orderitem = new Orderitem();
		orderitem.setCoffee(coffee);
		orderitem.setQuantity(quantity); 
		//以上三条如何把数据放到数据库里
		Map session =ActionContext.getContext().getSession();
		Cart cart =(Cart) session.get("cart");
		if(cart==null){
			cart=new Cart();
		}
		//下面这条
		cart.addCoffee(coffeeid, orderitem);
		session.put("cart", cart);
		return SUCCESS;
	}
	
	public ICoffeeService getCoffeeService() {
		return coffeeService;
	}
	public void setCoffeeService(ICoffeeService coffeeService) {
		this.coffeeService = coffeeService;
	}
	public Integer getCoffeeid() {
		return coffeeid;
	}
	public void setCoffeeid(Integer coffeeid) {
		this.coffeeid = coffeeid;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
