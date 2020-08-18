package service.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import model.Product;
import model.User;
import service.UserService;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {
    private static final UserDao userDao = new UserDaoImpl();

    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public void addBasket(Product product,User user) {
        user.getBasket().add(product);
    }

    @Override
    public Optional<User> findUserByEmail(String email) {
        return userDao.findUserByEmail(email);
    }

    @Override
    public void deleteUser(Long l) {
        userDao.deleteUser(l);
    }

    public List<User> getAll() {
        return userDao.getAll();
    }
}
