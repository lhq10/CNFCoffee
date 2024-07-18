package edu.mum.service;


import edu.mum.dtos.authDtos.LoginDto;
import edu.mum.dtos.authDtos.RegisterDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.view.RedirectView;

public interface AuthService {
    ResponseEntity<?> register(RegisterDto registerDto);
    ResponseEntity<?> login(LoginDto login);
    public void logout(HttpServletRequest request);
    RedirectView activeAccount(String code, String email);
    ResponseEntity<?> forgotPassword(String email);
}
