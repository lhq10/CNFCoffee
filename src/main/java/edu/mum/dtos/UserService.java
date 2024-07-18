package edu.mum.dtos;


import edu.mum.dtos.authDtos.RegisterDto;
import edu.mum.dtos.common.PaginateAndSearchByNameDto;
import edu.mum.dtos.userDtos.ChangePasswordDto;
import edu.mum.dtos.userDtos.UpdateUserDto;
import edu.mum.models.User;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;

public interface UserService {
    ResponseEntity<?> createAccountUser(RegisterDto registerDto);
    ResponseEntity<?> createAccountAdmin(RegisterDto registerDto);
    ResponseEntity<?> createAccountPartner(RegisterDto registerDto);
    ResponseEntity<?> changePassword(HttpServletRequest request, ChangePasswordDto changePasswordDto);
    void saveRefreshToken(String email,String refreshToken);
    ResponseEntity<?> refreshToken(HttpServletRequest request);
    ResponseEntity<?> getMe(HttpServletRequest request);
    String updateUser(HttpServletRequest request, UpdateUserDto updateUserDto);
    ResponseEntity<?> toggleLockUser(String email,String value);
    boolean activeUser(String email);
    User checkUser(String email);
    User findUserById(Long id);
    User findUserByToken(HttpServletRequest request);
    String resetPassword(String email);
    ResponseEntity<?> getAllUser(PaginateAndSearchByNameDto paginateAndSearchByNameDto);
    ResponseEntity<?> getUserById(Long id);
}
