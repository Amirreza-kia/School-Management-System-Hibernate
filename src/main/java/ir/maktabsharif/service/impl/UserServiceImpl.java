package ir.maktabsharif.service.impl;

import ir.maktabsharif.exception.UserNotFoundException;
import ir.maktabsharif.model.enums.UserType;
import ir.maktabsharif.model.model.User;
import ir.maktabsharif.service.UserService;
import ir.maktabsharif.util.ApplicationContext;

import java.util.Optional;

public class UserServiceImpl implements UserService {

    @Override
    public UserType login(String username, String password) {
        Optional<User> optionalUser = ApplicationContext.userRepository.login(username, password);
        if (optionalUser.isEmpty()) {
            System.out.println("UserName or Password is incorrect");
        }
        return optionalUser.get().getUserType();
    }
}
