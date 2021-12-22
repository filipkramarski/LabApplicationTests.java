package mk.ukim.finki.wp.lab.bootstrap;

import lombok.Getter;
import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.model.Student;
import mk.ukim.finki.wp.lab.model.Teacher;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@Getter
public class DataHolder {

    public static List<Student> students = new ArrayList<>();
    public static List<Course> courses = new ArrayList<>(10);
    public static List<Teacher> teachers = new ArrayList<>();

    @PostConstruct
    public void init() {
        students.add(new Student("FilipKramarski","Zelka","Filip","Kramarski"));

        Student student = new Student("AnaTodorovska","Ana","Ana","Todorovska");
        Teacher teacher = new Teacher("Ana","Ananas");
        teachers.add(teacher);
        courses.add(new Course("APS","II",student, teacher));
        courses.add(new Course("VP","III",student, teacher));
        courses.add(new Course("SI","III",student, teacher));

        teachers.add(new Teacher("Filip","Filipov"));
        teachers.add(new Teacher("Ana","DeArmas"));
        teachers.add(new Teacher("Ana","Marija"));
        teachers.add(new Teacher("Marija","Ana"));
        teachers.add(new Teacher("Stefan","Stefanov"));
    }
}
