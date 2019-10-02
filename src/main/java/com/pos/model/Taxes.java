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
	@Column(name = "tax_id")
	private int id;
	
	@Column(name = "tax_name", nullable = false)
	private String taxname;
	
	@Column(name = "tax_rate", nullable = false)
	private float taxrate;
	
	@Column(name = "status", nullable = false)
	private String status;

	public int getId() {
		return id;
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

	public Taxes(int id, String taxname, float taxrate, String status) {
		
		this.id = id;
		this.taxname = taxname;
		this.taxrate = taxrate;
		this.status = status;
	}

	public Taxes() {
			}

	@Override
	public String toString() {
		return "Taxes [id=" + id + ", taxname=" + taxname + ", taxrate=" + taxrate + ", status=" + status + "]";
	}	
	
}
