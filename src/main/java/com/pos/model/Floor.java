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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "floor")
public class Floor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "floorid", unique=true, nullable = false)
	private int floorid;
	
	@Column(name = "floorname", nullable = false)
	private String floorname;
	
	@ManyToOne
    @JoinColumn(name = "estid")
    private Establishment establishment;
    
    @OneToMany(mappedBy = "floor", cascade = CascadeType.ALL)
    private List<Tables> listTables = new ArrayList<>(0);

	public Floor() {
		
	}

	public Floor(String floorname, Establishment establishment) {
		
		this.floorname = floorname;
		this.establishment = establishment;
	}

	public Establishment getEstablishment() {
		return establishment;
	}

	public void setEstablishment(Establishment establishment) {
		this.establishment = establishment;
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

	public String getFloorname() {
		return floorname;
	}

	public void setFloorname(String floorname) {
		this.floorname = floorname;
	}

	public int getFloorid() {
		return floorid;
	}

	public void setFloorid(int floorid) {
		this.floorid = floorid;
	}

	@Override
	public String toString() {
		return "Floor [floorid=" + floorid + ", floorname=" + floorname + ", establishment=" + establishment + "]";
	}
	
}
