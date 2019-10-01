package com.pos.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "l2menu")
public class L2menu implements Serializable{

	@Id
	@GeneratedValue
	@Column(name = "l2menu_id")
	private int id;
	
	@Column(name = "l2menu_name")
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<L3menu> listL3Menu = new ArrayList<L3menu>(0);

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

	@Override
	public String toString() {
		return "L2menu [id=" + id + ", name=" + name + "]";
	}

	public List<L3menu> getListL3Menu() {
		return listL3Menu;
	}

	public void setListL3Menu(List<L3menu> listL3Menu) {
		this.listL3Menu = listL3Menu;
	}

	public L2menu(int id, String name, List<L3menu> listL3Menu) {
		
		this.id = id;
		this.name = name;
		this.listL3Menu = listL3Menu;
	}
	
}
