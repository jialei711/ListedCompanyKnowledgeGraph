package com.demo.junit;

import com.demo.bean.StockToConcept;
import com.demo.service.StockToConceptService;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class StockToConceptServiceTest {
	
	private static StockToConceptService stockToConceptService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("/config/beans.xml");
		stockToConceptService = (StockToConceptService) context.getBean("stockToConceptService");
	}

	@Test
	public void add() {
		
		List<StockToConcept> eList = new ArrayList<StockToConcept>();
		
		try {    
            BufferedReader reader = new BufferedReader(new FileReader("E:\\github\\python\\KnowlegeGraph-collections\\SecuritiesKnowlegeGraph\\data\\stockToConcept.txt"));
            reader.readLine();
            String line = null;    
            while((line=reader.readLine())!=null){ 
            	
//            	String value = new String(line.getBytes("GBK"), "UTF-8");
                String item[] = line.split(",");
                
                if(!line.contains("\"")){
                	 for(String s : item){
     	             	System.out.print(s+" ");
     	             }
     	             System.out.println("");
     	            StockToConcept c = new StockToConcept();
                	c.setStockId(item[0]);
                	c.setConceptId(item[1]);
                	c.setRelation(item[2]);
                	eList.add(c);
                }
               
            }    
        } catch (Exception e) {    
            e.printStackTrace();    
        }    
	
		for(StockToConcept s : eList){
			System.out.println(s.toString());
			stockToConceptService.add(s);
		}
		
		
	}
	
	
	@Test
	public void query(){
		
		List<StockToConcept> sList = stockToConceptService.getAllRecords();
		for(StockToConcept s : sList){
			System.out.println(s.toString());
		}
		
	}
	
	@Test
	public void getById(){
		
//		StockToConcept e = stockToConceptService.getByStockId("");
//		System.out.println(e.toString());
	}
	


}
