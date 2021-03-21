package com.ephs.clubsystem.controller;


import com.ephs.clubsystem.model.Student;
import com.ephs.clubsystem.model.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@Controller
@Service
@RequestMapping(path="/student")
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    @PostMapping(path="/add") // Map ONLY POST Requests
    public @ResponseBody
    String addNewUser (@RequestParam String name
            , @RequestParam String email) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        Student n = new Student();
        n.setName(name);
        n.setEmail(email);
        studentRepository.save(n);
        return "Saved";
    }
    @GetMapping(path="/all")
    public @ResponseBody Iterable<Student> getAllUsers() {
        // This returns a JSON or XML with the users
        return studentRepository.findAll();
    }
}
