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
@Table(name = "l2menu")
public class L2menu implements Serializable{

	@Id
	@GeneratedValue
	@Column(name = "l2menu_id")
	private int id;
	
	@Column(name = "l2menu_name")
	private String name;
	
	@ManyToOne(targetEntity = L1menu.class)
	@JoinColumn(name = "l1menu_id")
	L1menu l1menu;
	
	@OneToMany(targetEntity = L3menu.class, cascade = CascadeType.ALL, mappedBy ="l2menu")
    private List<L3menu> listL3Menu = new ArrayList<>();
	
	@Transient
	Integer lid;
	
	

	public L1menu getL1menu() {
		return l1menu;
	}

	public void setL1menu(L1menu l1menu) {
		this.l1menu = l1menu;
	}

	public Integer getLid() {
		return lid;
	}

	public void setLid(Integer lid) {
		this.lid = lid;
	}

	public L2menu(int id, String name) {
		
		this.id = id;
		this.name = name;
	}

	public L2menu() {
		
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

	

	
}
