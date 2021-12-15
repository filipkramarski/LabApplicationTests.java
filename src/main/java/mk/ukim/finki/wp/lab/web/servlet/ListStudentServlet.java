package mk.ukim.finki.wp.lab.web.servlet;

import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.service.StudentService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ListStudent", urlPatterns = "/AddStudent")
public class ListStudentServlet extends HttpServlet {

    StudentService studentService;
    private final SpringTemplateEngine springTemplateEngine;

    public ListStudentServlet (StudentService studentService, SpringTemplateEngine springTemplateEngine) {
        this.studentService = studentService;
        this.springTemplateEngine = springTemplateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebContext context = new WebContext(req, resp, req.getServletContext());
        context.setVariable("AddStudent", this.studentService.listAll());
        this.springTemplateEngine.process("listStudents.html",context,resp.getWriter());
    }

    @Override
     protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebContext context = new WebContext(req, resp, req.getServletContext());
        String courseId = req.getParameter("courseId");
/*         if(courseId==null)
            {
                resp.sendRedirect("/listCourses");
            }*/
        req.getSession().setAttribute("courseId", courseId);
        context.setVariable("AddStudent", this.studentService.listAll());
        this.springTemplateEngine.process("listStudents.html",context,resp.getWriter());
    }

    }

