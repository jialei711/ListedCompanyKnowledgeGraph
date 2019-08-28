package com.demo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.demo.bean.Industry;
import com.demo.service.IndustryService;


@Transactional
public class IndustryServiceImpl implements IndustryService {
	
	@Resource private SessionFactory sessionFactory;
	
	@Override
	public void add(Industry s){
		sessionFactory.getCurrentSession().save(s);
	}
	
	
	@Override
	public Industry getById(long id){
		return (Industry) sessionFactory.getCurrentSession().createQuery("from Industry u where u.id=?").setParameter(0, id).uniqueResult();
	}
	
	@Override
	public List<Industry> getAllRecords(){
		return sessionFactory.getCurrentSession().createQuery("from Industry").list();
	}
	
	@Override
	public List<Industry> getPageRecord(int pageIndex, int pageSize){
		return sessionFactory.getCurrentSession().createQuery("from Industry").setFirstResult((pageIndex - 1) * pageSize).setMaxResults(pageSize).list();
	}
	
	
	
	@Override
	public long getRecordSize(){
		long size = (Long) sessionFactory.getCurrentSession().createQuery("select count(*) from Industry").uniqueResult();
		return size;
	}
	

}
