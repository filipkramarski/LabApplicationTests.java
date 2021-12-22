package mk.ukim.finki.wp.lab.web.servlet;

import mk.ukim.finki.wp.lab.service.CourseService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CourseList", urlPatterns = "/listCourses/cour")
public class CourseListServlet extends HttpServlet {

    CourseService courseService;
    SpringTemplateEngine springTemplateEngine;

    public CourseListServlet (CourseService courseService, SpringTemplateEngine springTemplateEngine) {
        this.courseService = courseService;
        this.springTemplateEngine = springTemplateEngine;
    }

    //@Override
  /*  protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebContext context = new WebContext(req, resp, req.getServletContext());
        context.setVariable("listCourses", this.courseService.findAll());
        this.springTemplateEngine.process("listCourses.html",context,resp.getWriter());
    }*/
}
