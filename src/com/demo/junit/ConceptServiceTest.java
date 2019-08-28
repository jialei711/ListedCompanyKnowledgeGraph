package com.demo.junit;

import com.demo.bean.Concept;
import com.demo.service.ConceptService;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ConceptServiceTest {
	
	private static ConceptService conceptService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("/config/beans.xml");
		conceptService = (ConceptService) context.getBean("conceptService");
	}

	@Test
	public void add() {
		
		List<Concept> eList = new ArrayList<Concept>();
		
		try {    
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Administrator\\Desktop\\SecuritiesKnowlegeGraph-master\\SecuritiesKnowlegeGraph-master\\data\\concept.txt"));//换成你的文件名   
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
     	            Concept c = new Concept();
                	c.setConceptName(item[0]);
                	c.setConceptId(item[1]);
                	c.setLabel(item[2]);
                	eList.add(c);
                }
               
            }    
        } catch (Exception e) {    
            e.printStackTrace();    
        }    
	
		for(Concept s : eList){
			System.out.println(s.toString());
			conceptService.add(s);
		}
		
		
	}
	
	
	@Test
	public void query(){
		
		List<Concept> sList = conceptService.getAllRecords();
		for(Concept s : sList){
			System.out.println(s.toString());
		}
		
	}
	
	@Test
	public void pageQuery(){
		
		
	}

}
