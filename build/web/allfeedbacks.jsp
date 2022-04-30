<%@ page import="java.sql.*" %>
<% Class.forName("oracle.jdbc.driver.OracleDriver"); %>
<HTML>
       <HEAD>
       <TITLE>All Booking Table </TITLE>
       <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">        
       </HEAD>
       <BODY>
       <H3><center>Customer Feedback</center></H3>
       <%
           Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","password");
           Statement statement = connection.createStatement() ;
          ResultSet resultset = statement.executeQuery("select * from feedback") ;
       %>
      <TABLE class="table table-success table-striped" style="width:100%">
      <TR>
      <TH>ID</TH>
      <TH>Email</TH>
      <TH>Feedback</TH>
      </TR>
      <% while(resultset.next()){ %>
      <TR>
       <TD> <%= resultset.getString(1) %></td>
       <TD> <%= resultset.getString(2) %></TD>
       <TD> <%= resultset.getString(3) %></TD>
      </TR>
      <% } %>
     </TABLE>
     </BODY>
</HTML>