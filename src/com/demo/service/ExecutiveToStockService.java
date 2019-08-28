package com.demo.service;

import java.util.List;

import com.demo.bean.ExecutiveToStock;

public interface ExecutiveToStockService {

	public abstract void add(ExecutiveToStock s);

	public abstract ExecutiveToStock getById(long id);
	
	public abstract List<ExecutiveToStock> getByIdExecutiveId(String executiveId);

	public abstract List<ExecutiveToStock> getAllRecords();

	public abstract List<ExecutiveToStock> getPageRecord(int pageIndex, int pageSize);
	
	public abstract long getRecordSize();
	


}