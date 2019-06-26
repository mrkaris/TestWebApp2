<%-- 
    Document   : newstudent
    Created on : Jun 26, 2019, 11:58:24 AM
    Author     : bestuser
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New Student</title>
    </head>
    <body>
        <h1><%=request.getAttribute("title")%></h1>
        <form action="insertStudentServlet" method="POST">
            Name: <input type="text" name="name" /><br>
            Surname: <input type="text" name="surname" /><br>
            Grade: <input type="number" name="grade" /><br>
            Birthdate: <input type="date" name="birthdate"/><br>
            <input type="submit" name="new" value="Submit Student" />
        </form>
        
    </body>
</html>
