<%-- 
    Document   : page2
    Created on : Jun 27, 2019, 1:09:27 PM
    Author     : bestuser
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String username= request.getParameter("username");
            String  secretKey= request.getParameter("secret-key");
            out.println("Welcome "+username+" key "+secretKey);
        %>
    </body>
</html>
