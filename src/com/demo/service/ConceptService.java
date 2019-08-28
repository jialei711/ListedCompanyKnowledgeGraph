package com.demo.service;

import java.util.List;

import com.demo.bean.Concept;

public interface ConceptService {

	public abstract void add(Concept s);

	public abstract Concept getById(long id);

	public abstract List<Concept> getAllRecords();

	public abstract List<Concept> getPageRecord(int pageIndex, int pageSize);
	
	public abstract long getRecordSize();
	


}