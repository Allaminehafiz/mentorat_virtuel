package com.mentorat_virtuel.projet_mentorat_virtuel.service.user;

import com.mentorat_virtuel.projet_mentorat_virtuel.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    User addUser(User user);
    List<User> getAllUser();
    User getUserById(Integer userId);
    User updatedUser(User user, Integer userId);
    void deleteUser(Integer userId);

}
