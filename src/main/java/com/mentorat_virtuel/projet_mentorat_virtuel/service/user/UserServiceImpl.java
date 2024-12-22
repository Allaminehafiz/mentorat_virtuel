package com.mentorat_virtuel.projet_mentorat_virtuel.service.user;

import com.mentorat_virtuel.projet_mentorat_virtuel.entities.User;
import com.mentorat_virtuel.projet_mentorat_virtuel.repositories.UserRepo;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepo userRepo;

    public UserServiceImpl(UserRepo userRepo) {

        this.userRepo = userRepo;
    }

    @Override
    public User addUser(User user) {
        user.setFirstname(user.getFirstname());
        user.setLastname(user.getLastname());
        return this.userRepo.save(user);
    }

    @Override
    public User getAllUser() {
        return null;
    }

    @Override
    public User getUserById(Integer userId) {
        return null;
    }

    @Override
    public User updatedUser(User user, Integer userId) {
        return null;
    }

    @Override
    public void deleteUser(Integer userId) {

    }
}
