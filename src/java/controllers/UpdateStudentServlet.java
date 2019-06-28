/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.StudentDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Student;
import services.StudentService;

/**
 *
 * @author bestuser
 */
@WebServlet(name = "UpdateStudentServlet", urlPatterns = {"/updateStudentServlet"})
public class UpdateStudentServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UpdateStudentServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateStudentServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("editstudent.jsp");
        request.setAttribute("title", "Update Student");
        Integer sid = Integer.parseInt(request.getParameter("update"));
        StudentService ss = new StudentService();
        Student stu = ss.getStudentById(sid);
        request.setAttribute("id", stu.getId());
        request.setAttribute("name", stu.getName());
        request.setAttribute("surname", stu.getSurname());
        request.setAttribute("grade", stu.getGrade());
        request.setAttribute("birthdate", stu.getBirthDate());
        rd.forward(request, response);

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Student st;
        StudentService ss = new StudentService();

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UpdateStudentServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateStudentServlet at " + request.getContextPath() + "</h1>");
            st = new Student(Long.parseLong(request.getParameter("id")), request.getParameter("surname"),
                    request.getParameter("name"),
                    Float.parseFloat(request.getParameter("grade")),
                    request.getParameter("birthdate"));
//            boolean updated= ss.updateStudent(st);
//            if (ss.updateStudent(st)) {
//                out.print("<h2> All updated</h2>");
//            } else {
//                out.print("<h2> Not updated</h2>");
//            }
            out.println((ss.updateStudent(st)==true)?"<h2> All inserted</h2>":"<h2> Not inserted</h2>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
