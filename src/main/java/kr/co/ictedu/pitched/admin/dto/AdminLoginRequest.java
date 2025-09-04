package kr.co.ictedu.pitched.admin.dto;

import lombok.Data;
//specific and limited job: to model the JSON payload of a login request from your admin React frontend.
@Data
public class AdminLoginRequest {
    private String username;
    private String password;
}
