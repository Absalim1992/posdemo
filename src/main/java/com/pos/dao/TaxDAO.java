package com.pos.dao;

import java.util.List;

import com.pos.model.Taxes;

public interface TaxDAO {

	void addTaxes(Taxes tax);
	
	List<Taxes> findTaxes();
}
