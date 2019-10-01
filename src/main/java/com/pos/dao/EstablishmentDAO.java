package com.pos.dao;

import java.util.List;

import com.pos.model.Establishment;

public interface EstablishmentDAO {

	void addEstablishment(Establishment establishment);
	
	List<Establishment> findEstablishments();
}
