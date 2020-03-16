package exceloperations;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;


import service.Student;

public class StudentFile
{
	@SuppressWarnings("null")
	public ArrayList<Student> read(String excelFilePath) throws IOException 
	{
	  ArrayList<Student> list=new ArrayList<Student>();
	  FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
	  HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
	  HSSFSheet firstSheet = workbook.getSheetAt(0);
	  Iterator<Row> iterator = firstSheet.iterator();
	  
	  while (iterator.hasNext())
	  {  
	        Row nextRow = iterator.next();
	        Iterator<Cell> cellIterator = nextRow.cellIterator();
	        String id=null; String name=null; int lab[] = new int[5];int  project[]=new int[5];int total[]=new int[5];int grandTotal=0;
	        int i=0,j=0,k=0;
	        while (cellIterator.hasNext()) 
	        {
	            Cell nextCell = cellIterator.next();
	            int columnIndex = nextCell.getColumnIndex()+1;
	            //System.out.println(columnIndex);
	            if(columnIndex<6)
	            {
	            switch (columnIndex)
	            {
	             case 1:  id= (String)nextCell.getStringCellValue();
	                       
	                      break;
	                      
	             case 2:   name=(String) nextCell.getStringCellValue();
	                      
	                      break;
	                      
	             case 3:  lab[i] = (int) nextCell.getNumericCellValue(); 
	                       i++;
	                       break;
	                     
	             case 4:   project[j]=(int)  nextCell.getNumericCellValue(); 
	                        j++;
	                       break;
	                       
	             case 5 :   total[k] = (int) nextCell.getNumericCellValue();
	                        k++;
	                        break;
	              }
	 
	         } 
	            else if(columnIndex==18)
	            grandTotal= (int) nextCell.getNumericCellValue();
	        
	        else
	        {
	        	columnIndex=columnIndex%3;
	        	if(columnIndex==0)
	        	{
	        		lab[i] = (int) nextCell.getNumericCellValue(); 
                    i++;
	        		
	        	}
	        	else if(columnIndex==1)
	        	{
	        		project[j]=(int)  nextCell.getNumericCellValue(); 
                    j++;
	        		
	        	}
	        	else
	        	{
	        		 total[k] = (int) nextCell.getNumericCellValue();
                     k++;
	        
	        	}	
	        }
	     }       
	        
	        Student student=new Student(id,name,lab,project,total,grandTotal);
	        list.add(student);
	  
	  }	  
	
	  return list;
    }
}
