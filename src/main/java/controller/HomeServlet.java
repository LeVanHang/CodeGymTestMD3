package controller;

import dao.config.StudentDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Student;
import service.ClassRoomService;
import service.StudentService;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;

@WebServlet(urlPatterns = "/home")
public class HomeServlet extends HttpServlet {
    StudentService studentService = new StudentService();
    ClassRoomService classRoomService = new ClassRoomService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        int id = Integer.parseInt(req.getParameter("id"));

        if (action == null) {
            action = "";
        }
        RequestDispatcher requestDispatcher;
        switch (action) {
            case "edit":
                for (Student p: StudentDAO.getAll()) {
                    if (p.getId() == id){
                        req.setAttribute("student", p);
                    }
                }
                RequestDispatcher dispatcher = req.getRequestDispatcher("/editStudent.jsp");
                dispatcher.forward(req,resp);
                break;
            case "delete":
                StudentDAO.deleteStudent(id);
                resp.sendRedirect("/home");
                break;
            case "create":
                req.setAttribute("listClass", classRoomService.getAll());
                requestDispatcher = req.getRequestDispatcher("/view/createStudent.jsp");
                requestDispatcher.forward(req, resp);
                break;
            default:
                req.setAttribute("listStudent", studentService.getAll());
                requestDispatcher = req.getRequestDispatcher("/view/showStudent.jsp");
                requestDispatcher.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if (action == null) {
            action = "";
        }

        RequestDispatcher requestDispatcher;

        switch (action) {
            case "edit":
                int id = Integer.parseInt(req.getParameter("id"));
                String name = req.getParameter("name");
                String address = req.getParameter("address");
                Date birthday = Date.valueOf(req.getParameter("birthday"));
                String phone = req.getParameter("phone");
                String email = req.getParameter("email");
                int calssroom = req.getIntHeader("calassroom");
                StudentDAO.editStudent(new Student(id,name,address, birthday.toLocalDate(),phone,email,calssroom));
                resp.sendRedirect("/product");

            case "create":
                String name = req.getParameter("name");
                String address = req.getParameter("address");
                LocalDate birthday = LocalDate.parse(req.getParameter("date"));
                String phone = req.getParameter("phone");
                String email = req.getParameter("email");
                int idClassRoom = Integer.parseInt(req.getParameter("idClassRoom"));

                studentService.save(new Student(name, address, birthday, phone, email, idClassRoom));
                resp.sendRedirect("/home");
                break;

            case "search":
                String nameSearch = req.getParameter("search");
                req.setAttribute("listStudent", studentService.findByName(nameSearch));
                requestDispatcher = req.getRequestDispatcher("/view/showStudent.jsp");
                requestDispatcher.forward(req, resp);
                break;
        }

    }
}
