package mk.ukim.finki.wp.lab.web.servlet;

import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.model.Student;
import mk.ukim.finki.wp.lab.service.CourseService;
import mk.ukim.finki.wp.lab.service.StudentService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.parser.Parser;
import java.io.IOException;

@WebServlet(name = "studentEnrollmentSummary", urlPatterns = "/StudentEnrollmentSummary")
public class StudentEnrollmentSummary extends HttpServlet {

    StudentService studentService;
    CourseService courseService;
    SpringTemplateEngine springTemplateEngine;

    public StudentEnrollmentSummary(StudentService studentService, SpringTemplateEngine springTemplateEngine,
                                    CourseService courseService) {
        this.studentService = studentService;
        this.courseService = courseService;
        this.springTemplateEngine = springTemplateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebContext context = new WebContext(req, resp, req.getServletContext());
        this.springTemplateEngine.process("studentsInCourse.html",context,resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebContext context = new WebContext(req, resp, req.getServletContext());
        String name = req.getParameter("name");
        String courseId = (String) req.getSession().getAttribute("courseId");
        String course = this.courseService.findAll().stream().filter(c -> c.getCourseId().toString()
                .equals(courseId)).findFirst().get().getName();
        req.getSession().setAttribute("name", name);
        context.setVariable("course",course);
        this.springTemplateEngine.process("studentsInCourse.html",context,resp.getWriter());
    }
}
