package com.demo.junit;

import com.demo.bean.*;
import com.demo.service.*;
import com.demo.service.impl.Neo4jServiceImpl;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Neo4jServiceTest {

	
	private static ConceptService conceptService;
	private static ExecutiveService executiveService;
	private static IndustryService industryService;
	private static StockService stockService;
	private static ExecutiveToStockService executiveToStockService;
	private static StockToConceptService stockToConceptService;
	private static StockToIndustryService stockToIndustryService;

	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("/config/beans.xml");
		
		conceptService = (ConceptService) context.getBean("conceptService");
		executiveService = (ExecutiveService) context.getBean("executiveService");
		industryService = (IndustryService) context.getBean("industryService");
		stockService = (StockService) context.getBean("stockService");
		executiveToStockService = (ExecutiveToStockService) context.getBean("executiveToStockService");
		stockToConceptService = (StockToConceptService) context.getBean("stockToConceptService");
		stockToIndustryService = (StockToIndustryService) context.getBean("stockToIndustryService");
	}
	
	@Test
	public void createNode() {
		
		List<Concept> conceptList = conceptService.getAllRecords();
		List<Executive> executiveList = executiveService.getAllRecords();
		List<Industry> industryList = industryService.getAllRecords();
		List<Stock> stockList = stockService.getAllRecords();
		List<ExecutiveToStock> executiveToStockList = executiveToStockService.getAllRecords();
		List<StockToConcept> stockToConceptList = stockToConceptService.getAllRecords();
		List<StockToIndustry> stockToIndustryList = stockToIndustryService.getAllRecords();
		
		Neo4jService neo4jService = new Neo4jServiceImpl();
		neo4jService.createNode(conceptList, executiveList, industryList, stockList, executiveToStockList, stockToConceptList, stockToIndustryList);
		
	}
	
	@Test
	public void createRelation(){
		Neo4jService neo4jService = new Neo4jServiceImpl();
		neo4jService.createRelation();
	}
	
	@Test
	public void queryAll(){
		
		Neo4jService neo4jService = new Neo4jServiceImpl();
		neo4jService.queryAll("行业");
	}

	@Test
	public void test(){
		
		Neo4jService neo4jService = new Neo4jServiceImpl();
		neo4jService.test();
	}

	@Test
	public void testStock(){
		Neo4jServiceImpl neo4jService = new Neo4jServiceImpl();
		neo4jService.queryAll("股票");
	}
}
