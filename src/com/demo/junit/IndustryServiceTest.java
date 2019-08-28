package com.demo.junit;

import com.demo.bean.Industry;
import com.demo.service.IndustryService;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class IndustryServiceTest {

	private static IndustryService industryService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

		ApplicationContext context = new ClassPathXmlApplicationContext("/config/beans.xml");
		industryService = (IndustryService) context.getBean("industryService");
	}

	@Test
	public void add() {

		List<Industry> eList = new ArrayList<Industry>();

		try {
			//使用IO读取名为industry的csv文件
			BufferedReader reader = new BufferedReader(new FileReader("E:\\github\\python\\KnowlegeGraph-collections\\SecuritiesKnowlegeGraph\\data\\industry.csv"));
			//BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Administrator\\Desktop\\SecuritiesKnowlegeGraph-master\\SecuritiesKnowlegeGraph-master\\data\\industry.txt"));//��������ļ���
			reader.readLine();
			String line = null;
			while((line=reader.readLine())!=null){

//            	String value = new String(line.getBytes("GBK"), "UTF-8");
				String item[] = line.split(",");  //CSV使用逗号分隔

				if(!line.contains("\"")){
					for(String s : item){
						System.out.print(s+" ");
					}
					System.out.println("");
					Industry c = new Industry();
					c.setIndustryName(item[0]);
					c.setLabel(item[1]);
					c.setIndustryId(item[2]);
					eList.add(c);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		for(Industry s : eList){
			System.out.println(s.toString());
			industryService.add(s);
		}


	}


	@Test
	public void query(){

		List<Industry> sList = industryService.getAllRecords();
		for(Industry s : sList){
			System.out.println(s.toString());
		}

	}

	@Test
	public void pageQuery(){


	}

}
