package com.pos.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.pos.model.L1menu;

@Repository("l1menudao")
@Transactional
public class L1MenuDAOImpl extends AbstractDao<Integer, L1menu> implements L1MenuDAO{

	@Override
	public void addL1menu(L1menu l1menu) {
		persist(l1menu);	
	}

	@SuppressWarnings("unchecked")
	public List<L1menu> findL1Menu() {
		Criteria criteria = createEntityCriteria();
		return (List<L1menu>) criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<L1menu> findl1bymm(String mm) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("menumaster_name", mm));
		return (List<L1menu>) criteria.list();
	}
}
