<html>
<body>
<h2>failure</h2>

<h1>user not registered, failure</h1>


<%
     String name=(String)session.getAttribute("name");
%>

<h2>sorry <%= name %> could not register you</h2>

</body>
</html>
