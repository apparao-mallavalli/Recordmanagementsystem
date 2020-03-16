package pdfconverter;

import java.io.FileInputStream;
import java.io.*;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.*;
import java.util.Iterator;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

public class PdfTwo
{  
        @SuppressWarnings("deprecation")
		public  void pdf(String path) throws Exception
        {

                FileInputStream input_document = new FileInputStream(new File(path));
                
                
                
                HSSFWorkbook my_xls_workbook = new HSSFWorkbook(input_document); 
                               
                
                HSSFSheet my_worksheet = my_xls_workbook.getSheetAt(0);
                
                
               
                Iterator<Row> rowIterator = my_worksheet.iterator();
                
                
                
                Document iText_xls_2_pdf = new Document();
                PdfWriter.getInstance(iText_xls_2_pdf, new FileOutputStream("C:\\Users\\malla\\Desktop\\worksheet.pdf"));
                iText_xls_2_pdf.open();
                
                
                PdfPTable my_table = new PdfPTable(5);
                                PdfPCell table_cell;
                //Loop through rows.
                while(rowIterator.hasNext()) {
                        Row row = rowIterator.next(); 
                        Iterator<Cell> cellIterator = row.cellIterator();
                                while(cellIterator.hasNext()) 
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