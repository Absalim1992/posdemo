package com.pos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "taxes")
public class Taxes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	@Column(name = "taxid", unique=true, nullable = false)
	private String taxid;
	
	@Column(name = "taxname", nullable = false)
	private String taxname;
	
	@Column(name = "taxrate", nullable = false)
	private float taxrate;
	
	@Column(name = "status", nullable = false)
	private String status;

	public int getId() {
		return id;
	}

	public Taxes() {
		
	}

	public Taxes(String taxname, float taxrate, String status) {
		this.taxname = taxname;
		this.taxrate = taxrate;
		this.status = status;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTaxname() {
		return taxname;
	}

	public void setTaxname(String taxname) {
		this.taxname = taxname;
	}

	public float getTaxrate() {
		return taxrate;
	}

	public void setTaxrate(float taxrate) {
		this.taxrate = taxrate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	

	public String getTaxid() {
		return taxid;
	}

	public void setTaxid(String taxid) {
		this.taxid = taxid;
	}

	@Override
	public String toString() {
		return "Taxes [id=" + id + ", taxid=" + taxid + ", taxname=" + taxname + ", taxrate=" + taxrate + ", status="
				+ status + "]";
	}

	
	
	
}
