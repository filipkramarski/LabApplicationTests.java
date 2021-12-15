package mk.ukim.finki.wp.lab.model;

import com.fasterxml.jackson.databind.deser.std.StringArrayDeserializer;
import lombok.Data;

import java.util.List;
@Data
public class Course {

    private Long courseId;
    private String name;
    private String description;
    private List<Student> students;
    private List<Teacher> teacher;

    public Course (Long courseId, String name, String description, List<Student> students, List<Teacher> teacher) {
        this.courseId = (long) (Math.random() * 1000);
        this.name = name;
        this.description = description;
        this.students = students;
        this.teacher = teacher;
    }
}
