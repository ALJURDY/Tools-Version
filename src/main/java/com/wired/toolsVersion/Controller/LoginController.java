package com.wired.toolsVersion.Controller;

import com.wired.toolsVersion.User.UserEntity;
import com.wired.toolsVersion.User.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/login")
@RestController
public class LoginController {

    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<?> getLoginPage() {
        // This can return a simple message or a view name if you use a template engine
        return ResponseEntity.ok().body("{\"message\": \"Please log in\"}");
    }

    @PostMapping
    public ResponseEntity<?> login(@RequestBody UserEntity loginUser) {
        System.out.println("Login attempt for user: " + loginUser.getUsername());
        UserEntity user = userService.findByUsername(loginUser.getUsername());
        if (user != null && user.getPassword().equals(loginUser.getPassword())) {
            System.out.println("Login successful for user: " + loginUser.getUsername());
            // Authentication successful
            return ResponseEntity.ok().body("{\"message\": \"Login successful\"}");
        } else {
            System.out.println("Login failed for user: " + loginUser.getUsername());
            // Authentication failed
            return ResponseEntity.status(401).body("{\"error\": \"Invalid username or password\"}");
        }
    }
}