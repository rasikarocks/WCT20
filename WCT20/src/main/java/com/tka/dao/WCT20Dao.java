package com.tka.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.entity.CricketStaff;


@Repository
public class WCT20Dao {
	
	@Autowired
	SessionFactory factory;
			public List<CricketStaff> fetchAllIndianCricketStaff(){
				Session session=factory.openSession();
				 Criteria criteria=session.createCriteria(CricketStaff.class);
				 List<CricketStaff> crickstaffList=criteria.list();
				 System.out.println(crickstaffList);
				 
				return crickstaffList;
			}
			
			public CricketStaff fetchingSingleCricketStaff() {
				Session session=factory.openSession();
				CricketStaff cricketStaff=session.load(CricketStaff.class, 1);
				return cricketStaff;
			}

			public void insertCricketStaff(CricketStaff cricketStaff) {
				Session session=factory.openSession();
				Transaction transaction=session.beginTransaction();
				session.save(cricketStaff);
				transaction.commit();
				
			}

			public void updateCricketStaff(CricketStaff cricketStaff) {
				Session session=factory.openSession();
				Transaction transaction=session.beginTransaction();
				session.update(cricketStaff);
				transaction.commit();
				
			}
}
