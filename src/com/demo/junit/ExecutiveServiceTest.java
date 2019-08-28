package com.demo.junit;

import com.demo.bean.Executive;
import com.demo.service.ExecutiveService;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ExecutiveServiceTest {
	
	private static ExecutiveService executiveService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("/config/beans.xml");
		executiveService = (ExecutiveService) context.getBean("executiveService");
	}

	@Test
	public void add() {
		
		List<Executive> eList = new ArrayList<Executive>();
		
		try {    
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Administrator\\Desktop\\SecuritiesKnowlegeGraph-master\\SecuritiesKnowlegeGraph-master\\data\\executive2.txt"));//换成你的文件名   
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
                	Executive e = new Executive();
                	e.setName(item[0]);
                	e.setGender(item[1]);
                	e.setAge(item[2]);
                	e.setStockId(item[3]);
                	e.setPosition(item[4]);
                	e.setLabel(item[5]);
                	e.setPersonId(item[6]);
                	eList.add(e);
                }
               
            }    
        } catch (Exception e) {    
            e.printStackTrace();    
        }    
	
		for(Executive s : eList){
			System.out.println(s.toString());
			executiveService.add(s);
		}
		
		
	}
	
	
	@Test
	public void query(){
		
		List<Executive> sList = executiveService.getAllRecords();
		for(Executive s : sList){
			System.out.println(s.toString());
		}
		
	}
	
	@Test
	public void pageQuery(){
		
		
	}

}
