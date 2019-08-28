package com.demo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.demo.bean.StockToIndustry;
import com.demo.service.StockToIndustryService;


@Transactional
public class StockToIndustryServiceImpl implements StockToIndustryService {
	
	@Resource private SessionFactory sessionFactory;
	
	@Override
	public void add(StockToIndustry s){
		sessionFactory.getCurrentSession().save(s);
	}
	
	
	@Override
	public StockToIndustry getById(long id){
		return (StockToIndustry) sessionFactory.getCurrentSession().createQuery("from StockToIndustry u where u.id=?").setParameter(0, id).uniqueResult();
	}
	
	@Override
	public List<StockToIndustry> getByStockId(String stockId) {
		return sessionFactory.getCurrentSession().createQuery("from StockToIndustry u where u.stockId=?").setParameter(0, stockId).list();
	}
	
	@Override
	public List<StockToIndustry> getAllRecords(){
		return sessionFactory.getCurrentSession().createQuery("from StockToIndustry").list();
	}
	
	@Override
	public List<StockToIndustry> getPageRecord(int pageIndex, int pageSize){
		return sessionFactory.getCurrentSession().createQuery("from StockToIndustry").setFirstResult((pageIndex - 1) * pageSize).setMaxResults(pageSize).list();
	}
	
	
	
	@Override
	public long getRecordSize(){
		long size = (Long) sessionFactory.getCurrentSession().createQuery("select count(*) from StockToIndustry").uniqueResult();
		return size;
	}


	
	

}
