package edu.mum.service;

import java.io.IOException;
import java.util.List;

import edu.mum.dtos.authDtos.RegisterDto;
import edu.mum.dtos.common.PaginateAndSearchByNameDto;
import edu.mum.dtos.userDtos.ChangePasswordDto;
import edu.mum.dtos.userDtos.UpdateUserDto;
import edu.mum.models.User;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;


public interface UserService {
    List<User> getAllUsers();

    List<User> getUsersByPagination(int pageNo, int pageSize);

    Integer getUsersCount();

    User getUserById(int id);

    User saveUser(User user);

    User updateUser(User user);

    void deleteUser(int id);

    String uploadImage(MultipartFile image) throws IOException;

    String updateImage(String oldImageName, MultipartFile image) throws IOException;

    String encryptPassword(String password);

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

