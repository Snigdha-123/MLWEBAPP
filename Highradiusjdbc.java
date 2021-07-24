package com.higradius;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.*;
import java.util.*;

@WebServlet("/highradius")
public class Highradiusjdbc extends HttpServlet{
	
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{
		String url="jdbc:mysql://localhost:3306/highradius";
		String userName="root";
		String pass="1612";
		
		String query="SELECT * FROM finalm LIMIT 10";
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		ArrayList<CompanyTable> customers = new ArrayList<CompanyTable>();

		try {
		Connection con = DriverManager.getConnection(url,userName,pass);
		Statement st= con.createStatement();
		ResultSet rs=st.executeQuery(query);
		
		
		while(rs.next()) {
			
			String name=rs.getString("name_customer");
			String customerno=rs.getString("cust_number");
			String id=rs.getInt("invoice_id")+"";
			String amount=rs.getBigDecimal("total_open_amount")+"";
			String duedate=rs.getString("due_in_date");
			String cleardate=rs.getString("clear_date");
			String notes=rs.getString("bucket");					
			CompanyTable customer=new CompanyTable(name,customerno,id,amount,duedate,cleardate,notes);
			customers.add(customer);		
			
		}
		
		st.close();
		con.close();
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

		req.setAttribute("customers", customers);
		req.getRequestDispatcher("/HighRadiusWeb.jsp").forward(req, res);
		
		
	}

}
