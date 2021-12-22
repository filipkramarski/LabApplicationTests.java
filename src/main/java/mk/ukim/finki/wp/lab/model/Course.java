package mk.ukim.finki.wp.lab.model;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class Course {

    private Long courseId;
    private String name;
    private String description;
    private Student students;
    private Teacher teacher;

    public Course (String name, String description, Student student, Teacher teacher) {
        this.courseId = (long) (Math.random() * 1000);
        this.name = name;
        this.description = description;
        this.students = students;
        this.teacher = teacher;
    }
}
