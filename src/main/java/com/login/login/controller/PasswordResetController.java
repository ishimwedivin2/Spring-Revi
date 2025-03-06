package com.login.login.controller;

import com.login.login.service.PasswordResetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/password")
public class PasswordResetController {
    @Autowired
    private PasswordResetService passwordResetService;

    @PostMapping("/forgot")
    public ResponseEntity<String> forgotPassword(@RequestParam String email) {
        passwordResetService.createPasswordResetToken(email);
        return ResponseEntity.ok("Password reset link sent to email.");
    }

    @PostMapping("/reset")
    public ResponseEntity<String> resetPassword(@RequestParam String token, @RequestParam String newPassword) {
        if (!passwordResetService.validateResetToken(token)) {
            return ResponseEntity.badRequest().body("Invalid or expired token.");
        }
        passwordResetService.resetPassword(token, newPassword);
        return ResponseEntity.ok("Password has been reset successfully.");
    }
}
//
//
//http://localhost:8080/password/forgot?email=user@example.com
//http://localhost:8080/password/reset?token=YOUR_TOKEN&newPassword=new123
//
//        3. Testing
//1. Request Password Reset
//Send a POST request to:
//
//        ✅ Check your email for the reset link.
//
//2. Reset Password
//Send a POST request to:
//
//        ✅ Now, login with the new password!
//
//        4. Summary
//✔ User requests reset link → Email sent
//✔ User clicks link → System validates token
//✔ User resets password → System updates it
//
//This method ensures security and follows best practices for password reset functionality in Spring Boot. 🚀 Let me know if you need modifications!
//
//        3. Testing
//1. Request Password Reset
//Send a POST request to:
//
//bash
//        Copy
//Edit
//http://localhost:8080/password/forgot?email=user@example.com
//        ✅ Check your email for the reset link.
//
//2. Reset Password
//Send a POST request to:
//
//bash
//        Copy
//Edit
//http://localhost:8080/password/reset?token=YOUR_TOKEN&newPassword=new123
//        ✅ Now, login with the new password!
//
//        4. Summary
//✔ User requests reset link → Email sent
//✔ User clicks link → System validates token
//✔ User resets password → System updates it
//
//This method ensures security and follows best practices for password reset functionality in Spring Boot. 🚀 Let me know if you need modifications!