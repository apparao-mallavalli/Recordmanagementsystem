package BusinessLogic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.itextpdf.text.DocumentException;

import pdfconverter.ExcelCreateOne;
import pdfconverter.ExcelCreateTwo;
import pdfconverter.ExcelOne;
import pdfconverter.ExcelTwo;
import service.Student;

public class BusinessOperations 
{ 
	String first=  "C:\\Users\\malla\\Desktop\\first.xls";
	String two  =  "C:\\Users\\malla\\Desktop\\two.xls";
	String three=  "C:\\Users\\malla\\Desktop\\three.xls";
	String day  =  "C:\\Users\\malla\\Desktop\\day.xls";
  Print p=new Print();
	ExcelCreateOne eco=new ExcelCreateOne();
	ExcelCreateTwo ect=new ExcelCreateTwo();
	public void sortByRank(ArrayList<Student> list)
	{
		Collections.sort(list,(Student s1,Student s2)->s1.getGrandTotal()-s2.getGrandTotal());
		p.print(list);
		
	}
	
	
	public void sortById(ArrayList<Student> list)
	{
		Collections.sort(list,(Student s1,Student s2)->s1.getId().compareTo(s2.getId()));
		p.print(list);
	
	}
	
	
	public void sortByName(ArrayList<Student> list)
	{
		Collections.sort(list,(Student s1,Student s2)->s1.getName().compareTo(s2.getName()));
		p.print(list);
	
	}
	
	public void sortByDayProject(ArrayList<Student> list,int k) throws IOException, DocumentException
	{
		ArrayList<ExcelOne> alist=new ArrayList<ExcelOne>();
		ArrayList<ExcelOne> alist2=new ArrayList<ExcelOne>();
		ArrayList<ExcelOne> alist3=new ArrayList<ExcelOne>();
	
		System.out.println("Details for who completed all the projects of day "+(k+1));
		for(Student s:list)
		{
			int a[]=s.getProject();
			if(a[k]>=9)
			{
				System.out.println(s.getId()+"\t"+s.getName()+"\t"+"\t"+a[k]+"\t");
				ExcelOne eo=new ExcelOne(s.getId(),s.getName(),String.valueOf(a[k]));
				alist.add(eo);
			}
			
		}
		eco.create(alist, first);
		
		System.out.println("");
		System.out.println("Details of student who complted greater than  and equals to half  projects in day "+(k+1));
		for(Student s:list)
		{
			int a[]=s.getProject();
			if(a[k]>=5&&a[k]<9)
			{
				System.out.println(s.getId()+"\t"+s.getName()+"\t"+"\t"+a[k]);
				ExcelOne eo=new ExcelOne(s.getId(),s.getName(),String.valueOf(a[k]));
				alist2.add(eo);
			}
			
		}
		eco.create(alist2, two);
		System.out.println("");
		System.out.println("Details of student who doesn't completed  projects in day "+(k+1));
		for(Student s:list)
		{
			int a[]=s.getProject();
			if(a[k]<5)
			{
				System.out.println(s.getId()+"\t"+s.getName()+"\t"+"\t"+a[k]);
				ExcelOne eo=new ExcelOne(s.getId(),s.getName(),String.valueOf(a[k]));
				alist3.add(eo);
			}
			
		}
		eco.create(alist3, three);
		
		
	}
		
		
	
	
	public void sortByDayTotal(ArrayList<Student> list,int k) throws IOException, DocumentException
	{
		ArrayList<ExcelOne> alist=new ArrayList<ExcelOne>();
		ArrayList<ExcelOne> alist2=new ArrayList<ExcelOne>();
		ArrayList<ExcelOne> alist3=new ArrayList<ExcelOne>();
		
		System.out.println("Details for who completed both labs and projects  of day "+(k+1));
		for(Student s:list)
		{
			int a[]=s.getTotal();
			if(a[k]>=18)
			{
				System.out.println(s.getId()+"\t"+s.getName()+"\t"+"\t"+a[k]+"\t");
				ExcelOne eo=new ExcelOne(s.getId(),s.getName(),String.valueOf(a[k]));
				alist.add(eo);
			}
			
		}
		eco.create(alist, first);
		System.out.println("");
		System.out.println("Details of student who completed greater than and equal to half of labs and projects in day "+(k+1));
		for(Student s:list)
		{
			int a[]=s.getTotal();
			if(a[k]>=10&&a[k]<18)
			{
				System.out.println(s.getId()+"\t"+s.getName()+"\t"+"\t"+a[k]);
				ExcelOne eo=new ExcelOne(s.getId(),s.getName(),String.valueOf(a[k]));
			    alist2.add(eo);
			}
		}
		eco.create(alist2, two);
		System.out.println("");
		System.out.println("Details of student who doen't completed single lab and project"+(k+1));
		for(Student s:list)
		{
			int a[]=s.getTotal();
			if(a[k]<10)
			{
				System.out.println(s.getId()+"\t"+s.getName()+"\t"+"\t"+a[k]);
				ExcelOne eo=new ExcelOne(s.getId(),s.getName(),String.valueOf(a[k]));
				alist3.add(eo);
			}
			
		}
		eco.create(alist3, three);
		
		
	}
	
	
	
