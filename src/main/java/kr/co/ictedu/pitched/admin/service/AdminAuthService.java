package kr.co.ictedu.pitched.admin.service;


import kr.co.ictedu.pitched.admin.dto.AdminAuthDto;
import kr.co.ictedu.pitched.admin.dao.AdminAuthDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Service layer for admin authentication logic.
 * This service interacts with the AdminMapper to query the PostgreSQL database.
 */
@Service
@RequiredArgsConstructor
public class AdminAuthService {

    private final AdminAuthDao adminAuthDao;

    /**
     * Authenticates an admin based on username and password.
     * @param username The admin's username.
     * @param password The admin's password.
     * @return true if credentials are valid, false otherwise.
     */
    public boolean authenticate(String username, String password) {
        // Find the admin by username in the PostgreSQL database
        Optional<AdminAuthDto> adminOptional = adminAuthDao.findByUsername(username);

        // Check if an admin was found and if the password matches
        if (adminOptional.isPresent()) {
            AdminAuthDto admin = adminOptional.get();
            // IMPORTANT: This is a plain text password comparison.
            // In a real production application, you MUST use a secure password hashing
            // library like Spring Security's BCryptPasswordEncoder.
            return admin.getPassword().equals(password);
        }

        return false; // Admin not found
    }
}

