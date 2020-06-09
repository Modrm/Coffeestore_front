package com.modrm.coffee.vo;

import java.util.HashSet;
import java.util.Set;

/**
 * Catalog entity. @author MyEclipse Persistence Tools
 */

public class Catalog implements java.io.Serializable {

	// Fields

	private Integer catalogid;
	private String catalogname;
	private Set coffees = new HashSet(0);

	// Constructors

	/** default constructor */
	public Catalog() {
	}

	/** full constructor */
	public Catalog(String catalogname, Set coffees) {
		this.catalogname = catalogname;
		this.coffees = coffees;
	}

	// Property accessors

	public Integer getCatalogid() {
		return this.catalogid;
	}

	public void setCatalogid(Integer catalogid) {
		this.catalogid = catalogid;
	}

	public String getCatalogname() {
		return this.catalogname;
	}

	public void setCatalogname(String catalogname) {
		this.catalogname = catalogname;
	}

	public Set getCoffees() {
		return this.coffees;
	}

	public void setCoffees(Set coffees) {
		this.coffees = coffees;
	}

}