	public void sortByDayLabs(ArrayList<Student> list,int k) throws IOException, DocumentException
	{
		ArrayList<ExcelOne> alist=new ArrayList<ExcelOne>();
		ArrayList<ExcelOne> alist2=new ArrayList<ExcelOne>();
		ArrayList<ExcelOne> alist3=new ArrayList<ExcelOne>();
		
		System.out.println("Details of student who completed all the labs of day "+(k+1));
		for(Student s:list)
		{
			int a[]=s.getLab();
			if(a[k]>=9)
			{
				System.out.println(s.getId()+"\t"+s.getName()+"\t"+"\t"+a[k]+"\t");
				ExcelOne eo=new ExcelOne(s.getId(),s.getName(),String.valueOf(a[k]));
				alist.add(eo);
				
				
			}
			
		}
		eco.create(alist, first);
		System.out.println("");
		System.out.println("Details of student who completed greater than  and equals to half of labs in day "+(k+1));
		for(Student s:list)
		{
			int a[]=s.getLab();
			if(a[k]>=5&&a[k]<9)
			{
				System.out.println(s.getId()+"\t"+s.getName()+"\t"+"\t"+a[k]);
				ExcelOne eo=new ExcelOne(s.getId(),s.getName(),String.valueOf(a[k]));
				alist2.add(eo);
			}
			
		}
		eco.create(alist2, two);
		System.out.println("");
		System.out.println("Details of student who doesn't completed labs in day"+(k+1));
		for(Student s:list)
		{
			int a[]=s.getLab();
			if(a[k]<5)
			{
				System.out.println(s.getId()+"\t"+s.getName()+"\t"+"\t"+a[k]);
				ExcelOne eo=new ExcelOne(s.getId(),s.getName(),String.valueOf(a[k]));
				alist3.add(eo);
			}
			
		}
		eco.create(alist3, three);
		
	}
	
	
	
	
	public void sortByGrandTotal(ArrayList<Student> list) throws IOException, DocumentException
	{
		ArrayList<ExcelOne> alist=new ArrayList<ExcelOne>();
		ArrayList<ExcelOne> alist2=new ArrayList<ExcelOne>();
		ArrayList<ExcelOne> alist3=new ArrayList<ExcelOne>();
		
		System.out.println("Details of student who got full marks in a week ");
		for(Student s:list)
		{
			if(s.getGrandTotal()>=90)
			{
				System.out.println(s.getId()+"\t"+s.getName()+"\t"+"\t"+s.getGrandTotal());
				ExcelOne eo=new ExcelOne(s.getId(),s.getName(),String.valueOf(s.getGrandTotal()));
				alist.add(eo);
			}
		}
		eco.create(alist, first);
		System.out.println("");
		System.out.println("Details of student who got  equal and above half of  the marks in a week ");
		for(Student s:list)
		{
			if(s.getGrandTotal()<90&&s.getGrandTotal()>=50)
			{
				System.out.println(s.getId()+"\t"+s.getName()+"\t"+"\t"+s.getGrandTotal());
				ExcelOne eo=new ExcelOne(s.getId(),s.getName(),String.valueOf(s.getGrandTotal()));
				alist.add(eo);
			}
		}
		eco.create(alist2, two);
		System.out.println("");
		System.out.println("Details of student who got  less than half of  the  marks in a week ");
		for(Student s:list)
		{
			if(s.getGrandTotal()<50)
			{
				System.out.println(s.getId()+"\t"+s.getName()+"\t"+"\t"+s.getGrandTotal());
				ExcelOne eo=new ExcelOne(s.getId(),s.getName(),String.valueOf(s.getGrandTotal()));
				alist.add(eo);
			}
		}
		eco.create(alist3, three);
		
	
	}
	
	
	
	
	
