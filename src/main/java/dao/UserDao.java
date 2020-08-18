package dao;

import model.Product;
import model.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {
    void addUser(User user);

    List<User> getAll();

    void deleteUser(Long l);

    void addBasket(Product product, User user);

    Optional<User> findUserByEmail(String email);
}
