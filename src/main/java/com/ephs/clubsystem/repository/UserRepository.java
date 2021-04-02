package com.ephs.clubsystem.repository;

import com.ephs.clubsystem.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    @Query("SELECT s FROM User s WHERE s.email = :email")
    public List<User> findByEmail(String email);

    @Query("SELECT s FROM User s WHERE s.id = :id")
    public List<User> findById(long id);
}
