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
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "establishment")
public class Establishment implements Serializable{
	
	@Id
	@GeneratedValue	
	@Column(name = "est_id")
	private int id;
	
	
	@Column(name = "est_name", nullable = false)
	private String name;
	
	@ManyToOne(targetEntity=MenuMaster.class)
	@JoinColumn(name="menumaster_id")
	MenuMaster master;
		
	@OneToMany(targetEntity=Floor.class,cascade = CascadeType.ALL,mappedBy="est")
    private List<Floor> listFloor = new ArrayList<>();
	
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

	public List<Floor> getListFloor() {
		return listFloor;
	}

	public void setListFloor(List<Floor> listFloor) {
		this.listFloor = listFloor;
	}

	public Establishment() {
		
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

	public Establishment(int id, String name, List<Floor> listFloor) {
		this.id = id;
		this.name = name;
		this.listFloor = listFloor;
	}

	@Override
	public String toString() {
		return "Establishment [id=" + id + ", name=" + name + "]";
	}

	public Establishment(int id, String name) {
		
		this.id = id;
		this.name = name;
	}
}
