package edu.mum.service;

import java.io.IOException;
import java.util.List;

import edu.mum.models.User;
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


}

