package mk.ukim.finki.wp.lab.service.Impl;

import mk.ukim.finki.wp.lab.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab.model.Student;
import mk.ukim.finki.wp.lab.repository.StudentRepository;
import mk.ukim.finki.wp.lab.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    public StudentServiceImpl (StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> listAll () {
        return studentRepository.findAllStudents();
    }

    @Override
    public List<Student> searchByNameOrSurname (String text) {
        return studentRepository.findAllByNameOrSurname(text);
    }

    @Override
    public Student save (String username, String password, String name, String surname) {

        Student student = new Student(username,password,name,surname);

        DataHolder.students.removeIf(s->s.equals(student));
        DataHolder.students.add(student);


        return student;
    }
}
