package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.model.Student;
import mk.ukim.finki.wp.lab.model.Teacher;

import java.util.List;
import java.util.Optional;

public interface CourseService {
        List<Student> listStudentsByCourse(Long courseId);
        Course addStudentInCourse(String username, Long courseId);
        List<Course> findAll();
        Optional<Course> save(String name, String description, Long teacherId);
        Optional<Course> findById(Long id);
        void deleteById(Long id);
}
