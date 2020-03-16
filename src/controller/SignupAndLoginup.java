package controller;

import java.io.IOException;

public class SignupAndLoginup 
{
	
		private static String email;
		private static String password;
		

		public SignupAndLoginup(String email, String password) 
		{
			super();
			this.email = email;
			this.password = password;
		}

		public String getEmail() {
			return email;
		}


		public void setEmail(String email) {
			this.email = email;
		}


		public String getPassword() {
			return password;
		}
		


		public void setPassword(String password) {
			this.password = password;
		}
	
		public void check() throws IOException
		{
			Login log=new Login(email,password);
		boolean b=	log.checkLogin();
		if(b)
		{
			System.out.println(b);
			return ;
		}
		else
		{
			System.out.println("Invalid email or password");
		}
			check();
			
		}

}
