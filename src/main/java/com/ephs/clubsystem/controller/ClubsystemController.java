package com.ephs.clubsystem.controller;

import com.ephs.clubsystem.model.User;
import com.ephs.clubsystem.model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;


@Controller
@Service
public class ClubsystemController {

    @GetMapping ("/")
    public String Info() { return "Welcome to the REST API for a club management system!"; }

    @GetMapping ("/hello")
    public String getHello(@RequestParam(value = "name") String name)
    {
        return name +" is crazy";
    }

}
