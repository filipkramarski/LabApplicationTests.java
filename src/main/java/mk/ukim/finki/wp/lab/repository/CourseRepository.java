package mk.ukim.finki.wp.lab.repository;

import java.util.ArrayList;
import java.util.List;
import java.lang.Long;
import java.util.stream.Collectors;

import mk.ukim.finki.wp.lab.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.model.Student;
import org.springframework.stereotype.Repository;


@Repository
public class CourseRepository {


    public List<Course> findAllCourses(){
        return DataHolder.courses;
    }

    public Course findById(Long courseId){
        return DataHolder.courses.stream().filter(r->r.getCourseId().equals(courseId)).findFirst().orElse(null);
    }

    public List<Student> findAllStudentsByCourse(Long courseId){
       List<Course> courses = DataHolder.courses.stream().filter(r->
            r.getCourseId().equals(courseId)).collect(Collectors.toList());
       List<Student> students=new ArrayList<>();
        for (Course course: courses) {
            students.addAll(course.getStudents());
        }
        return students;
        }

    public Course addStudentToCourse(Student student, Course course) {

        for (Course c: DataHolder.courses) {
            if(c.getCourseId().equals(course.getCourseId()))
            {
                c.getStudents().add(student);
                return c;
            }
        }
        return null;
    }
}
