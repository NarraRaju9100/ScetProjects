

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Database.DataBaseConnection;
@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String username=  request.getParameter("un");
		String password=  request.getParameter("pass");
		String mobile=  request.getParameter("mobile");
		int id =0;
		
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
 Connection conn=  DriverManager.getConnection("jdbc:mysql://localhost:3306/autho","root", "admin");			
			
			PreparedStatement pst=	 conn.prepareStatement("insert into reg values(?,?,?,?,?)");
		
		     pst.setInt(1, id);
		     pst.setString(2, username);
		     pst.setString(3, password);
		     pst.setString(4, mobile);
		     pst.setString(5, "Waiting");

		 int i=    pst.executeUpdate();
		  if(i==1) {
			
		RequestDispatcher rs=	  request.getRequestDispatcher("login.html");
		rs.forward(request, response);	  
			  
		  }
		
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		
		
		}

}
