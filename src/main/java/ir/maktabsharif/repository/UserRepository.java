package ir.maktabsharif.repository;

import ir.maktabsharif.model.model.User;

import java.util.Optional;

public interface UserRepository extends BaseRepository<User> {

   Optional<User> login(String username, String password);
}
