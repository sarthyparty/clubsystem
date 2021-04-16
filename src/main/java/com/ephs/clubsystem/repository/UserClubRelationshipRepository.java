package com.ephs.clubsystem.repository;

import com.ephs.clubsystem.model.Club;
import com.ephs.clubsystem.model.User;
import com.ephs.clubsystem.model.UserClubRelationship;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserClubRelationshipRepository extends CrudRepository<UserClubRelationship, Integer> {
    @Query("SELECT s FROM UserClubRelationship s WHERE s.club.id = :club_id AND s.user.id = :user_id")
    public List<UserClubRelationship> findById(long club_id, long user_id);

    @Query("SELECT s FROM Club s WHERE s.code = :code")
    public List<Club> findClub(String code);

    @Query("SELECT s FROM User s WHERE s.id = :id")
    public List<User> findUser(long id);
}