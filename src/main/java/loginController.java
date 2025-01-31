

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/loginController")
public class loginController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 String username =  request.getParameter("un");
	String password =request.getParameter("pass");
	
	 String wait="Waiting";
	 String autho="Authorized";
 PrintWriter out= 	response.getWriter();
	
	 try {
		
		 Class.forName("com.mysql.cj.jdbc.Driver");
		 Connection conn=  DriverManager.getConnection("jdbc:mysql://localhost:3306/autho","root", "admin");			
			
	PreparedStatement pst=	 conn.prepareStatement("select *from reg where username='"+username+"' and password='"+password+"'  ");
	  ResultSet rs= pst.executeQuery();	 
		 
		if(rs.next()) {
			
			
	PreparedStatement pst1=		conn.prepareStatement("select *from reg where username='"+username+"' and password='"+password+"' and status='Authorized'    ");
			
 ResultSet rs1=	pst1.executeQuery();
       
          if(rs1.next()) {
        	  
        	  response.sendRedirect("user.html");
        	  
          }
          else {
        	  response.sendRedirect("UserStatusupdate.html");
          }
        
 
 
	
		}
		else {
			
			out.print("Umauthorized User .. plz waiting Admin");
		}
		 
		 
		 
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	
			
			
			
	}

}
