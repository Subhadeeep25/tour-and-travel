import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.lang.*;

public class forget4 extends HttpServlet
{
        public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
    {
        res.setContentType("text/html");// it tells what kind of response the server will give
        PrintWriter pw1=res.getWriter();// Initializing the writing response of the server
        String nm1=req.getParameter("n1"); 
        
       
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","Rejaul2002");
            Statement stmt=con.createStatement();
            String q1="select * from signup3 where id ='"+nm1+"'";
            ResultSet x=stmt.executeQuery(q1);
            if(x.next())
            {
                pw1.println("<html>\n" +
"    <head>\n" +
"      \n" +
"    </head>\n" +
"    <body bgcolor=\"yellow\">\n" +
"        <form method =\"get\" action =\"forget5\">\n" +
"            SQ:<br><br>\n" +
"            ANS:<input type=\"text\" name=\"n1\"><br> <br>\n" +
"            ID: <input type=\"text\" name=\"n2\"><br><br>\n" +
"         \n" +
"            \n" +
"            <br><bR>\n" +
"            <input type=\"submit\" value=\"submit\">\n" +
"        </form>\n" +
"    </body>\n" +
"</html>\n" +
"");
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