package mk.ukim.finki.wp.lab.service.Impl;

import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.model.Student;
import mk.ukim.finki.wp.lab.model.Teacher;
import mk.ukim.finki.wp.lab.model.exceptions.TeacherNotFoundException;
import mk.ukim.finki.wp.lab.repository.CourseRepository;
import mk.ukim.finki.wp.lab.repository.StudentRepository;
import mk.ukim.finki.wp.lab.repository.TeacherRepository;
import mk.ukim.finki.wp.lab.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;
    private final TeacherRepository teacherRepository;

    public CourseServiceImpl(CourseRepository courseRepository, StudentRepository studentRepository, TeacherRepository teacherRepository) {
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
        this.teacherRepository = teacherRepository;
    }

    @Override
    public List<Student> listStudentsByCourse (Long courseId) {
        return courseRepository.findAllStudentsByCourse(courseId);
    }

    @Override
    public Course addStudentInCourse(String username, Long courseId) {
        return null;
    }

    //@Override
   /* public Course addStudentInCourse (String username, Long courseId) {
        Course course=courseRepository.findById(courseId);
        Student student = studentRepository.findAllStudents().stream()
                .filter(s->s.getUsername().equals(username)).findAny().orElse(null);
            return courseRepository.addStudentToCourse(student, course);

    }*/

    @Override
    public List<Course> findAll () {
        return courseRepository.findAllCourses();
    }

    @Override
    public Optional<Course> save(String name, String description, Long teacherId) {

        Teacher teacher = this.teacherRepository.findById(teacherId).orElseThrow(()->new TeacherNotFoundException(teacherId));
        return this.courseRepository.save(name,description,teacher);
    }

    @Override
    public Optional<Course> findById(Long id) {
        return this.courseRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        this.courseRepository.deleteById(id);
    }
}
