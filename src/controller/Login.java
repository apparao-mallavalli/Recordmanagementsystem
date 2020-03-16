package controller;
import java.io.*;


public class Login
{
	private String email;
	private String password;
	
	//constructor
	public Login(String email, String password) 
	{
		super();
		this.email = email;
		this.password = password;
	}


	public  boolean checkLogin() throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("enter your email");
		String email1=br.readLine();
		System.out.println("enter your password");
		String password1=br.readLine();
		
		
		if(email1.equals(email)&&password1.equals(password))
			return true;
		
		return false;
		
	}
	

}
