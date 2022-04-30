import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.lang.*;

public class signin3 extends HttpServlet
{
        public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
    {
        res.setContentType("text/html");// it tells what kind of response the server will give
        PrintWriter pw1=res.getWriter();// Initializing the writing response of the server
        String id=req.getParameter("id"); 
       // Integer id1=Integer.parseInt(id);
        //pw1.println("<html><body bgcolor=skyblue>your name is: "+nm1+"<br></body></html>");//response page
        String pass=req.getParameter("pass"); 
        //pw1.println("<html><body bgcolor=skyblue>Your password is: "+nm2+"<br></body></html>");
       
        try
        {
            HttpSession sc=req.getSession();
            sc.setAttribute("id1", id);
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","password");
            Statement stmt=con.createStatement();
            String q1="select * from user_details where id ='"+id+"'and password='"+pass+"'";
            ResultSet x=stmt.executeQuery(q1);
            if(x.next()){
            ResultSet rs = stmt.executeQuery("select name from user_details where id ='"+id+"'");
            rs.next();
            String name = rs.getString("NAME");
                                req.getRequestDispatcher("signinsuccess.html").forward(req, res);

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