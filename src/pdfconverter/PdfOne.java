package pdfconverter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.apache.poi.hssf.converter.ExcelToHtmlConverter;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class PdfOne {
	static int i=1;

	public  void pdf(String path) throws IOException, DocumentException
	{
		
		 FileInputStream input_document = new FileInputStream(new File(path));
         // Read workbook into HSSFWorkbook
         HSSFWorkbook my_xls_workbook = new HSSFWorkbook(input_document); 
         // Read worksheet into HSSFSheet
         HSSFSheet my_worksheet = my_xls_workbook.getSheetAt(0); 
         // To iterate over the rows
         java.util.Iterator<Row> rowIterator = my_worksheet.iterator();
         //We will create output PDF document objects at this point
         Document iText_xls_2_pdf = new Document();
         if(i==1)
         {
         PdfWriter.getInstance(iText_xls_2_pdf, new FileOutputStream("C:\\Users\\malla\\Desktop\\first.pdf"));
         i++;
         }
         else if(i==2)
         {
        	 PdfWriter.getInstance(iText_xls_2_pdf, new FileOutputStream("C:\\Users\\malla\\Desktop\\second.pdf"));
        	 i++;
         }
         else
         {
        	 PdfWriter.getInstance(iText_xls_2_pdf, new FileOutputStream("C:\\Users\\malla\\Desktop\\third.pdf"));
        	 i=1;
         }
        	 
        
         iText_xls_2_pdf.open();
         //we have two columns in the Excel sheet, so we create a PDF table with two columns
         //Note: There are ways to make this dynamic in nature, if you want to.
         PdfPTable my_table = new PdfPTable(3);
         //We will use the object below to dynamically add new data to the table
         PdfPCell table_cell;
         //Loop through rows.
         while(rowIterator.hasNext()) {
             Row row = rowIterator.next(); 
             java.util.Iterator<Cell> cellIterator = row.cellIterator();
                     while(((java.util.Iterator<Cell>) cellIterator).hasNext()) 
                     {
                     	//int columnIndex = cell.getColumnIndex()+1;
                             Cell cell = cellIterator.next(); 
                             
                             	
                             	
                                                                    
                              table_cell=new PdfPCell(new Phrase(cell.getStringCellValue()));
                                       my_table.addCell(table_cell);
                                                                                
                         }
         
         }
         //Finally add the table to PDF document
         iText_xls_2_pdf.add(my_table);                       
         iText_xls_2_pdf.close();                
         //we created our pdf file..
         input_document.close(); //close xls
	}
}