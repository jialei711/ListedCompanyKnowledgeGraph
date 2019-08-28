package com.demo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.demo.bean.Concept;
import com.demo.service.ConceptService;


@Transactional
public class ConceptServiceImpl implements ConceptService {
	
	@Resource private SessionFactory sessionFactory;
	
	@Override
	public void add(Concept s){
		sessionFactory.getCurrentSession().save(s);
	}
	
	
	@Override
	public Concept getById(long id){
		return (Concept) sessionFactory.getCurrentSession().createQuery("from Concept u where u.id=?").setParameter(0, id).uniqueResult();
	}
	
	@Override
	public List<Concept> getAllRecords(){
		return sessionFactory.getCurrentSession().createQuery("from Concept").list();
	}
	
	@Override
	public List<Concept> getPageRecord(int pageIndex, int pageSize){
		return sessionFactory.getCurrentSession().createQuery("from Concept").setFirstResult((pageIndex - 1) * pageSize).setMaxResults(pageSize).list();
	}
	
	
	
	@Override
	public long getRecordSize(){
		long size = (Long) sessionFactory.getCurrentSession().createQuery("select count(*) from Concept").uniqueResult();
		return size;
	}
	

}
