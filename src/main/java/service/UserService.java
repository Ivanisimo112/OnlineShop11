package service;

import model.Product;
import model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    void addUser(User user);
    void addBasket(Product product,User user);
    List<User> getAll();
    void deleteUser(Long l);
    Optional<User> findUserByEmail(String email);
}
