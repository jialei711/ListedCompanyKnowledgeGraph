package com.demo.junit;

import com.demo.bean.Stock;
import com.demo.service.StockService;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class StockServiceTest {
	
	private static StockService stockService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("/config/beans.xml");
		stockService = (StockService) context.getBean("stockService");
	}

	@Test
	public void add() {
		
		List<Stock> stockList = new ArrayList<Stock>();
		
		try {    
            BufferedReader reader = new BufferedReader(new FileReader("E:\\github\\python\\KnowlegeGraph-collections\\SecuritiesKnowlegeGraph\\data\\stock.txt"));
            reader.readLine();
            String line = null;    
            while((line=reader.readLine())!=null){ 
            	
//            	String value = new String(line.getBytes("GBK"), "UTF-8");
                String item[] = line.split(",");
                
                if(!line.contains("\"")){
//                	 for(String s : item){
//     	             	System.out.print(s+" ");
//     	             }
//     	             System.out.println("");
                	Stock stock = new Stock();
                	stock.setStockId(item[0]);
                	stock.setStockName(item[1]);
                	stock.setLabel(item[2]);
                	stockList.add(stock);
                }
               
            }    
        } catch (Exception e) {    
            e.printStackTrace();    
        }    
	
		for(Stock s : stockList){
			System.out.println(s.toString());
			stockService.add(s);
		}
		
		
	}
	
	
	@Test
	public void query(){
		
		List<Stock> sList = stockService.getAllRecords();
		for(Stock s : sList){
			System.out.println(s.toString());
		}
		
	}
	
	@Test
	public void pageQuery(){
		
		long size = stockService.getRecordSize();
		System.out.println(size);
	}

}
