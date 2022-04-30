import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.lang.*;

public class feedback extends HttpServlet
{
        public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
    {
        res.setContentType("text/html");// it tells what kind of response the server will give
        PrintWriter pw1=res.getWriter();// Initializing the writing response of the server
        String email=req.getParameter("email"); 
       // Integer id1=Integer.parseInt(id);
        //pw1.println("<html><body bgcolor=skyblue>your name is: "+nm1+"<br></body></html>");//response page
        String feed=req.getParameter("feed"); 
        //pw1.println("<html><body bgcolor=skyblue>Your password is: "+nm2+"<br></body></html>");
       
        try
        {
            HttpSession sc=req.getSession();
            String id1=(String)sc.getAttribute("id1");
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","password");
            Statement stmt=con.createStatement();
            String q1="insert into feedback values('"+id1+"','"+email+"','"+feed+"')";
            ResultSet x=stmt.executeQuery(q1);
            if(x.next()){
                req.getRequestDispatcher("success.html").forward(req, res);
            }
            else
            {
             pw1.println("<html><body bgcolor=skyblue>Please Try Again.</body></html>");
            }

     con.close();
     }
      catch(Exception e)
     { 
        pw1.println(e);
     }
   }
}