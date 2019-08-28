package com.demo.service;

import java.util.List;

import com.demo.bean.StockToIndustry;

public interface StockToIndustryService {

	public abstract void add(StockToIndustry s);

	public abstract StockToIndustry getById(long id);
	
	public abstract List<StockToIndustry> getByStockId(String stockId);

	public abstract List<StockToIndustry> getAllRecords();

	public abstract List<StockToIndustry> getPageRecord(int pageIndex, int pageSize);
	
	public abstract long getRecordSize();
	


}