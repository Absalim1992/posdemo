package com.pos.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.pos.model.Establishment;

@Repository("establishmentdao")
public class EstablishmentDAOImpl extends AbstractDao<Integer, Establishment> implements EstablishmentDAO{

	@Override
	public void addEstablishment(Establishment establishment) {
		persist(establishment);
		
	}

	@SuppressWarnings("unchecked")
	public List<Establishment> findEstablishments() {
		Criteria criteria = createEntityCriteria();
		return (List<Establishment>) criteria.list();
	}

	

}
