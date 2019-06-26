/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import controllers.MyServlet;
import dao.Database;
import dao.StudentDao;
import models.Student;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bestuser
 */
public class StudentService {

    public String getStudents() {

        StudentDao stuDao = new StudentDao();
        List<Student> students = stuDao.getStudents();
        StringBuilder strB = new StringBuilder();

        strB.append("<!DOCTYPE html>")
                .append("<html>")
                .append("<head>")
                .append("<title>My First Servlet</title>")
                .append("</head>")
                .append("<body>");
        for (Student s : students) {
            strB.append("<p>" + s + "</p>");
        }
        strB.append("</body>")
                .append("</html>");

        return strB.toString();
    }

    public boolean insertStudent(Student st) {
        StudentDao stuDao = new StudentDao();
        return stuDao.insertStudent(st);
    }

}
