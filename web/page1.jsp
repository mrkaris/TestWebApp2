<%-- 
    Document   : page1.jsp
    Created on : Jun 27, 2019, 1:05:55 PM
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
            String username = request.getParameter("username");
            if (!username.equals("admin")) {
                throw new Exception("Unauthoriafkhja");
            } else {

        %>
        <jsp:include page="page2.jsp">
            <jsp:param name="secret-key" value="<%=secretKey%>"/>
        </jsp:include>
        <% } %>
        <br><% out.println(request.getRemoteAddr());
            out.println(request.getRequestURI());
        %>
        <%! private String secretKey = "1234";%>
    </body>
</html>
