package mk.ukim.finki.wp.lab.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.lang.Long;
import java.util.Optional;
import java.util.stream.Collectors;

import mk.ukim.finki.wp.lab.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.model.Student;
import mk.ukim.finki.wp.lab.model.Teacher;
import org.springframework.stereotype.Repository;


@Repository
public class CourseRepository {


    public List<Course> findAllCourses(){
        return DataHolder.courses;
    }


    public List<Student> findAllStudentsByCourse(Long courseId){
       List<Course> courses = DataHolder.courses.stream().filter(r->
            r.getCourseId().equals(courseId)).collect(Collectors.toList());
       List<Student> students=new ArrayList<>();
        for (Course course: courses) {
            students.addAll((Collection<? extends Student>) course.getStudents());
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

    public Optional<Course> save(String name, String description, Teacher teacher) {
        DataHolder.courses.removeIf(i -> i.getName().equals(name));
        Course course = new Course(name,description,null,teacher);
        DataHolder.courses.add(course);
        return Optional.of(course);
    }

    public Optional<Course> findById(Long courseId) {
        return DataHolder.courses.stream().filter(i -> i.getCourseId().equals(courseId)).findFirst();
    }

    public void deleteById(Long courseId) {
        DataHolder.courses.removeIf(i -> i.getCourseId().equals(courseId));
    }
}
