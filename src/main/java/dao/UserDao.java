package dao;

import model.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {
    void addUser(User user);
    List<User> getAll();
    void deleteUser(Long l);
    Optional<User> findUserByEmail(String email);
}
