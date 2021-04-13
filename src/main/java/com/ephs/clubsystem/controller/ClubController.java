package com.ephs.clubsystem.controller;
import com.ephs.clubsystem.model.Club;
import com.ephs.clubsystem.model.User;
import com.ephs.clubsystem.repository.ClubRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
@Controller
@Service
@RequestMapping(path="/club")
public class ClubController {
    @Autowired
    private ClubRepository clubRepository;

    @PostMapping(path = "") // Map ONLY POST Requests
    public @ResponseBody
    String addNewClub(@RequestParam String name, @RequestParam String template, @RequestParam String defaults) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        if (clubRepository.findByName(name).size()==0) {
            Club n = new Club();
            n.setName(name);
            n.setDefaults(defaults);
            n.setTemplate(template);
            clubRepository.save(n);
            return "Saved";
        } else {
            return "Name in use.";
        }
    }
    @GetMapping(path="/all")
    public @ResponseBody Iterable<Club> getAllClubs() {
        // This returns a JSON or XML with the users
        return clubRepository.findAll();
    }

    }

