package pdfconverter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.itextpdf.text.DocumentException;

import service.Student;

public class ExcelCreateOne
{
	public void create(ArrayList<ExcelOne> list,String path) throws IOException, DocumentException
	{
		FileOutputStream out = null;
         try 
         {
			
			
			 HSSFWorkbook workbook=new HSSFWorkbook();
			 
			 HSSFSheet sheet = workbook.createSheet("ProGrad Details");
			
			 HSSFRow hRow=sheet.createRow(0);
			 
			  hRow.createCell(0).setCellValue("Prograd ID");
			  hRow.createCell(1).setCellValue("Name");
			  hRow.createCell(2).setCellValue("Marks");
			 
			  int i=0;
			  for(ExcelOne prograd1 :list)
			  {
				  int j=i+1;
				  HSSFRow hrow = sheet.createRow(j);
				  hrow.createCell( 0).setCellValue(prograd1.getId());
					hrow.createCell( 1).setCellValue(prograd1.getName());
					hrow.createCell(2).setCellValue(prograd1.getMarks());
	
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
         PdfOne pt=new PdfOne();
         pt.pdf(path);
		
	}

}
