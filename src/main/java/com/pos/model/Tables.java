package com.pos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "tables")
public class Tables {

	@Id
	@GeneratedValue
	@Column(name = "table_id")
	private int id;
	

	@Column(name = "table_name", nullable = false)
	private String name;
	
	@Column(name = "capacity", nullable = false)
	private int capacity;
	
	@ManyToOne(targetEntity=Floor.class)
	@JoinColumn(name="floor_id")
	Floor floor;

	@Transient
	Integer fid;
	
	
	public Integer getFid() {
		return fid;
	}

	public void setFid(Integer fid) {
		this.fid = fid;
	}

	public Floor getFloor() {
		return floor;
	}

	public void setFloor(Floor floor) {
		this.floor = floor;
	}

	public Tables() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Tables(int id, String name, int capacity) {
		
		this.id = id;
		this.name = name;
		this.capacity = capacity;
	}

	@Override
	public String toString() {
		return "Tables [id=" + id + ", name=" + name + ", capacity=" + capacity + "]";
	}


}
