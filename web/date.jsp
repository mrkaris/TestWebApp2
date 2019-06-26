<%-- 
    Document   : date
    Created on : Jun 25, 2019, 10:49:26 AM
    Author     : bestuser
--%>

<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%=3 + 2%>
        <% out.print(3 + 2);%>
        <%=new Date()%>
        <% if (Math.random() < 0.5) {
                out.print("heads");
            } else {
                out.print("tails");
            }
        %>
        <%
            out.print("Count is: "+count);
        %>
        <%! public static int count = 50;%>
        <%
            out.print(count);
        %>
    </body>
</html>
