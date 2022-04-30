import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.lang.*;

public class forget6 extends HttpServlet
{
        public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
    {
        res.setContentType("text/html");// it tells what kind of response the server will give
        PrintWriter pw1=res.getWriter();// Initializing the writing response of the server
        String nm1=req.getParameter("n1"); 
        //pw1.println("<html><body bgcolor=skyblue>your name is: "+nm1+"<br></body></html>");//response page
        String nm2=req.getParameter("n2"); 
        //pw1.println("<html><body bgcolor=skyblue>Your password is: "+nm2+"<br></body></html>");
       
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","Rejaul2002");
            Statement stmt=con.createStatement();
            String q1="update signup3 set pass ='"+nm1+"'where id='"+nm2+"'";
            ResultSet x=stmt.executeQuery(q1);
            if(x.next())
            {
                pw1.println("<html>\n" +
"    <head>\n" +
"      \n" +
"    </head>\n" +
"    <body bgcolor=\"pink\">\n" +
"       \n" +
"        PASSWORD CHANGED SUCCESSFULLY.<br><br>\n" +
"      <a href=\"signin3.html\"> Go To Signin Page</a>\n" +
"         \n" +
"            \n" +
"          \n" +
"            <input type=\"submit\" value=\"submit\">\n" +
"        \n" +
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