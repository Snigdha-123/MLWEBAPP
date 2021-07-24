package com.higradius;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.*;
import java.util.*;
@WebServlet("/edit")

public class Edithighradius extends HttpServlet {
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
		String amount = req.getParameter("total_open_amount");
		String notes = req.getParameter("bucket");
		String invoice_id =req.getParameter("invoice");
		//System.out.println(notes);
		try
		{
			Connection con = DriverManager.getConnection(url,userName,pass);
			String query = "Update finalm Set total_open_amount= "+ amount +" , bucket ='"+notes+"' where invoice_id ="+invoice_id;
			Statement estate = con.createStatement();
			 int sucess=estate.executeUpdate(query);
			 if(sucess==1)
			 {
				 System.out.println("data altered sucessfully");
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
