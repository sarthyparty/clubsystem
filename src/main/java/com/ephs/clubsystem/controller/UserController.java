package com.ephs.clubsystem.controller;

import com.ephs.clubsystem.model.User;
import com.ephs.clubsystem.repository.UserRepository;
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

@CrossOrigin
@Controller
@Service
@RequestMapping(path="/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping(path="") // Map ONLY POST Requests
    public @ResponseBody
    String addNewUser (@RequestParam String name
            , @RequestParam String email, @RequestParam String password) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        if (userRepository.findByEmail(email).size()==0) {
            User n = new User();
            n.setName(name);
            n.setEmail(email);
            n.setPassword(password);
            userRepository.save(n);
            return "Saved";
        } else {
            return "Email in use.";
        }
    }
    @PostMapping(path="/login") // Map ONLY POST Requests
    public @ResponseBody
    String login (@RequestParam String email
            , @RequestParam String password) {
        List<User> s = userRepository.findByEmail(email);
        String msg = "Login Failed";
        if (s.size()==0) {
            return msg;
        } else {
            if (s.get(0).getPassword().equals(password)) {
                String token = getJWTToken(email);
                return s.get(0).toString() + "\n" + token;
            } else {
                return "Login Failed";
            }
        }
    }
    @GetMapping(path="/{id}")
    public @ResponseBody
    String getUser(@PathVariable long id) {
        return userRepository.findById(id).get(0).toString();
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        // This returns a JSON or XML with the users
        return userRepository.findAll();
    }
    private String getJWTToken(String username) {
        String secretKey = "mySecretKey";
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList("ROLE_USER");

        String token = Jwts
                .builder()
                .setId("softtekJWT")
                .setSubject(username)
                .claim("authorities",
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 600000))
                .signWith(SignatureAlgorithm.HS512,
                        secretKey.getBytes()).compact();

        return "Bearer " + token;
    }
}
