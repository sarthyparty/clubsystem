package com.ephs.clubsystem.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Service
@RequestMapping(path="/student")
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    @PostMapping(path="/register") // Map ONLY POST Requests
    public @ResponseBody
    String addNewUser (@RequestParam String name
            , @RequestParam String email, @RequestParam String password) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        if (studentRepository.findByEmail(email).size()==0) {
            Student n = new Student();
            n.setName(name);
            n.setEmail(email);
            n.setPassword(password);
            studentRepository.save(n);
            return "Saved";
        } else {
            return "Email in use.";
        }
    }
    @PostMapping(path="/login") // Map ONLY POST Requests
    public @ResponseBody
    String login (@RequestParam String email
            , @RequestParam String password) {
        List<Student> s = studentRepository.findByEmail(email);
        String msg = "Login Failed";
        if (s.size()==0) {
            return msg;
        } else {
            if (s.get(0).getPassword().equals(password)) {
                return s.toString();
            } else {
                return "Login Failed";
            }
        }
    }
    @GetMapping(path="/all")
    public @ResponseBody Iterable<Student> getAllUsers() {
        // This returns a JSON or XML with the users
        return studentRepository.findAll();
    }
}
