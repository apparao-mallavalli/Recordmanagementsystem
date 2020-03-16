package pdfconverter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelCreateTwo 
{
	public void create(ArrayList<ExcelTwo> list,String path) throws Exception
	{
		FileOutputStream out = null;
         try 
         {
			
			//object of HSSFWorkbook class
			 HSSFWorkbook workbook=new HSSFWorkbook();
			 //creation of sheet
			 HSSFSheet sheet = workbook.createSheet("ProGrad Details");
			 //creating a row head
			 HSSFRow hRow=sheet.createRow(0);
			 //create a columns
			  hRow.createCell(0).setCellValue("Prograd ID");
			  hRow.createCell(1).setCellValue("Name");
			  hRow.createCell(2).setCellValue("Lab");
			  hRow.createCell(3).setCellValue("Project");
			  hRow.createCell(4).setCellValue("Total");
			  
			 
			   
			  //reading inputs from list and adding to each row 
			  
			  int i=0;
			  for(ExcelTwo prograd1 :list)
			  {
				  int j=i+1;
				  HSSFRow hrow = sheet.createRow(j);
				    hrow.createCell( 0).setCellValue(prograd1.getId());
					hrow.createCell( 1).setCellValue(prograd1.getName());
					hrow.createCell(2).setCellValue(prograd1.getLab());
					hrow.createCell(3).setCellValue(prograd1.getProject());
					hrow.createCell(4).setCellValue(prograd1.getTotal());
					
	
					i++;
			  }
			
			 out = new FileOutputStream(path);
			workbook.write(out);
		
			
			}
		catch (Exception e) {
				e.printStackTrace();
			}
		finally 
		{
			out.close();
		}
         PdfTwo pt=new PdfTwo();
         pt.pdf(path);
         
		
		
	}

}
