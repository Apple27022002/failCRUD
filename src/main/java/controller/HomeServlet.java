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
import java.util.List;

@WebServlet(name = "HomeServlet", value = "/home")
    public class HomeServlet extends HttpServlet {
        LopService lopService =new LopServiceImpl();
        StudentService studentService=new StudentServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Lop> lops = lopService.findAll();
        request.setAttribute("lops",lops);
        List<Student> students = studentService.findAll();
        request.setAttribute("students", students);
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
