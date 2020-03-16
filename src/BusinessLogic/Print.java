package BusinessLogic;

import java.util.ArrayList;

import service.Student;

public class Print
{
	public void print(ArrayList<Student> list)
	{ 
		System.out.println("Id"+"\t"+"Name"+"\t "+"\t"+"Day 1"+"\t"+"\t"+"Day 2"+"\t"+"\t"+"\t"+"Day 3"+"\t"+"\t"+"\t"+"Day 4"+"\t"+"\t"+"\t"+"Day 5");
		
		System.out.println("\n");
		for(Student s:list)
	    {
	    	System.out.print(s.getId()+"\t");
	    	System.out.print(s.getName()+"\t ");
	    	int a[]= s.getLab();
	    	int b[]=s.getProject();
	    	int c[]=s.getTotal();
	    	
	    	
	    	for(int i=0;i<5;i++)
	    	{
	    		System.out.print(a[i]+"\t"+b[i]+"\t"+c[i]+"\t");
	    		
	    		
	    	}
	    	System.out.println(s.getGrandTotal());
	    	System.out.println("\n");
	    	
	    	
	    }
	    
		
	}

}
