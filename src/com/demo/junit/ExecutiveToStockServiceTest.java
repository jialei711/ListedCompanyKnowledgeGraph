package com.demo.junit;

import com.demo.bean.ExecutiveToStock;
import com.demo.service.ExecutiveToStockService;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ExecutiveToStockServiceTest {
	
	private static ExecutiveToStockService executiveToStockService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("/config/beans.xml");
		executiveToStockService = (ExecutiveToStockService) context.getBean("executiveToStockService");
	}

	@Test
	public void add() {
		
		List<ExecutiveToStock> eList = new ArrayList<ExecutiveToStock>();
		
		try {    
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Administrator\\Desktop\\SecuritiesKnowlegeGraph-master\\SecuritiesKnowlegeGraph-master\\data\\executiveToStock.txt"));//换成你的文件名   
            reader.readLine();//第一行信息，为标题信息，不用,如果需要，注释掉   
            String line = null;    
            while((line=reader.readLine())!=null){ 
            	
//            	String value = new String(line.getBytes("GBK"), "UTF-8");
                String item[] = line.split(",");//CSV格式文件为逗号分隔符文件，这里根据逗号切分   
                
                if(!line.contains("\"")){
                	 for(String s : item){
     	             	System.out.print(s+" ");
     	             }
     	             System.out.println("");
     	            ExecutiveToStock c = new ExecutiveToStock();
                	c.setExecutiveId(item[0]);
                	c.setStockId(item[1]);
                	c.setRelation(item[2]);
                	eList.add(c);
                }
               
            }    
        } catch (Exception e) {    
            e.printStackTrace();    
        }    
	
		for(ExecutiveToStock s : eList){
			System.out.println(s.toString());
			executiveToStockService.add(s);
		}
		
		
	}
	
	
	@Test
	public void query(){
		
		List<ExecutiveToStock> sList = executiveToStockService.getAllRecords();
		for(ExecutiveToStock s : sList){
			System.out.println(s.toString());
		}
		
	}
	
	@Test
	public void getById(){
		
//		ExecutiveToStock e = executiveToStockService.getByIdExecutiveId("1000010");
//		System.out.println(e.toString());
	}
	
	@Test
	public void pageQuery(){
		
		
	}

}
