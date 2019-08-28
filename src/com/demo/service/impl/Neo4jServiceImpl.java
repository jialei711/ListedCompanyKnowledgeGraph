package com.demo.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.bean.Concept;
import com.demo.bean.Executive;
import com.demo.bean.ExecutiveToStock;
import com.demo.bean.Industry;
import com.demo.bean.Stock;
import com.demo.bean.StockToConcept;
import com.demo.bean.StockToIndustry;
import com.demo.model.Constant;
import com.demo.model.MyLabel;
import com.demo.model.StockRelation;
import com.demo.service.ExecutiveToStockService;
import com.demo.service.StockToConceptService;
import com.demo.service.StockToIndustryService;

public class Neo4jServiceImpl implements com.demo.service.Neo4jService {

	private GraphDatabaseService graphDB;
	private  ExecutiveToStockService executiveToStockService;
	private StockToConceptService stockToConceptService;
	private StockToIndustryService stockToIndustryService; 
	
	public Neo4jServiceImpl() {
		
		 GraphDatabaseFactory dbFactory = new GraphDatabaseFactory();
		 graphDB = dbFactory.newEmbeddedDatabase(Constant.path);
		
		 ApplicationContext context = new ClassPathXmlApplicationContext("/config/beans.xml");
		 executiveToStockService = (ExecutiveToStockService) context.getBean("executiveToStockService");
	     stockToConceptService = (StockToConceptService) context.getBean("stockToConceptService");
		 stockToIndustryService = (StockToIndustryService) context.getBean("stockToIndustryService");
		 System.out.println("---------------------实例化---------------------");
	}



	@Override
	public void createNode(List<Concept> conceptList, List<Executive> executiveList, List<Industry> industryList, List<Stock> stockList, List<ExecutiveToStock> executiveToStockList, List<StockToConcept> stockToConceptList, List<StockToIndustry> stockToIndustryList) {
		
		
		Transaction tx = graphDB.beginTx();
		
		for(Concept cpt : conceptList){
			
			System.out.println(cpt.toString());
			
			Node conceptNode = graphDB.createNode(new MyLabel(Constant.GarphName));
			conceptNode.setProperty("Itemid", String.valueOf(cpt.getId()));
			conceptNode.setProperty("conceptName", cpt.getConceptName());
			conceptNode.setProperty("conceptId", cpt.getConceptId());
			conceptNode.setProperty("label", cpt.getLabel());
			
			
			
		}
		
		for(Industry ity : industryList){
			
			System.out.println(ity.toString());
			
			Node industryNode = graphDB.createNode(new MyLabel(Constant.GarphName));
			industryNode.setProperty("Itemid", String.valueOf(ity.getId()));
			industryNode.setProperty("industryName", ity.getIndustryName());
			industryNode.setProperty("label", ity.getLabel());
			industryNode.setProperty("industryId", ity.getIndustryId());
			
		}
		
		
		for(Stock s : stockList){
			System.out.println(s.toString());
			
			Node industryNode = graphDB.createNode(new MyLabel(Constant.GarphName));
			industryNode.setProperty("Itemid", String.valueOf(s.getId()));
			industryNode.setProperty("stockId", s.getStockId());
			industryNode.setProperty("stockName", s.getStockName());
			industryNode.setProperty("label", s.getLabel());
		}
		
		
		for(Executive et : executiveList){
			System.out.println(et.toString());
			
			Node executiveNode = graphDB.createNode(new MyLabel(Constant.GarphName));
			executiveNode.setProperty("Itemid", String.valueOf(et.getId()));
			executiveNode.setProperty("name", et.getName());
			executiveNode.setProperty("gender", et.getGender());
			executiveNode.setProperty("age", et.getAge());
			executiveNode.setProperty("stockId", et.getStockId());
			executiveNode.setProperty("position", et.getPosition());
			executiveNode.setProperty("label", et.getLabel());
			executiveNode.setProperty("personId", et.getPersonId());
			
		}
		
		tx.success();
	    tx.close();
	}



