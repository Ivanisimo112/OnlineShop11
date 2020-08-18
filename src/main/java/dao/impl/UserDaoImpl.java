package dao.impl;

import model.Product;
import org.apache.log4j.Logger;
import dao.UserDao;
import model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDaoImpl implements UserDao {
    private static List<User> userList = new ArrayList<User>();

    private static final Logger logger = Logger.getLogger(UserDaoImpl.class);

    @Override
    public Optional<User> findUserByEmail(String email) {
        return userList.stream().filter(user -> user.getEmail().equals(email)).findFirst();
    }

    static {
        userList.add(new User(100L,"admin@mail.ru","admin","admin"));
    }

    @Override
    public void deleteUser(Long l) {
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getId()==l){
                userList.remove(userList.get(i));
            }
        }
    }


    @Override
    public void addBasket(Product product,User user) {
        user.getBasket().add(product);
    }

    public void addUser(User user) {
        logger.debug("User" + user + "added in db");
        userList.add(user);
    }

    public List<User> getAll() {
        return userList;
    }
}
