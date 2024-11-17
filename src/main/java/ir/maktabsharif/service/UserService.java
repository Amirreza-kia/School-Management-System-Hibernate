package ir.maktabsharif.service;

import ir.maktabsharif.model.enums.UserType;

public interface UserService {

    UserType login(String username, String password);
}
