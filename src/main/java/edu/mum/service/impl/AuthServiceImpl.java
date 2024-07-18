package edu.mum.service.impl;


import edu.mum.dtos.authDtos.JwtResponseDto;
import edu.mum.dtos.authDtos.LoginDto;
import edu.mum.dtos.authDtos.RegisterDto;
import edu.mum.dtos.authDtos.TokenResponseDto;
import edu.mum.models.User;
import edu.mum.service.AuthService;
import edu.mum.service.SendEmailService;
import edu.mum.service.UserService;
import edu.mum.service.jwt.JwtAuthenticationFilter;
import edu.mum.service.jwt.JwtService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.RedirectView;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private JwtService jwtService;
    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;
    @Autowired
    private UserService userService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private SendEmailService sendEmailService;

    @Override
    public ResponseEntity<?> register(RegisterDto registerDto) {
        try {
            ResponseEntity<?> createAccountResponse = userService.createAccountUser(registerDto);
            if (!createAccountResponse.getStatusCode().is2xxSuccessful()) {
                return createAccountResponse;
            }
            String hashedEmail = bCryptPasswordEncoder.encode(registerDto.getEmail());
            Resource resource = new ClassPathResource("templates/ActiveAccount.html");
            String htmlContent = new String(FileCopyUtils.copyToByteArray(resource.getInputStream()), StandardCharsets.UTF_8);
            String processedHtmlContent = htmlContent
                    .replace("[[Recipient_Name]]", registerDto.getDisplayName())
                    .replace("[[Link_Active]]", "http://www.localhost:8081/auth/active?code=" + hashedEmail + "&email=" + URLEncoder.encode(registerDto.getEmail(), StandardCharsets.UTF_8));
            sendEmailService.sendEmail(registerDto.getEmail(),
                    "Link Activate account",
                    processedHtmlContent);
            return ResponseEntity.ok().body("Check Email to activate account");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @Override
    public ResponseEntity<?> login(LoginDto login) {
        try {
            User user = userService.checkUser(login.getEmail());
            if(user == null ){
                return ResponseEntity.badRequest().body("Account not is exists");
            }
            if (user.getPermission().equals("Activate")) {
                Authentication authentication = authenticationManager.authenticate(new
                        UsernamePasswordAuthenticationToken(login.getEmail(), login.getPassword()));
                SecurityContextHolder.getContext().setAuthentication(authentication);
                TokenResponseDto tokenResponseDto = jwtService.generateToken(authentication);
                String refreshToken = jwtService.generateRefreshToken(authentication);
                userService.saveRefreshToken(login.getEmail(), refreshToken);
                return ResponseEntity.ok(new JwtResponseDto(login.getEmail(), tokenResponseDto.getToken(), tokenResponseDto.getExpired()));
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Account not Activate or Block");

            }
        } catch (Exception ex) {
            System.out.println((ex.getMessage()));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email or password not correct");
    }

@PreAuthorize("isAuthenticated()")
    @Override
    public void logout(HttpServletRequest request) {
        String token = jwtAuthenticationFilter.getToken(request);
        String email = jwtService.getUsernameFromToken(token);
        userService.saveRefreshToken(email, "");
        SecurityContextHolder.clearContext();
    }

    public RedirectView activeAccount(String code, String email) {
        try {
            boolean isMatch = bCryptPasswordEncoder.matches(email, code);
            if (isMatch && userService.activeUser(email)) {
                return new RedirectView("http://localhost:3000/login?isActivate=true");
            } else {
                return new RedirectView("http://localhost:3000/login?isActivate=false");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return new RedirectView("http://localhost:3000/login?isActivate=false");
        }
    }

    @Override
    public ResponseEntity<?> forgotPassword(String email) {
        try {
            User user = userService.checkUser(email);
            if (user == null) {
                return ResponseEntity.badRequest().body("Email not exists");
            } else {
                String password = userService.resetPassword(email);
                Resource resource = new ClassPathResource("templates/ResetPassword.html");
                String htmlContent = new String(FileCopyUtils.copyToByteArray(resource.getInputStream()), StandardCharsets.UTF_8);
                String processesHtmlContent = htmlContent
                        .replace("[[Recipient_Name]]",user.getFirstName())
                        .replace("[[New_Password]]",password);
                sendEmailService.sendEmail(email, "Password Reset Confirmation", processesHtmlContent);
                return ResponseEntity.ok().body("Check email to view new password");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return ResponseEntity.internalServerError().body(ex.getMessage());
        }
    }


}
