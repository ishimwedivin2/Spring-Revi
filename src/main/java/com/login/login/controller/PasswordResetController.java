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


//http://localhost:8080/password/forgot?email=user@example.com
//http://localhost:8080/password/reset?token=YOUR_TOKEN&newPassword=new123
