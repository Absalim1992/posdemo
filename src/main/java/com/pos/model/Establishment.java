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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
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
	
	@Size(min=3, max=50)
	@Column(name = "est_name", nullable = false)
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL)
    private List<Floor> listFloor = new ArrayList<>(0);

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
		return "Establishment [id=" + id + ", name=" + name + ", listFloor=" + listFloor + "]";
	}

	public Establishment(int id, String name) {
		
		this.id = id;
		this.name = name;
	}
		
	
}
