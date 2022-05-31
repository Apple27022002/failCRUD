package controller;

import model.Lop;
import model.Student;
import service.LopService;
import service.LopServiceImpl;
import service.StudentService;
import service.StudentServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "StudentServlet", value = "/students")
public class StudentServlet extends HttpServlet {
    LopService lopService = new LopServiceImpl();
    StudentService studentService = new StudentServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("act");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateForm(request, response);
                break;
            case "view":
                showView(request,response);
                break;
            case "delete":
                showDelete(request,response);
            default:
                showList(request, response);
        }
    }

    private void showDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Lop> lops = lopService.findAll();
        request.setAttribute("lops", lops);
        int id = Integer.parseInt(request.getParameter("id"));
        Student student = studentService.findById(id);
        request.setAttribute("delete", student);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("student/delete.jsp");
        requestDispatcher.forward(request, response);
    }


    private void showView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Lop> lops = lopService.findAll();
        request.setAttribute("lops", lops);
        int id = Integer.parseInt(request.getParameter("id"));
        List<Student> students = studentService.findAll();
        request.setAttribute("student", students);
        request.getRequestDispatcher("Student/view.jsp").forward(request, response);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Lop> lops = lopService.findAll();
        request.setAttribute("lops", lops);
        request.getRequestDispatcher("Student/create.jsp").forward(request, response);
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> students = studentService.findAll();
        request.setAttribute("ds", students);
        request.getRequestDispatcher("Student/list.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("act");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                try {
                    create(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            case"delete":{
                delete(request,response);
            }
            default:
                showList(request, response);
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        studentService.delete(id);
        response.sendRedirect("/home");
    }

    private void create(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        int classId = Integer.parseInt(request.getParameter("classId"));
        Lop clazz = lopService.findById(classId);
        studentService.add(new Student(0, name, clazz,  age));
    }

}
