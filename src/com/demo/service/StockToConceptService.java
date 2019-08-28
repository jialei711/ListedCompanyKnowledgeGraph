package com.demo.service;

import java.util.List;

import com.demo.bean.StockToConcept;

public interface StockToConceptService {

	public abstract void add(StockToConcept s);

	public abstract StockToConcept getById(long id);
	
	public abstract List<StockToConcept> getByStockId(String stockId);

	public abstract List<StockToConcept> getAllRecords();

	public abstract List<StockToConcept> getPageRecord(int pageIndex, int pageSize);
	
	public abstract long getRecordSize();
	


}