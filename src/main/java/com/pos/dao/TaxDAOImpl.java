package com.pos.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.pos.model.Taxes;
@Repository("taxesdao")
public class TaxDAOImpl extends AbstractDao<Integer, Taxes> implements TaxDAO{

	@Override
	public void addTaxes(Taxes tax) {
		persist(tax);
		
	}

	@SuppressWarnings("unchecked")
	public List<Taxes> findTaxes() {
		Criteria criteria = createEntityCriteria();
		return (List<Taxes>) criteria.list();
	}

}
