package controller;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class SignUp
{
	private static final String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";
	private static Pattern pattern;
	  private static Matcher matcher1;
	private static Matcher matcher2;
	  //this metohd receives user details
		public static void userDetails() throws IOException
		{
			
		System.out.println("Welcome to Record Management Ststem,Plaese SignUP or Login to continue");
		System.out.println("");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//name
		System.out.println("Please enter your name");
		String name =br.readLine();
		//email
		System.out.println("Please enter your mail");
		String email=br.readLine();
		
		//password
		//Console con = System.console();
		System.out.println("Enter your passwod");
		//char[] ch=con.readPassword();  
		String password = br.readLine();   
		//confirmpassword
		System.out.println("Confirm your passwod");
		//char[] ch2=con.readPassword();
		String  confirmPassword=br.readLine();
		
		//checks valid details or not by calling other functions
		if(validEmail(email) && validPassword(password,confirmPassword))
		{
			System.out.println("Successfully Registered,Please login to process further");
			System.out.println("");
			
			//here passing email and password to welome class
			SignupAndLoginup sau = new SignupAndLoginup(email,password);
			sau.check();
			
		}
		else
		{
			System.out.println("Invalid email or password");
			System.out.println("Please sign up again ");
			userDetails();
			
		}
		}
		
		//checks valid password ot not,called from userDetails
	
	public static boolean validPassword(String password, String confirmPassword) {
		
		
		if(password.length()==0)
			return false;
			if(!(password.equals(confirmPassword)))
				return false;
			if(!((password.length()>=8)&&(password.length()<=20)))
	              return false;
	              char a[]=password.toCharArray();
	         int capital=0;
	         int lower=0;
	         int num=0;
	         int special=0;
	         for(int i=0;i<password.length();i++)
	         {
	        	 if((a[i]>=65)&&(a[i]<=90))
	        		 capital ++;
	        	 else if((a[i]>=97)&&(a[i]<=122))
	        		 lower ++;
	        	 else if((a[i]>=48)&&(a[i]<=58))
	        		 num ++;
	        	 else
	        		 special ++;
	        		 
	         }
	         if((capital>0)&&(lower>0)&&(num>0))
	        	 return true;
			
	         else
	        	 return false;
			
		 
	}
	//checks valid email or not called from userDetails

	public  static boolean validEmail(String email) {
		
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                "[a-zA-Z0-9_+&*-]+)*@" + 
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                "A-Z]{2,7}$"; 
                  
        Pattern pat = Pattern.compile(emailRegex); 
        if (email == null) 
        return false; 
        return pat.matcher(email).matches(); 
	}
	
}
