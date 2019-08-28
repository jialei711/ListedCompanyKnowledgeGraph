package com.demo.service;

import java.util.List;

import com.demo.bean.Industry;

public interface IndustryService {

	public abstract void add(Industry s);

	public abstract Industry getById(long id);

	public abstract List<Industry> getAllRecords();

	public abstract List<Industry> getPageRecord(int pageIndex, int pageSize);
	
	public abstract long getRecordSize();
	


}