/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import controllers.MyServlet;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Student;

/**
 *
 * @author bestuser
 */
public class StudentDao extends Database {

    private String server = "localhost:3306";
    private String database = "bootcampdb";
    private String username = "root";
    private String password = "therootisonfire";

    public StudentDao() {
        super();
    }

    public List<Student> getStudents() {
        String query = "SELECT * FROM `bootcampdb`.`students`";
        Student st;
        List<Student> students = new ArrayList<>();

        setOptions("?zeroDateTimeBehavior=convertToNull&serverTimezone=Europe/Athens&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false");
        ResultSet rs = Database(server, database, username, password, query);
        if (rs == null) {
            System.out.println("Error to the database");
        }
        try {
            while (rs.next()) {
                st = new Student(rs.getInt("ID"), rs.getString("SURNAME"),
                        rs.getString("NAME"), rs.getFloat("GRADE"),
                        rs.getString("BIRTHDATE"));
                students.add(st);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MyServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        return students;
    }

    public boolean insertStudent(Student st) {
        String query = "INSERT into `bootcampdb`.`students`(name,surname,grade,birthdate) values("
                +"'"+st.getName()+"'"
                +","+"'"+st.getSurname()+"'"+","+st.getGrade()+","
                +"'"+st.getBirthDate()+"'"
                + ");";
         int i =Database(server, database, username, password, query,((byte)1));
         if(i>=1) return true;
        return false;
    }
    public boolean deleteStudent(int id){
        
        return false;
    }

}
