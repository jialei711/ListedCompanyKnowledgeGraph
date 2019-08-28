package com.demo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.demo.bean.Stock;
import com.demo.service.StockService;


@Transactional
public class StockServiceImpl implements StockService {
	
	@Resource private SessionFactory sessionFactory;
	
	@Override
	public void add(Stock s){
		sessionFactory.getCurrentSession().save(s);
	}
	
	
	@Override
	public Stock getById(long id){
		return (Stock) sessionFactory.getCurrentSession().createQuery("from Stock u where u.id=?").setParameter(0, id).uniqueResult();
	}
	
	@Override
	public List<Stock> getAllRecords(){
		return sessionFactory.getCurrentSession().createQuery("from Stock").list();
	}
	
	@Override
	public List<Stock> getPageRecord(int pageIndex, int pageSize){
		return sessionFactory.getCurrentSession().createQuery("from Stock").setFirstResult((pageIndex - 1) * pageSize).setMaxResults(pageSize).list();
	}
	
	
	
	@Override
	public long getRecordSize(){
		long size = (Long) sessionFactory.getCurrentSession().createQuery("select count(*) from Stock").uniqueResult();
		return size;
	}
	

}
