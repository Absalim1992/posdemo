package com.pos.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "establishment")
public class Establishment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column(name = "estid", unique=true, nullable = false)
	private int estid;
	
	@Size(min=3, max=50)
	@Column(name = "estname", nullable = false)
	private String estname;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "menumasterid")
	private MenuMaster menumaster;
	
	@OneToMany(mappedBy = "establishment", cascade = CascadeType.ALL)
    private List<Floor> listFloor = new ArrayList<>(0);

	public List<Floor> getListFloor() {
		return listFloor;
	}

	public void setListFloor(List<Floor> listFloor) {
		this.listFloor = listFloor;
	}

	public Establishment(String estname, MenuMaster menumaster) {
		
		this.estname = estname;
		this.menumaster = menumaster;
	}

	public Establishment() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEstname() {
		return estname;
	}

	public void setEstname(String estname) {
		this.estname = estname;
	}

	

	public MenuMaster getMenumaster() {
		return menumaster;
	}

	public void setMenumaster(MenuMaster menumaster) {
		this.menumaster = menumaster;
	}

	public int getEstid() {
		return estid;
	}

	public void setEstid(int estid) {
		this.estid = estid;
	}

	@Override
	public String toString() {
		return "Establishment [estname=" + estname + "]";
	}

	

	
	
	
}
