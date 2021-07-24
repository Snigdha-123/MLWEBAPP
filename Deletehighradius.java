package com.higradius;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.*;
import java.util.*;
@WebServlet("/delete")
public class Deletehighradius extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res)
	{    String url="jdbc:mysql://localhost:3306/highradius";
	String userName="root";
	String pass="1612";
	  try
      {
         Class.forName("com.mysql.jdbc.Driver");
      }
      catch(Exception e)
       {
         e.printStackTrace();
       }
	  String invoice_id =req.getParameter("invoice");
	  try
		{
			Connection con = DriverManager.getConnection(url,userName,pass);
			String query = "DELETE FROM finalm WHERE invoice_id ="+invoice_id;
			Statement estate = con.createStatement();
			 int sucess=estate.executeUpdate(query);
			 if(sucess==1)
			 {
				 System.out.println("data deleted sucessfully");
				 res.sendRedirect("/H2HBABBA1395/highradius");
			 }
			 else {
			       res.sendRedirect("/H2HBABBA1395/highradius");
			    }
			
		}
		catch(Exception e)
		{
			//e.printStackTrace();
			System.out.println(e);
		}		
	
	
	
	}
	

}
