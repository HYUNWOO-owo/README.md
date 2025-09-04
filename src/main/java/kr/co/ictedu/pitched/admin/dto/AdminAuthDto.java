package kr.co.ictedu.pitched.admin.dto;
import lombok.Data;

@Data
public class AdminAuthDto {
    private Long id;
    private String username;
    private String password;
    // Add other fields like roles if needed
}


//How It's Used in the Login Process:
//When you attempt to log in, the AdminDao executes a SELECT query against the PostgreSQL admins table.
//
//MyBatis takes the data from the row that matches the username (id, username, password).
//
//It then creates a new Admin object and populates its fields with that data.
//
//This Admin object is returned to the AdminAuthService, which can then easily access the user's information (like the stored password) to complete the authentication check.
//
//In short, it's the object that carries an admin's account details from the database through your application's backend layers.