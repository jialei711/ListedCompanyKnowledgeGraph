package com.demo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.demo.bean.ExecutiveToStock;
import com.demo.service.ExecutiveToStockService;


@Transactional
public class ExecutiveToStockServiceImpl implements ExecutiveToStockService {
	
	@Resource private SessionFactory sessionFactory;
	
	@Override
	public void add(ExecutiveToStock s){
		sessionFactory.getCurrentSession().save(s);
	}
	
	
	@Override
	public ExecutiveToStock getById(long id){
		return (ExecutiveToStock) sessionFactory.getCurrentSession().createQuery("from ExecutiveToStock u where u.id=?").setParameter(0, id).uniqueResult();
	}
	
	@Override
	public List<ExecutiveToStock> getByIdExecutiveId(String executiveId) {
		return sessionFactory.getCurrentSession().createQuery("from ExecutiveToStock u where u.executiveId=?").setParameter(0, executiveId).list();
	}
	
	@Override
	public List<ExecutiveToStock> getAllRecords(){
		return sessionFactory.getCurrentSession().createQuery("from ExecutiveToStock").list();
	}
	
	@Override
	public List<ExecutiveToStock> getPageRecord(int pageIndex, int pageSize){
		return sessionFactory.getCurrentSession().createQuery("from ExecutiveToStock").setFirstResult((pageIndex - 1) * pageSize).setMaxResults(pageSize).list();
	}
	
	
	
	@Override
	public long getRecordSize(){
		long size = (Long) sessionFactory.getCurrentSession().createQuery("select count(*) from ExecutiveToStock").uniqueResult();
		return size;
	}


	
	

}
