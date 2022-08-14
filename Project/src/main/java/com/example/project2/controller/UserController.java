package com.example.project2.controller;

import com.example.project2.Service.UserService;
import com.example.project2.model.ApiResponse;
import com.example.project2.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public ResponseEntity getUsers() {
        ArrayList<User> userServiceUser = userService.getUser();
        return ResponseEntity.status(200).body(userServiceUser);
    }

    @PostMapping("/add")
    public ResponseEntity addUsers(@RequestBody @Valid User user, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message, 400));
        }
        userService.addUser(user);
        return ResponseEntity.status(201).body(new ApiResponse("New user added !", 201));

    }

    @PutMapping("/user/{index}")
    public ResponseEntity updateUser(@RequestBody @Valid User user
            , @PathVariable int index, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message, 400));
        }
        userService.updateUser(index, user);
        return ResponseEntity.status(201).body(new ApiResponse("user updated !", 201));
    }

    @DeleteMapping("/user/{index}")
    public ResponseEntity deleteUser(@PathVariable int index) {
        userService.deleteUser(index);
        return ResponseEntity.status(200).body(new ApiResponse("user deleted !", 200));
    }
}
