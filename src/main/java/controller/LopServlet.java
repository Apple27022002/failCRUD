package controller;

import model.Lop;
import service.LopService;
import service.LopServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "LopServler", value = "/Lops")
public class LopServlet extends HttpServlet {
    LopService lopService =new LopServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action =request.getParameter("act");
        if (action==null) {
            action="";
        }switch (action){
            default:
                showList(request,response);
        }
        request.getRequestDispatcher("list.jsp").forward(request,response);
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Lop> lops = lopService.findAll();
        request.setAttribute("ds",lops);
        request.getRequestDispatcher("Lop/list.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
