<%@ page import="java.sql.*" %>
<% Class.forName("oracle.jdbc.driver.OracleDriver"); %>
<HTML>
       <HEAD>
       <TITLE>All User Table </TITLE>
       <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

       </HEAD>
       <BODY BGCOLOR="cyan">
       <H3><center>All User Table</center></H3>
       <%
           Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","password");
           Statement statement = connection.createStatement() ;
          ResultSet resultset = statement.executeQuery("select * from user_details") ;
       %>
       <TABLE class="table table-success table-striped" style="width:100%">
      <TR>
      <TH>ID</TH>
      <TH>Name</TH>
      <TH>Email</TH>
      <TH>Password</TH>
      </TR>
      <% while(resultset.next()){ %>
      <TR>
       <TD> <%= resultset.getString(1) %></td>
       <TD> <%= resultset.getString(2) %></TD>
       <TD> <%= resultset.getString(3) %></TD>
       <TD> <%= resultset.getString(4) %></TD>
      </TR>
      <% } %>
     </TABLE>
     </BODY>
</HTML>