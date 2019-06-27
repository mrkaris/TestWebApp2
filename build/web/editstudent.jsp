<%-- 
    Document   : newstudent
    Created on : Jun 26, 2019, 11:58:24 AM
    Author     : bestuser
--%>

<%@page import="models.Student"%>
<%@page import="dao.StudentDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New Student</title>
    </head>
    <body>
      


        
        <h1><%=request.getAttribute("title")%></h1>
        <form action="updateStudentServlet" method="POST">
            Name: <input type="text" name="name" value="<%=request.getAttribute("name")%>" /><br>
            Surname: <input type="text" name="surname" value="<%=request.getAttribute("surname")%>"/><br>
            Grade: <input type="number" name="grade" value="<%=request.getAttribute("grade")%>"/><br>
            Birthdate: <input type="date" name="birthdate" value="<%=request.getAttribute("birthdate")%>"/><br>
            ID: <input type="hidden" name="id" value="<%=request.getAttribute("id")%>"/><br>
            
            <input type="submit" name="new" value="Edit Student" />
        </form>
        
    </body>
</html>
