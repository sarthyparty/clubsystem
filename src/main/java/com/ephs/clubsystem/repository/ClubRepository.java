package com.ephs.clubsystem.repository;

import com.ephs.clubsystem.model.Club;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClubRepository extends CrudRepository<Club, Integer> {
    @Query("SELECT s FROM Club s WHERE s.name = :name")
    public List<Club> findByName(String name);
}
