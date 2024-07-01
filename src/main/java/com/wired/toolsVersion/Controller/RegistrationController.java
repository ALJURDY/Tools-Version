package com.wired.toolsVersion.Controller;

import com.wired.toolsVersion.Model.UserEntity;
import com.wired.toolsVersion.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class RegistrationController {

    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/api/user/register")
    public ResponseEntity<String> registerUser(@RequestBody UserEntity user) {
        userService.saveUser(user);
        return ResponseEntity.ok("User registered successfully");
    }
}
