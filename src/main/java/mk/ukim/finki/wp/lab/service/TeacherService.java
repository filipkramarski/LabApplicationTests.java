package mk.ukim.finki.wp.lab.service;

import java.util.List;
import java.util.Optional;

import mk.ukim.finki.wp.lab.model.Teacher;

public interface TeacherService {

    List<Teacher> findAll();
    Optional<Teacher> findById(Long id);

}
