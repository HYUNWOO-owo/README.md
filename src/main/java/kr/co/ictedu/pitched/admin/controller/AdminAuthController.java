package kr.co.ictedu.pitched.admin.controller;

import kr.co.ictedu.pitched.admin.dto.AdminLoginRequest;
import kr.co.ictedu.pitched.admin.service.AdminAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller dedicated to handling Admin authentication.
 * Its primary responsibility is to expose the login endpoint.
 * This controller communicates with the PostgreSQL database via the AdminAuthService.
 */
@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor // Lombok annotation to create a constructor for all final fields
public class AdminAuthController {

    private final AdminAuthService adminAuthService;

    /**
     * Handles the admin login request.
     * @param loginRequest DTO containing the username and password.
     * @return ResponseEntity indicating success or failure. In a real app, this would return a JWT.
     */
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AdminLoginRequest loginRequest) {
        boolean isAuthenticated = adminAuthService.authenticate(loginRequest.getUsername(), loginRequest.getPassword());

        if (isAuthenticated) {
            // In a real application, you would generate and return a JWT (JSON Web Token) here.
            return ResponseEntity.ok().body("Admin authenticated successfully.");
        } else {
            return ResponseEntity.status(401).body("Invalid credentials.");
        }
    }
}
