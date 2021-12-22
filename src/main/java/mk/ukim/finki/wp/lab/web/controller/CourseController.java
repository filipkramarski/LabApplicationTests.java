package mk.ukim.finki.wp.lab.web.controller;

import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.model.Teacher;
import mk.ukim.finki.wp.lab.service.CourseService;
import mk.ukim.finki.wp.lab.service.TeacherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;
    private final TeacherService teacherService;

    public CourseController(CourseService courseService, TeacherService teacherService) {
        this.courseService = courseService;
        this.teacherService = teacherService;
    }
    @GetMapping
    public String getCoursesPage(@RequestParam(required = false) String error, Model model) {
        List<Course> courses = this.courseService.findAll();
        model.addAttribute("courses", courses);
        return "listCourses";
    }
    @GetMapping("/add-form")
    public String addProductPage(Model model) {
        List<Teacher> teachers = this.teacherService.findAll();
        model.addAttribute("teachers", teachers);
        return "add-course";
    }
    @GetMapping("/edit-form/{id}")
    public String editCoursePage(@PathVariable Long id, Model model) {
        if(this.courseService.findById(id).isPresent()){
            Course course = this.courseService.findById(id).get();
            List<Teacher> teachers = this.teacherService.findAll();
            model.addAttribute("teachers", teachers);
            model.addAttribute("course", course);
            return "add-course";
        }
        return "redirect:/courses?error=CourseNotFound";
    }

    @PostMapping("/add")
    public String saveCourse(@RequestParam String name,
                             @RequestParam String description,
                             @RequestParam Long teacher){
        this.courseService.save(name,description,teacher);

        return "redirect:/courses";
    }
    @DeleteMapping("/delete/{id}")
    public String deleteCourse(@PathVariable Long id) {
        this.courseService.deleteById(id);
        return "redirect:/courses";
    }

}
