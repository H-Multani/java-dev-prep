<html>
<body>
<h2>success</h2>

<h1>user registered, success!!!</h1>

<%
     String name=(String)session.getAttribute("name");
%>

<h2>congrats on registering <%= name %></h2>
</body>
</html>
