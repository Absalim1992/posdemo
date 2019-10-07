package com.pos.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;





@Entity
@Table(name = "l3menu")
public class L3menu implements Serializable{


	@Id
	@GeneratedValue
	@Column(name = "l3menu_id")
	private int id;
	
	@Column(name = "l3menu_name")
	private String name;
	
	@ManyToOne(targetEntity = L2menu.class)
	@JoinColumn(name = "l2menu_id")
	L2menu l2menu;
	
	@ManyToOne(targetEntity = Taxes.class)
	@JoinColumn(name="tax_id")
	Taxes tax;
	
	
	@Transient
	Integer lid;
	
	@Transient
	Integer tid;

	
	public Taxes getTax() {
		return tax;
	}

	public void setTax(Taxes tax) {
		this.tax = tax;
	}

	public Integer getTid() {
		return tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}

	public L2menu getL2menu() {
		return l2menu;
	}

	public void setL2menu(L2menu l2menu) {
		this.l2menu = l2menu;
	}

	public Integer getLid() {
		return lid;
	}

	public void setLid(Integer lid) {
		this.lid = lid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public L3menu(int id, String name) {
		
		this.id = id;
		this.name = name;
	}

	
	public L3menu() {
		
	}

	

}
