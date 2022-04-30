import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.lang.*;

public class adpackage extends HttpServlet
{
    public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
    {
        res.setContentType("text/html");
        PrintWriter pw1=res.getWriter();
        String dest=req.getParameter("dest");
        String from=req.getParameter("startdate");
        String days=req.getParameter("days");
        String tickets=req.getParameter("tickets");
       
        try
        {
            HttpSession sc=req.getSession();
            String id1=(String)sc.getAttribute("id1");
            try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","password");
            Statement stm=con.createStatement();   
            String q1="insert into package values('"+id1+"','"+dest+"','"+from+"','"+days+"','"+tickets+"')";                      
            ResultSet x=stm.executeQuery(q1);
            if(x.next()){
             req.getRequestDispatcher("bookingsuccess.html").forward(req, res);
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
        catch(NullPointerException x){
            pw1.println("<html><body bgcolor=skyblue>Please Login First.</body></html>");
        }
    }