package com.modrm.coffee.vo;

import java.util.HashSet;
import java.util.Set;

/**
 * Coffee entity. @author MyEclipse Persistence Tools
 */

public class Coffee implements java.io.Serializable {

	// Fields

	private Integer coffeeid;
	private Catalog catalog;
	private String coffeename;
	private Integer price;
	private String picture;
	private Set orderitems = new HashSet(0);

	// Constructors

	/** default constructor */
	public Coffee() {
	}

	/** full constructor */
	public Coffee(Catalog catalog, String coffeename, Integer price, String picture, Set orderitems) {
		this.catalog = catalog;
		this.coffeename = coffeename;
		this.price = price;
		this.picture = picture;
		this.orderitems = orderitems;
	}

	// Property accessors

	public Integer getCoffeeid() {
		return this.coffeeid;
	}

	public void setCoffeeid(Integer coffeeid) {
		this.coffeeid = coffeeid;
	}

	public Catalog getCatalog() {
		return this.catalog;
	}

	public void setCatalog(Catalog catalog) {
		this.catalog = catalog;
	}

	public String getCoffeename() {
		return this.coffeename;
	}

	public void setCoffeename(String coffeename) {
		this.coffeename = coffeename;
	}

	public Integer getPrice() {
		return this.price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getPicture() {
		return this.picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public Set getOrderitems() {
		return this.orderitems;
	}

	public void setOrderitems(Set orderitems) {
		this.orderitems = orderitems;
	}

}