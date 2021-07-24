package com.higradius;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.*;
import java.util.*;
@WebServlet("/add")
public class Addhighradius extends HttpServlet {
	 public void doPost(HttpServletRequest req,HttpServletResponse res) {
		    String url="jdbc:mysql://localhost:3306/highradius";
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
		String name = req.getParameter("name_customer");
		String custno= req.getParameter("cust_number");
		int id = Integer.parseInt(req.getParameter("invoice_id"));
		String amount = req.getParameter("total_open_amount");
		String duedate = req.getParameter("due_in_date");
		String paymentdate=req.getParameter("clear_date");
		String notes = req.getParameter("bucket");
		try
		{
			Connection con = DriverManager.getConnection(url,userName,pass);
			String query = "Insert into finalm(name_customer,cust_number,invoice_id,total_open_amount,due_in_date,clear_date,bucket) values(?,?,?,?,?,?,?)";
			PreparedStatement state = con.prepareStatement(query);
			state.setString(1,name);
			state.setString(2,custno);
			state.setInt(3,id);
			state.setString(4,amount);
			state.setString(5,duedate);
			state.setString(6,paymentdate);
			state.setString(7,notes);
			int sucess=state.executeUpdate();
			if(sucess==1)
			{
				System.out.println("data added sucessfully");
				 res.sendRedirect("/H2HBABBA1395/highradius");
			}
					
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}		
	 }
}
