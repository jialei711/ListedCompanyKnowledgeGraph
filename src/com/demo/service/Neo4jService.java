package com.demo.service;

import com.demo.bean.*;

import java.util.List;

public interface Neo4jService {
	
	public abstract void createNode(List<Concept> conceptList, List<Executive> executiveList, List<Industry> industryList, List<Stock> stockList, List<ExecutiveToStock> executiveToStockList, List<StockToConcept> stockToConceptList, List<StockToIndustry> stockToIndustryList);
	
	public abstract void queryAll(String type);
	
	public abstract void createRelation();
	
	public abstract void test();
	
	
}
