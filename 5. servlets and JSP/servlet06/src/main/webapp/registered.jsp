<html>
<body>
    yaha aa gaye means
    <hr>


    <%@ page import="java.sql.*" %>
    <%@ page import="com.exmaple.dbmsutil" %>

    <%
                    String id=request.getParameter("uid");
                  String name=request.getParameter("uname");
                  String age=request.getParameter("uage");
                  String city=request.getParameter("ucity");
                  Connection conn=null;
                  PreparedStatement stmt=null;
                      String query="insert into studentinfo(id,name,age,city) values(?,?,?,?)";
                      int updatedlines;
    %>

    <%


                  try {

                      conn=dbmsutil.getcon();


                      stmt=conn.prepareStatement(query);

                      stmt.setInt(1,Integer.parseInt(id));
                      stmt.setString(2,name);
                      stmt.setInt(3,Integer.parseInt(age));
                      stmt.setString(4,city);


                      updatedlines = stmt.executeUpdate();

                      if(updatedlines==1){
                          out.println("values updated, pushed to dbms");
                      }
                      else{
                          out.println("values not updated");
                      }


                  } catch (SQLException e) {
                      System.out.println("SQL fata hai");
                      throw new RuntimeException(e);
                  }
                  finally {
                      try {
                          dbmsutil.closestuff(conn,stmt);
                      } catch (SQLException e) {
                          System.out.println("close bhi nai kar paye wao");
                          throw new RuntimeException(e);
                      }
                  }

    %>
</body>
</html>