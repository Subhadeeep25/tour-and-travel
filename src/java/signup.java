import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax .servlet.http.*;

public class signup extends HttpServlet
{
        public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
    {
        res.setContentType("text/html");// it tells what kind of response the server will give
        PrintWriter pw1=res.getWriter();// Initializing the writing response of the server
        String id=req.getParameter("id"); 
       
        String pass=req.getParameter("pass"); 
        
        String name=req.getParameter("name"); 
        String email=req.getParameter("email"); 
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","password");
            Statement stmt=con.createStatement();
            String q1="insert into user_details values('"+id+"','"+name+"','"+email+"','"+pass+"')";
            int x=stmt.executeUpdate(q1);
            if(x>0)
            {
                req.getRequestDispatcher("signupsuccess.html").forward(req, res);
                
            }
        else
        {
            pw1.println("Sign-up Failed");
        }
     con.close();
     }
      catch(Exception e)
     { 
        pw1.println(e);
     }
   }
}