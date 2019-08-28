package com.demo.service;

import java.util.List;

import com.demo.bean.Stock;

public interface StockService {

	public abstract void add(Stock s);

	public abstract Stock getById(long id);

	public abstract List<Stock> getAllRecords();

	public abstract List<Stock> getPageRecord(int pageIndex, int pageSize);
	
	public abstract long getRecordSize();
	


}