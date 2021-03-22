package com.ephs.clubsystem.student;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {
    @Query("SELECT s FROM Student s WHERE s.email = :email")
    public List<Student> findByEmail(String email);
}
