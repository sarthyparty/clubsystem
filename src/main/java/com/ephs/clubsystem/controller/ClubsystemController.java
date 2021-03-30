package com.ephs.clubsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;


@Controller
@Service
public class ClubsystemController {

    @GetMapping ("/")
    public @ResponseBody String Info() { return "Welcome to the REST API for a club management system!"; }

    @GetMapping ("/hello")
    public @ResponseBody String getHello(@RequestParam(value = "name") String name)
    {
        return name +" is crazy";
    }

}
