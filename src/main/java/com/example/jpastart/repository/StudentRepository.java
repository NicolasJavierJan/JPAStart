package com.example.jpastart.repository;

import com.example.jpastart.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository <Student, Integer> {
    // You don't need anything else.
    // Just call studentRepository.save(//object//) and it will save!

    Optional<Student> findByName(String name);
}
