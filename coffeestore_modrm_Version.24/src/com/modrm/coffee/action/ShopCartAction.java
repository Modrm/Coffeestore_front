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
	//���� ���� �б�
	private ICoffeeService coffeeService;
	private Integer coffeeid;
	private int quantity;
	/*��Ӷ���*/
	public String addorderitem(){
		
		return "success";
	}
	//��������
	public String goCart(){
		Map session =ActionContext.getContext().getSession();
		Cart cart =(Cart) session.get("cart");
		cart.updateCart(coffeeid, quantity);
		session.put("cart", cart);
		return SUCCESS;
	}
	//��չ��ﳵ
	public String emptyCart(){
		Map session = ActionContext.getContext().getSession();
		session.remove("cart");
		return "success";
	}
	//��ӹ��ﳵ
	public String updateCart(){
		Map session =ActionContext.getContext().getSession();
		Cart cart =(Cart) session.get("cart");
		cart.updateCart(coffeeid, quantity);
		session.put("cart", cart);
		return SUCCESS;
	}
	
	//----------�غ�---------
	//��ΰ���ӵ� ���ﳵ������ ֱ�Ӵ浽���ݿ���ȡ
	public String addToCart(){
		//cart   �ŵ�session��  3������
		Coffee coffee =coffeeService.getCoffeebyId(coffeeid);
		//����ط� û�к����ݹ��������
		Orderitem orderitem = new Orderitem();
		orderitem.setCoffee(coffee);
		orderitem.setQuantity(quantity); 
		//����������ΰ����ݷŵ����ݿ���
		Map session =ActionContext.getContext().getSession();
		Cart cart =(Cart) session.get("cart");
		if(cart==null){
			cart=new Cart();
		}
		//��������
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
