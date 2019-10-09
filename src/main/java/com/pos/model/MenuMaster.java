package com.pos.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name = "menumaster")
public class MenuMaster {

	@Id
	@GeneratedValue
	@Column(name = "menumaster_id")
	private int id;
	
	@Column(name = "menumaster_name", nullable = false)
	private String name;
	
	@OneToMany(targetEntity=L1menu.class,cascade = CascadeType.ALL,mappedBy="master")
    private List<L1menu> listL1Menu = new ArrayList<>();
	
	@OneToMany(targetEntity=Establishment.class,cascade = CascadeType.ALL,mappedBy="master")
	private List<Establishment> listEst = new ArrayList<>();

	/*@OneToMany(cascade = CascadeType.ALL)
	private List<Establishment> listEstablishment = new ArrayList<>(0);
	
	public List<Establishment> getListEstablishment() {
		return listEstablishment;
	}

	public void setListEstablishment(List<Establishment> listEstablishment) {
		this.listEstablishment = listEstablishment;
	}
*/
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

	public List<L1menu> getListL1Menu() {
		return listL1Menu;
	}

	public void setListL1Menu(List<L1menu> listL1Menu) {
		this.listL1Menu = listL1Menu;
	}

	

	public MenuMaster(String name) {
	
		this.name = name;
	}

	public MenuMaster() {
		
	}

	@Override
	public String toString() {
		return "MenuMaster [id=" + id + ", name=" + name + "]";
	}

	

}
