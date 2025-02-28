package com.login.login.controller;

import com.login.login.model.User;
import com.login.login.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController  // Changed to RestController for API responses
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public ResponseEntity<User> showRegistrationForm() {
        return ResponseEntity.ok(new User());
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        user.setRole("USER"); // Default role is USER
        userService.register(user);
        return ResponseEntity.ok("User registered successfully");
    }

    @GetMapping("/login")
    public ResponseEntity<User> showLoginForm() {
        return ResponseEntity.ok(new User());
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        Optional<User> loggedInUser = userService.login(user.getUsername(), user.getPassword());
        if (loggedInUser.isPresent()) {
            return ResponseEntity.ok(loggedInUser.get());
        } else {
            return ResponseEntity.badRequest().body("Invalid username or password");
        }
    }
}










//package com.login.login.controller;
//
//import com.login.login.model.User;
//import com.login.login.service.UserService;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Optional;
//
//@Controller
//@RequestMapping("/auth")
//public class AuthController {
//
//    private final UserService userService;
//
//    public AuthController(UserService userService) {
//        this.userService = userService;
//    }
//
//    @GetMapping("/register")
//    public String showRegistrationForm(Model model) {
//        model.addAttribute("user", new User());
//        return "register";
//    }
//
//    @PostMapping("/register")
//    public String register(@ModelAttribute("user") User user) {
//        user.setRole("USER"); // Default role is USER
//        userService.register(user);
//        return "redirect:/auth/login";
//    }
//
//    @GetMapping("/login")
//    public String showLoginForm(Model model) {
//        model.addAttribute("user", new User());
//        return "login";
//    }
//
//    @PostMapping("/login")
//    public String login(@ModelAttribute User user, Model model) {
//        Optional<User> loggedInUser = userService.login(user.getUsername(), user.getPassword());
//        if (loggedInUser.isPresent()) {
//            if (loggedInUser.get().getRole().equals("ADMIN")) {
//                return "redirect:/admin/dashboard";
//            } else {
//                return "redirect:/user/dashboard";
//            }
//        } else {
//            model.addAttribute("error", "Invalid username or password");
//            return "login";
//        }
//    }
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
////package com.login.login.controller;
////
////
////import com.login.login.model.User;
////import com.login.login.service.UserService;
////import org.springframework.stereotype.Controller;
////import org.springframework.ui.Model;
////import org.springframework.web.bind.annotation.*;
////
////import java.util.Optional;
////
////@RestController
////@Controller
////@RequestMapping("/auth")
////public class AuthController {
////
////    private final UserService userService;
////
////    public AuthController(UserService userService) {
////        this.userService = userService;
////    }
////
////    @GetMapping("/register")
////    public String showRegistrationForm() {
////        model.addAttribute("user", new User());
////        return "register";
////    }
////
////    @PostMapping("/register")
////    public String register(@ModelAttribute("user") User user) {
////
////        user.setRole("USER"); // Default role is USER
////        userService.register(user);
////        return "redirect:/auth/login";
////
////
////    }
////
////    @GetMapping("/login")
////    public String showLoginForm(Model model) {
////        model.addAttribute("user", new User());
////        return "login";
////    }
////
////    @PostMapping("/login")
////    public String login(@ModelAttribute User user, Model model) {
////        Optional<User> loggedInUser = userService.login(user.getUsername(), user.getPassword());
////        if (loggedInUser.isPresent()) {
////            if (loggedInUser.get().getRole().equals("ADMIN")) {
////                return "redirect:/admin/dashboard";
////
////            } else  {
////                return "redirect:/user/dashboard";
////            } else {
////                model.addAttribute("error","Invalid username or password");
////                return "login";
////            }
////        }
////    }
////
////
////
////
////
////}
