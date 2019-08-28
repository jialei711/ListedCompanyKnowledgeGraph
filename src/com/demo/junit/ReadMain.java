package com.demo.junit;

import java.io.BufferedReader;
import java.io.FileReader;

public class ReadMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {    
            BufferedReader reader = new BufferedReader(new FileReader("E:\\github\\python\\KnowlegeGraph-collections\\SecuritiesKnowlegeGraph\\data\\stock.csv"));
            reader.readLine();
            String line = null;    
            while((line=reader.readLine())!=null){ 
            	
            	String value = new String(line.getBytes("GBK"), "UTF-8");
                String item[] = value.split(",");

                if(!value.contains("?")){
                	 for(String s : item){
     	             	System.out.print(s+" ");
     	             }
     	             System.out.println("");
                }
               
            }    
        } catch (Exception e) {    
            e.printStackTrace();    
        }    
		

	}

}
