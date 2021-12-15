package mk.ukim.finki.wp.lab.bootstrap;

import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.model.Student;
import mk.ukim.finki.wp.lab.model.Teacher;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {

    public static List<Student> students = new ArrayList<>();
    public static List<Course> courses = new ArrayList<>(10);
    public static List<Teacher> teacher = new ArrayList<>();

    @PostConstruct
    public void init() {
        students.add(new Student("FilipKramarski","Zelka","Filip","Kramarski"));
        students.add(new Student("AnaTodorovska","Ana","Ana","Todorovska"));

        courses.add(new Course(1233331323L, "APS","II",students, teacher));
        courses.add(new Course(1232323323L, "VP","III",students, teacher));
        courses.add(new Course(1232332223L, "SI","III",students, teacher));

        teacher.add(new Teacher(1234212125L,"Filip","Filipov"));
        teacher.add(new Teacher(1234212125L,"Ana","DeArmas"));
        teacher.add(new Teacher(1234212125L,"Ana","Marija"));
        teacher.add(new Teacher(1234552125L,"Marija","Ana"));
        teacher.add(new Teacher(1234442125L,"Stefan","Stefanov"));
    }
}
