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
@Table(name = "l1menu")
public class L1menu implements Serializable{

	@Id
	@GeneratedValue
	@Column(name = "l1menu_id")
	private int id;
	
	@Column(name = "l1menu_name", nullable = false)
	private String name;

	@ManyToOne(targetEntity=MenuMaster.class)
	@JoinColumn(name="menumaster_id")
	MenuMaster master;
	
	@OneToMany(targetEntity = L2menu.class, cascade = CascadeType.ALL, mappedBy ="l1menu")
    private List<L2menu> listL2Menu = new ArrayList<>();
	
	@Transient
	Integer uid;
	
	

	public MenuMaster getMaster() {
		return master;
	}

	public void setMaster(MenuMaster master) {
		this.master = master;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
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

	public L1menu(String name) {
		super();
		this.name = name;
	}

	public List<L2menu> getListL2Menu() {
		return listL2Menu;
	}

	public void setListL2Menu(List<L2menu> listL2Menu) {
		this.listL2Menu = listL2Menu;
	}

	

	
	
}