	@Override
	public void queryAll(String stype) {
		
		Transaction tx = graphDB.beginTx();
		  Iterator<Node> nodeList = graphDB.findNodes(new MyLabel(Constant.GarphName));
		  while(nodeList.hasNext()){
			  Node node = nodeList.next();
			 
			  String type = (String) node.getProperty("label");
			  if(type.equals(stype)){
				  Map<String, Object> properties = node.getAllProperties();
				  for(Map.Entry<String, Object> property : properties.entrySet()){
					  System.out.println(property.getKey()+" : "+property.getValue());
				  }
				  System.out.println("--------------------------------------------------");
			  }
			  
		  }
		  tx.success();
	      tx.close();
		
	}



	@Override
	public void createRelation() {
		
		  Transaction tx = graphDB.beginTx();
		  Iterator<Node> nodeList = graphDB.findNodes(new MyLabel(Constant.GarphName));
		  
		  List<Node> executiveList = new ArrayList<Node>();//存储人节点的集合
		  List<Node> stockList = new ArrayList<Node>();//存储股票节点的集合
		  List<Node> conceptList = new ArrayList<Node>();//存储概念节点的集合
		  List<Node> industryList = new ArrayList<Node>();//存储行业节点的集合
		  
		  while(nodeList.hasNext()){
			  Node node = nodeList.next();
			  String type = (String) node.getProperty("label");
			  if(type.equals("行业")){
				  industryList.add(node);
			  }else if(type.equals("概念")){
				  conceptList.add(node);
			  }else if(type.equals("人")){
				  executiveList.add(node); 
			  }else if(type.equals("股票")){
				  stockList.add(node);
			  }
		  }
		  
		  
		  for(Node node : executiveList){
			  
			  String executiveId = (String) node.getProperty("personId");
			  List<ExecutiveToStock>  etsList = executiveToStockService.getByIdExecutiveId(executiveId);
			  for(ExecutiveToStock ets : etsList){
				  if(ets != null){

					    String stockId = ets.getStockId();
					    for(Node snode : stockList){
					    	
					    	String nodeStockId = (String) snode.getProperty("stockId");
					    	if(stockId.equals(nodeStockId)){
					    		node.createRelationshipTo(snode, StockRelation.WORKIN);
					    	}
					    }
				  }
			  }
			 
		  }
		  
		  for(Node snode : stockList){
			  
			  String nodeStockId = (String) snode.getProperty("stockId");
			  List<StockToConcept>  stcList = stockToConceptService.getByStockId(nodeStockId);
			  for(StockToConcept stc : stcList){
				  if(stc != null){
					  
					  String conceptId = stc.getConceptId();
					  for(Node cptNode : conceptList){
						  String nodeCptId = (String) cptNode.getProperty("conceptId");
						  if(conceptId.equals(nodeCptId)){
							  snode.createRelationshipTo(cptNode, StockRelation.BELONGTO);
						  }
					  }
				  }
			  }
			  
		  }
		  
		  for(Node snode : stockList){
			  
			  String nodeStockId = (String) snode.getProperty("stockId");
			  List<StockToIndustry> stiList = stockToIndustryService.getByStockId(nodeStockId);
			  for(StockToIndustry sti : stiList){
				  if(sti != null){
					   String industryId = sti.getIndustryId();
					   for(Node idsNode : industryList){
						   
						   String nodeIndustryId = (String) idsNode.getProperty("industryId");
						   if(industryId.equals(nodeIndustryId)){
							   snode.createRelationshipTo(idsNode, StockRelation.BELONGTO);
						   }
					   }
				  }
			  }
		  }
		  
		  
		  tx.success();
	      tx.close();
		
	}



	@Override
	public void test() {
		
		List<ExecutiveToStock> etsList = executiveToStockService.getAllRecords();
		for(ExecutiveToStock ets : etsList){
			System.out.println(ets.toString());
			
		}
		
	}

}
