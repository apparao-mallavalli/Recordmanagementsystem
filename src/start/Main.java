package start;
import java.io.*;
import java.util.ArrayList;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import BusinessLogic.BusinessOperations;
import controller.SignUp;
import exceloperations.StudentFile;

import service.Student;

public class Main 
{
	
	public static void main(String args[])throws Exception
	{
		SignUp.userDetails();
		System.out.println(" ");
		String excelFilePath= "C:\\Users\\malla\\Desktop\\student.xls";
		ArrayList<Student> alist=new ArrayList<Student>();
		StudentFile sf=new StudentFile();
	    alist  =	sf.read(excelFilePath);
	    BusinessOperations bo=new BusinessOperations();
	   
	   options(alist);
	
	}
	public static void options(ArrayList<Student> list) throws Exception
	{ 
		BusinessOperations bo=new BusinessOperations();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String str="yes";
		while(str.equalsIgnoreCase("yes"))
		{
			System.out.println("1.choose one for Day Wise report"+"            \t"+"2.choose two for total wise"+"                   \t"+"3.choose three for to see list sort by name wise");
			System.out.println("");
			System.out.println("4.choose four for Day wise and lab wise"+" \t"+"5.choose five for Day wise and project wise"+"\t"+"6.choose six for Day wise and total wise");
			System.out.println("");
			System.out.println("7.choose seven for LabWise List"+"          \t"+"8.choose Eight for ProjectWise List"+"     \t"+"9.choose nine to see all items sort By id");
			System.out.println("");
			System.out.println("enter you choice = ");
			int choice=Integer.parseInt(br.readLine());
			System.out.println("");
			switch(choice)
			{
			case 1: dayWise(list);
				    break;
			case 2: bo.sortByGrandTotal(list);
			        break;
			case 3: bo.sortByName(list) ;
			        break;
			case 4: dayWiseLab(list);
			        break;
			case 5: dayWiseProject(list);
			        break;
			case 6: dayWiseTotal(list);
			        break;
			case 7: bo.sortByLabTotalWise(list) ;
			        break;
			case 8: bo.sortByProjectTotalWise(list);
			        break;
			case 9: bo.sortById(list);    
			        break;
			 default: System.out.println("sorry,enter correct choice");
			          break;
			}
			System.out.println("");
			System.out.println("do you want to continue ?");
			System.out.println("");
			System.out.println("enter yes to continue");
			str=br.readLine();
			System.out.println("");
			System.out.println("");
			
		}
		
	}
	public static void dayWise(ArrayList<Student> list) throws Exception
	{   BusinessOperations bo=new BusinessOperations();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String str="yes";
		while(str.equalsIgnoreCase("yes"))
		{
			System.out.println("1.enter ONE for day 1"+"\t"+"\t"+"2.Enter TWO for day 2"+"\t"+"\t"+"3.Enter THREE for day 3");
			System.out.println("");
			System.out.println("4.Enter FOUR for day 4"+"\t"+"\t"+"5.Enter FIVE for day 5"+"\t"+"\t"+"6.Enter six to go back");
			System.out.println("");
			System.out.print("enter your choice ");
			int choice=Integer.parseInt(br.readLine());
			switch(choice)
			{
			case 1: bo.sortByDayWise(list,0);
			        break;
			case 2: bo.sortByDayWise(list,1);
	                break;
			case 3: bo.sortByDayWise(list,2);
	                break;	
			case 4: bo.sortByDayWise(list,3);
			        break;
			case 5: bo.sortByDayWise(list,4);
			        break;
			case 6: options(list);
			        break;
			default :    System.out.println("sorry,enter correct choice");
	                  break;    
			       
			}
			System.out.println("Do you want to continue ,enter yes to continue ,enter no discontinue,enter back to go back");
			System.out.println("");
			str=br.readLine();
			System.out.println("");
			if(str.equalsIgnoreCase("back"))
					{
				     options(list);
				     return;
				    }
			System.out.println("");
		}
		
	}
	public static void dayWiseLab(ArrayList<Student> list) throws Exception
	{
		 BusinessOperations bo=new BusinessOperations();
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			String str="yes";
			while(str.equalsIgnoreCase("yes"))
			{
				System.out.println("1.enter one for day 1"+"\t"+"2.Enter two for day 2"+"\t"+"3.Enter three for day 3");
				System.out.println("");
				System.out.println("4.Enter fourfor day 4"+"\t"+"5.Enter five for day 5"+"\t"+"6.Enter 6 to go back");
				System.out.println("");
				System.out.print("enter your choice ");
				int choice=Integer.parseInt(br.readLine());
				switch(choice)
				{
				case 1: bo.sortByDayLabs(list,0);
				        break;
				case 2: bo.sortByDayLabs(list,1);
		                break;
				case 3: bo.sortByDayLabs(list,2);
		                break;	
				case 4: bo.sortByDayLabs(list,3);
				        break;
				case 5: bo.sortByDayLabs(list,4);
				        break;
				case 6: options(list);
				        break;
				 default :System.out.println("sorry,enter correct choice");
		                 break;      
				}
				System.out.println("");
				System.out.println("Do you want to continue ,enter yes to continue ,enter no discontinue,enter back to go back");
				System.out.println("");
				str=br.readLine();
				System.out.println("");
				if(str.equalsIgnoreCase("back"))
						{
					     options(list);
					     return;
					    }
			}
		
	}
	public static void dayWiseProject(ArrayList<Student> list) throws Exception
	{
		 BusinessOperations bo=new BusinessOperations();
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			String str="yes";
			while(str.equalsIgnoreCase("yes"))
			{
				System.out.println("");
				System.out.println("1.enter one for day 1"+"\t"+"2.Enter two for day 2"+"\t"+"3.Enter three for day 3");
				System.out.println("");
				System.out.println("4.Enter fourfor day 4"+"\t"+"5.Enter five for day 5"+"\t"+"6.Enter 6 to go back");
				System.out.println("");
				System.out.print("enter your choice ");
				System.out.println("");
				int choice=Integer.parseInt(br.readLine());
				System.out.println("");
				switch(choice)
				{
				case 1: bo.sortByDayProject(list,0);
				        break;
				case 2: bo.sortByDayProject(list,1);
		                break;
				case 3: bo.sortByDayProject(list,2);
		                break;	
				case 4: bo.sortByDayProject(list,3);
				        break;
				case 5: bo.sortByDayProject(list,4);
				        break;
				case 6: options(list);
				        break;
				default :System.out.println("sorry,enter correct choice");
		                 break;        
				       
				}
				System.out.println("");
				System.out.println("Do you want to continue ,enter yes to continue ,enter no discontinue,enter back to go back");
				str=br.readLine();
				System.out.println("");
				if(str.equalsIgnoreCase("back"))
						{
					     options(list);
					     return;
					    }
				System.out.println("");
			}
		
	}
	
