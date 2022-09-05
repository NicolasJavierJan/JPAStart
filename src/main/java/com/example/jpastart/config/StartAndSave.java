package com.example.jpastart.config;

import com.example.jpastart.model.Student;
import com.example.jpastart.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

// Created and detected by Spring
@Component
public class StartAndSave implements CommandLineRunner {
    // Alt insert to implement methods!

    @Autowired
    StudentRepository studentRepository;

    @Override
    public void run(String... args) throws Exception {
        Student nico = new Student();
        nico.setBorn(LocalDate.now());
        nico.setName("Nico");

        studentRepository.save(nico);

        Student and = new Student();
        and.setBorn(LocalDate.now().minusDays(3));
        and.setName("Andrea");

        studentRepository.save(and);
    }
}
