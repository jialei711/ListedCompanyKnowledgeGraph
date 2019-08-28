package com.demo.service;

import java.util.List;

import com.demo.bean.Executive;

public interface ExecutiveService {

	public abstract void add(Executive s);

	public abstract Executive getById(long id);

	public abstract List<Executive> getAllRecords();

	public abstract List<Executive> getPageRecord(int pageIndex, int pageSize);
	
	public abstract long getRecordSize();
	


}