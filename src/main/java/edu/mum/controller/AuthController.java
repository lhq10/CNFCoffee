package edu.mum.controller;




import edu.mum.dtos.authDtos.LoginDto;
import edu.mum.dtos.authDtos.RegisterDto;
import edu.mum.service.AuthService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody RegisterDto registerDto){
        return authService.register(registerDto);
    }

    @PostMapping("/log-in")
    public ResponseEntity logIn (@RequestBody LoginDto login) {
        return authService.login(login);
    }

    @GetMapping("/log-out")
    public void logOut(HttpServletRequest request){
        authService.logout(request);
    }

    @GetMapping("/active")
    public RedirectView active(@RequestParam("code") String code, @RequestParam("email") String email){
        return authService.activeAccount(code,email);
    }

    @GetMapping("/forgot-password")
    public ResponseEntity<?> forgotPassword(@RequestParam String email){
        return authService.forgotPassword(email);
    }

}
