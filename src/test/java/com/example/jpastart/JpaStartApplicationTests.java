package com.example.jpastart;

import com.example.jpastart.model.Student;
import com.example.jpastart.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

// Normally SpringBootTest. Changed to "DataJpaTest" to make it work in the cloud.
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class JpaStartApplicationTests {

    @Autowired
    StudentRepository studentRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void testStudent(){
        Student nico = new Student();
        nico.setBorn(LocalDate.now());
        nico.setName("Nico");
        studentRepository.save(nico);

        List<Student> lst = studentRepository.findAll();
        assertEquals(1, lst.size());

        studentRepository.delete(nico);
        lst = studentRepository.findAll();
        assertEquals(0, lst.size());

        // Wrapper for the case that the query returns null
        Optional<Student> id1 = studentRepository.findById(1);
        if (id1.isPresent()){
            Student std = id1.get();
            assertEquals(std.getName(), "Nico");
        }

        Optional<Student> name1 = studentRepository.findByName("Nico");
        if (name1.isPresent()){
            Student std = id1.get();
            assertEquals(std.getName(), "Nico");
        }


    }

}