	public void sortByLabTotalWise(ArrayList<Student> list) throws NumberFormatException, EncryptedDocumentException, InvalidFormatException, IOException, DocumentException
	{
		ArrayList<ExcelOne> alist=new ArrayList<ExcelOne>();
		ArrayList<ExcelOne> alist2=new ArrayList<ExcelOne>();
		ArrayList<ExcelOne> alist3=new ArrayList<ExcelOne>();
		
		System.out.println("Details of student who completed maximum labs in week ");
		for(Student s :list)
		{ 
			int sum=0;
			int a[]=s.getLab();
			for(int i=0;i<a.length;i++)
			{
				sum=sum+a[i];
			}
			if(sum>=45)
			{
				System.out.println(s.getId()+"\t"+s.getName()+"\t"+"\t"+sum);
				ExcelOne eo=new ExcelOne(s.getId(),s.getName(),String.valueOf(sum));
				alist.add(eo);
				
			}
				
		}
		eco.create(alist, first);
		System.out.println("");
		System.out.println("Details of student who completed half and above  of  labs in a week  ");
		for(Student s :list)
		{ 
			int sum=0;
			int a[]=s.getLab();
			for(int i=0;i<a.length;i++)
			{
				sum=sum+a[i];
			}
			if(sum>=25&&sum<45)
			{
				System.out.println(s.getId()+"\t"+s.getName()+"\t"+"\t"+sum);
				ExcelOne eo=new ExcelOne(s.getId(),s.getName(),String.valueOf(sum));
				alist2.add(eo);
			}
				
		}
		eco.create(alist2, two);
		System.out.println("");
		System.out.println("Details of student who completed less than half of  the labs in a week ");
		for(Student s :list)
		{ 
			int sum=0;
			int a[]=s.getLab();
			for(int i=0;i<a.length;i++)
			{
				sum=sum+a[i];
			}
			if(sum<25)
			{
				System.out.println(s.getId()+"\t"+s.getName()+"\t"+"\t"+sum);
				ExcelOne eo=new ExcelOne(s.getId(),s.getName(),String.valueOf(sum));
				alist3.add(eo);
			}
				
		}
		eco.create(alist3, three);
	
	}
	
	
	
	
	public void sortByProjectTotalWise(ArrayList<Student> list) throws NumberFormatException, EncryptedDocumentException, InvalidFormatException, IOException, DocumentException
	{
		ArrayList<ExcelOne> alist=new ArrayList<ExcelOne>();
		ArrayList<ExcelOne> alist2=new ArrayList<ExcelOne>();
		ArrayList<ExcelOne> alist3=new ArrayList<ExcelOne>();
		
		System.out.println("Details of student who completed most projects in a week ");
		for(Student s :list)
		{ 
			int sum=0;
			int a[]=s.getProject();
			for(int i=0;i<a.length;i++)
			{
				sum=sum+a[i];
			}
			if(sum>=45)
			{
				System.out.println(s.getId()+"\t"+s.getName()+"\t"+"\t"+sum);
				ExcelOne eo=new ExcelOne(s.getId(),s.getName(),String.valueOf(sum));
				alist.add(eo);
				
			}
				
		}
		eco.create(alist, first);
		System.out.println("");
		System.out.println("Details of student who completed greater than and half of the work in a week ");
		for(Student s :list)
		{ 
			int sum=0;
			int a[]=s.getProject();
			for(int i=0;i<a.length;i++)
			{
				sum=sum+a[i];
			}
			if(sum>=25&&sum<45)
			{
				System.out.println(s.getId()+"\t"+s.getName()+"\t"+"\t"+sum);
				ExcelOne eo=new ExcelOne(s.getId(),s.getName(),String.valueOf(sum));
				alist2.add(eo);
			}
				
		}
		eco.create(alist2, two);
		System.out.println("");
		System.out.println("Details of student who completed less than half of the projects in a week ");
		for(Student s :list)
		{ 
			int sum=0;
			int a[]=s.getProject();
			for(int i=0;i<a.length;i++)
			{
				sum=sum+a[i];
			}
			if(sum<25)
			{
				System.out.println(s.getId()+"\t"+s.getName()+"\t"+"\t"+sum);
				ExcelOne eo=new ExcelOne(s.getId(),s.getName(),String.valueOf(sum));
				alist3.add(eo);
			}
				
		}
		eco.create(alist3, three);
	
	}
	
	
	
	
	public void sortByDayWise(ArrayList<Student> list,int k) throws Exception
	{
		ArrayList<ExcelTwo> alist=new ArrayList<ExcelTwo>();
		
		System.out.println("");
		for(Student s:list)
		{
			int a[]=s.getLab();
			int b[]=s.getProject();
			int c[]=s.getTotal();
			System.out.println(s.getId()+"\t"+s.getName()+"\t"+"\t"+a[k]+"\t"+b[k]+"\t"+c[k]);
			ExcelTwo et=new ExcelTwo(s.getId(),s.getName(),String.valueOf(a[k]),String.valueOf(b[k]),String.valueOf(c[k]));
			alist.add(et);
		}
		ect.create(alist,day);
		
	}
	
	
	

}
