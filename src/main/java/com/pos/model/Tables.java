package com.pos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "tables")
public class Tables {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tableid", unique=true, nullable = false)
	private int tableid;
	
	@ManyToOne
    @JoinColumn(name = "floorid")
    private Floor floor;
	
	@Size(min=3, max=50)
	@Column(name = "tablename", nullable = false)
	private String tablename;
	
	@Column(name = "capacity", nullable = false)
	private int capacity;

	public Tables() {

	}

	public Tables(Floor floor, String tablename, int capacity) {
		
		this.floor = floor;
		this.tablename = tablename;
		this.capacity = capacity;
	}

	public Floor getFloor() {
		return floor;
	}

	public void setFloor(Floor floor) {
		this.floor = floor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTablename() {
		return tablename;
	}

	public void setTablename(String tablename) {
		this.tablename = tablename;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getTableid() {
		return tableid;
	}

	public void setTableid(int tableid) {
		this.tableid = tableid;
	}

	@Override
	public String toString() {
		return "Tables [tableid=" + tableid + ", floor=" + floor + ", tablename=" + tablename + ", capacity=" + capacity
				+ "]";
	}

}
