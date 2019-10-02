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
@Table(name = "l1menu")
public class L1menu implements Serializable{

	@Id
	@GeneratedValue
	@Column(name = "l1menu_id")
	private int id;
	
	@Column(name = "l1menu_name", nullable = false)
	private String name;

	@OneToMany(cascade = CascadeType.ALL)
	private List<L2menu> listL2Menu = new ArrayList<L2menu>(0);

	@OneToMany(cascade = CascadeType.ALL)
	private List<Taxes> listtax = new ArrayList<Taxes>(0);
	
	public List<Taxes> getListtax() {
		return listtax;
	}

	public void setListtax(List<Taxes> listtax) {
		this.listtax = listtax;
	}

	public List<L2menu> getListL2Menu() {
		return listL2Menu;
	}

	public void setListL2Menu(List<L2menu> listL2Menu) {
		this.listL2Menu = listL2Menu;
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

	public L1menu(int id, String name) {
		
		this.id = id;
		this.name = name;
	}

	public L1menu() {
		
	}

	@Override
	public String toString() {
		return "L1menu [id=" + id + ", name=" + name + "]";
	}

	public L1menu(int id, String name, List<L2menu> listL2Menu) {
		
		this.id = id;
		this.name = name;
		this.listL2Menu = listL2Menu;
	}
	
}
