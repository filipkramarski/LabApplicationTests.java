package mk.ukim.finki.wp.lab.bootstrap;

import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.model.Student;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {

    public static List<Student> students = new ArrayList<>();
    public static List<Course> courses = new ArrayList<>(10);

    @PostConstruct
    public void init() {
        students.add(new Student("FilipKramarski","Zelka","Filip","Kramarski"));
        students.add(new Student("AnaTodorovska","Anna","Ana","Todorovska"));

        courses.add(new Course(1233331323L, "APS","II",students));
        courses.add(new Course(1232323323L, "VP","III",students));
        courses.add(new Course(1232332223L, "SI","III",students));
    }
}
