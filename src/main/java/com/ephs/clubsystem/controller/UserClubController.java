package com.ephs.clubsystem.controller;

import com.ephs.clubsystem.model.Club;
import com.ephs.clubsystem.model.User;
import com.ephs.clubsystem.model.UserClubRelationship;
import com.ephs.clubsystem.repository.ClubRepository;
import com.ephs.clubsystem.repository.UserClubRelationshipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@Controller
@Service
@RequestMapping(path="/userclub")
public class UserClubController {
    @Autowired
    private UserClubRelationshipRepository userClubRelationshipRepository;

    @PostMapping(path = "") // Map ONLY POST Requests
    public @ResponseBody
    String addNewClub(@RequestParam String code, @RequestParam long id) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        List<Club> club = userClubRelationshipRepository.findClub(code);
        List<User> user = userClubRelationshipRepository.findUser(id);

        if (club.size() != 1 || user.size() != 1) {
            return "Club and/or user not found.";
        } else {
            UserClubRelationship ucr = new UserClubRelationship(user.get(0), club.get(0));
            ucr.setAdmin(false);
            userClubRelationshipRepository.save(ucr);
            return ucr.toString();
        }
    }
}
