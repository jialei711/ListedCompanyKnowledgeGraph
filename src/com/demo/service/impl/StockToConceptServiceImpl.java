package com.demo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.demo.bean.StockToConcept;
import com.demo.service.StockToConceptService;


@Transactional
public class StockToConceptServiceImpl implements StockToConceptService {
	
	@Resource private SessionFactory sessionFactory;
	
	@Override
	public void add(StockToConcept s){
		sessionFactory.getCurrentSession().save(s);
	}
	
	
	@Override
	public StockToConcept getById(long id){
		return (StockToConcept) sessionFactory.getCurrentSession().createQuery("from StockToConcept u where u.id=?").setParameter(0, id).uniqueResult();
	}
	
	@Override
	public List<StockToConcept> getByStockId(String stockId) {
		return sessionFactory.getCurrentSession().createQuery("from StockToConcept u where u.stockId=?").setParameter(0, stockId).list();
	}
	
	@Override
	public List<StockToConcept> getAllRecords(){
		return sessionFactory.getCurrentSession().createQuery("from StockToConcept").list();
	}
	
	@Override
	public List<StockToConcept> getPageRecord(int pageIndex, int pageSize){
		return sessionFactory.getCurrentSession().createQuery("from StockToConcept").setFirstResult((pageIndex - 1) * pageSize).setMaxResults(pageSize).list();
	}
	
	
	
	@Override
	public long getRecordSize(){
		long size = (Long) sessionFactory.getCurrentSession().createQuery("select count(*) from ExecutiveToStock").uniqueResult();
		return size;
	}


	
	

}
