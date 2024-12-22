package com.mentorat_virtuel.projet_mentorat_virtuel.service.user;

import com.mentorat_virtuel.projet_mentorat_virtuel.entities.User;
import org.springframework.stereotype.Service;

public interface UserService {
    User addUser(User user);
    User getAllUser();
    User getUserById(Integer userId);
    User updatedUser(User user, Integer userId);
    void deleteUser(Integer userId);

}
