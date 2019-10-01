package com.pos.dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.pos.model.L1menu;
import com.pos.model.L2menu;
import com.pos.model.MenuMaster;

@Repository("l2menudao")
public class L2MenuDAOImpl extends AbstractDao<Integer, L2menu> implements L2MenuDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addL2menu(L2menu l2menu) {
		persist(l2menu);
	}

	@Override
	public List<L1menu> findByMM(int mmId) {
		System.out.println("Inside FindByMM Function " + mmId);
		List<L1menu> l1menulist = new ArrayList<L1menu>();
		Session session = sessionFactory.openSession();
		
		try {
			System.out.println("In Try Block");
			//transaction = session.beginTransaction();
			
			MenuMaster m =  (MenuMaster) session.get(MenuMaster.class, mmId);
			System.out.println("MenuMaster Details - " + m);
			
			List<L1menu> states = m.getListL1Menu();
			for(L1menu s : states)
			{		
				L1menu se = new L1menu(s.getId(), s.getName());
				l1menulist.add(se);	
			}			
			//transaction.commit();
		}
		catch (Exception e) {
			l1menulist = null;
			System.out.println("Exception Caught");
			System.out.println(e);
			
		}finally{
			session.close();
		}
		
		return l1menulist;
	}

	

	

}