	public static void dayWiseTotal(ArrayList<Student> list) throws Exception
	{
		 BusinessOperations bo=new BusinessOperations();
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			String str="yes";
			while(str.equalsIgnoreCase("yes"))
			{
				System.out.println("");
				System.out.println("1.enter one for day 1"+"\t"+"2.Enter two for day 2"+"\t"+"3.Enter three for day 3");
				System.out.println("");
				System.out.println("4.Enter fourfor day 4"+"\t"+"5.Enter five for day 5"+"\t"+"6.Enter 6 to go back");
				System.out.println("");
				System.out.print("enter your choice ");
				int choice=Integer.parseInt(br.readLine());
				System.out.println("");
				switch(choice)
				{
				case 1: bo.sortByDayTotal(list,0);
				        break;
				case 2: bo.sortByDayTotal(list,1);
		                break;
				case 3: bo.sortByDayTotal(list,2);
		                break;	
				case 4: bo.sortByDayTotal(list,3);
				        break;
				case 5: bo.sortByDayTotal(list,4);
				        break;
				case 6: options(list);
				        break;
				default:System.out.println("sorry,enter correct choice");
		                  break;       
				       
				}
				System.out.println("");
				System.out.println("Do you want to continue ,enter yes to continue ,enter no discontinue,enter back to go back");
				str=br.readLine();
				System.out.println("");
				if(str.equalsIgnoreCase("back"))
						{
					     options(list);
					     return;
					    }
				System.out.println("");
			}
		
	}
	

}
