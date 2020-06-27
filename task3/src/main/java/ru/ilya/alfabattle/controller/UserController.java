package ru.ilya.alfabattle.controller;

import ru.ilya.alfabattle.model.UserModel;
import ru.ilya.alfabattle.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class UserController {

    private UserRepository userRespository;

    @Autowired
    public UserController(UserRepository userRespository) {
        this.userRespository = userRespository;
    }

    @GetMapping("/user/all")
    Iterable<UserModel> all() {
        return userRespository.findAll();
    }

    @GetMapping("/user/{id}")
    UserModel userById(@PathVariable Long id) {
        return userRespository.findById(id).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND));
    }

    @PostMapping("/user/save")
    UserModel save(@RequestBody UserModel user) {
        return userRespository.save(user);
    }

}
