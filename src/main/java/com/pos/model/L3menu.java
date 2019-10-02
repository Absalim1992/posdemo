package com.pos.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "l3menu")
public class L3menu implements Serializable{


	@Id
	@GeneratedValue
	@Column(name = "l3menu_id")
	private int id;
	
	@Column(name = "l3menu_name")
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Taxes> listtax = new ArrayList<Taxes>(0);

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

	public List<Taxes> getListtax() {
		return listtax;
	}

	public void setListtax(List<Taxes> listtax) {
		this.listtax = listtax;
	}

	@Override
	public String toString() {
		return "L3menu [id=" + id + ", name=" + name + ", listtax=" + listtax + "]";
	}
	

}
