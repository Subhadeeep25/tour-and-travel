import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class admin extends HttpServlet
{
        public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
    {
        res.setContentType("text/html");// it tells what kind of response the server will give
        PrintWriter pw1=res.getWriter();// Initializing the writing response of the server
        String id=req.getParameter("id"); 
        String pass=req.getParameter("pass"); 
       
        try
        {
            
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","password");
            Statement stm=con.createStatement();   
            String q1="select * from admin_details where id ='"+id+"' and password='"+pass+"'";
            pw1.println(q1);
            ResultSet x=stm.executeQuery(q1);
            //pw1.println(x);
            if(x.next()){
             req.getRequestDispatcher("adminhome.html").forward(req, res);
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