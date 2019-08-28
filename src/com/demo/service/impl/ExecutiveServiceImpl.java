package com.demo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.demo.bean.Executive;
import com.demo.service.ExecutiveService;


@Transactional
public class ExecutiveServiceImpl implements ExecutiveService {
	
	@Resource private SessionFactory sessionFactory;
	
	@Override
	public void add(Executive s){
		sessionFactory.getCurrentSession().save(s);
	}
	
	
	@Override
	public Executive getById(long id){
		return (Executive) sessionFactory.getCurrentSession().createQuery("from Executive u where u.id=?").setParameter(0, id).uniqueResult();
	}
	
	@Override
	public List<Executive> getAllRecords(){
		return sessionFactory.getCurrentSession().createQuery("from Executive").list();
	}
	
	@Override
	public List<Executive> getPageRecord(int pageIndex, int pageSize){
		return sessionFactory.getCurrentSession().createQuery("from Executive").setFirstResult((pageIndex - 1) * pageSize).setMaxResults(pageSize).list();
	}
	
	
	
	@Override
	public long getRecordSize(){
		long size = (Long) sessionFactory.getCurrentSession().createQuery("select count(*) from Executive").uniqueResult();
		return size;
	}
	

}
