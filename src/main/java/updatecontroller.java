

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/updatecontroller")
public class updatecontroller extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	
	String username=	 request .getParameter("un");
	try {
		

		 Class.forName("com.mysql.cj.jdbc.Driver");
		 Connection conn=  DriverManager.getConnection("jdbc:mysql://localhost:3306/autho","root", "admin");			
	PreparedStatement pst=	conn.prepareStatement("update  reg set status='Authorized' where username='"+username+"' " );
	
	  int i=  pst.executeUpdate();
	
	    if(i==1) {
	    	 response.sendRedirect("login.html");
	    }
	
	
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	
	}

}
