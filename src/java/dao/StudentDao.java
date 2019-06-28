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
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
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
                st = new Student(rs.getLong("ID"), rs.getString("SURNAME"),
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
                + "'" + st.getName() + "'"
                + "," + "'" + st.getSurname() + "'" + "," + st.getGrade() + ","
                + "'" + st.getBirthDate() + "'"
                + ");";
        int i = Database(server, database, username, password, query, ((byte) 1));
        if (i >= 1) {
            return true;
        }
        return false;
    }

    public boolean insertStudentJPA(Student st) {
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("TestWebApp2PU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        boolean success=false;
        try {
            em.persist(st);
            em.getTransaction().commit();
            success=true;
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
            emf.close();
        }
        return success;
    }

    public boolean deleteStudent(int id) {
        String query = "DELETE from `bootcampdb`.`students` where ID=" + id + ";";
        int i = Database(server, database, username, password, query, ((byte) 1));
        if (i >= 1) {
            return true;
        }
        return false;
    }

    public boolean updateStudent(Student st) {
        String query = "UPDATE `bootcampdb`.`students` set "
                + "surname='" + st.getSurname()
                + "', name='" + st.getName() + "', grade=" + st.getGrade() + ", birthdate='"
                + st.getBirthDate() + "' where ID=" + st.getId();
//        System.out.println(query);
        int i = Database(server, database, username, password, query, ((byte) 1));
        if (i >= 1) {
            return true;
        }
        return false;
    }

    public Student getStudentByID(int id) {
        setOptions("?zeroDateTimeBehavior=convertToNull&serverTimezone=Europe/Athens&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false");
        String query = "SELECT * FROM `bootcampdb`.`students` where ID=" + id;
        Student st = null;
        ResultSet rs = Database(server, database, username, password, query);
        if (rs == null) {
            System.out.println("Error to the database");
        }
        try {
            rs.next();
            st = new Student(rs.getLong("ID"), rs.getString("SURNAME"),
                    rs.getString("NAME"), rs.getFloat("GRADE"),
                    rs.getString("BIRTHDATE"));

        } catch (SQLException ex) {
            Logger.getLogger(MyServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        return st;
    }

}
