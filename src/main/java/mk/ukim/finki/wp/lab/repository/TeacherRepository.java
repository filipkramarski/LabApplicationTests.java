package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab.model.Teacher;
import org.springframework.stereotype.Repository;

import javax.xml.crypto.Data;
import java.util.List;
import java.util.Optional;

@Repository
public class TeacherRepository {

    public List<Teacher> findAll(){ return DataHolder.teachers; }

    public Optional<Teacher> findById(Long id) {
        return DataHolder.teachers.stream().filter(i -> i.getId().equals(id)).findFirst();
    }
}
