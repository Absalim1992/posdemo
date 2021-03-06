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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "floor")
public class Floor {

	@Id
	@GeneratedValue
	@Column(name = "floor_id")
	private int id;
	
	@Column(name = "floor_name", nullable = false)
	private String name;
	
	@ManyToOne(targetEntity=Establishment.class)
	@JoinColumn(name="est_id")
	Establishment est;
	
	
	@OneToMany(targetEntity=Tables.class,cascade = CascadeType.ALL,mappedBy="floor")
    private List<Tables> listTables = new ArrayList<>();
	
	@Transient
	Integer eid;

	
	public Establishment getEst() {
		return est;
	}
	public void setEst(Establishment est) {
		this.est = est;
	}
	public Integer getEid() {
		return eid;
	}
	public void setEid(Integer eid) {
		this.eid = eid;
	}
	public Floor() {
		
	}
	public List<Tables> getListTables() {
		return listTables;
	}

	public void setListTables(List<Tables> listTables) {
		this.listTables = listTables;
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

	public Floor(int id, String name) {
		
		this.id = id;
		this.name = name;

	}
	
	@Override
	public String toString() {
		return "Floor [id=" + id + ", name=" + name + ", listTables=" + listTables + "]";
	}

}
