package com.demo.junit;

import com.demo.bean.StockToIndustry;
import com.demo.service.StockToIndustryService;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class StockToIndustryServiceTest {
	
	private static StockToIndustryService stockToIndustryService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("/config/beans.xml");
		stockToIndustryService = (StockToIndustryService) context.getBean("stockToIndustryService");
	}

	@Test
	public void add() {
		
		List<StockToIndustry> eList = new ArrayList<StockToIndustry>();
		
		try {    
            BufferedReader reader = new BufferedReader(new FileReader("E:\\github\\python\\KnowlegeGraph-collections\\SecuritiesKnowlegeGraph\\data\\stockToIndustry.txt"));
            reader.readLine();
            String line = null;    
            while((line=reader.readLine())!=null){ 
            	
//            	String value = new String(line.getBytes("GBK"), "UTF-8");
                String item[] = line.split(",");//CSV��ʽ�ļ�Ϊ���ŷָ����ļ���������ݶ����з�   
                
                if(!line.contains("\"")){
                	 for(String s : item){
     	             	System.out.print(s+" ");
     	             }
     	             System.out.println("");
     	            StockToIndustry c = new StockToIndustry();
                	c.setStockId(item[0]);
                	c.setIndustryId(item[1]);
                	c.setRelation(item[2]);
                	eList.add(c);
                }
               
            }    
        } catch (Exception e) {    
            e.printStackTrace();    
        }    
	
		for(StockToIndustry s : eList){
			System.out.println(s.toString());
			stockToIndustryService.add(s);
		}
		
		
	}
	
	
	@Test
	public void query(){
		
		List<StockToIndustry> sList = stockToIndustryService.getAllRecords();
		for(StockToIndustry s : sList){
			System.out.println(s.toString());
		}
		
	}
	
	@Test
	public void getById(){
		
		List<StockToIndustry> eList = stockToIndustryService.getByStockId("");
		System.out.println(eList.toString());
	}
	


}
