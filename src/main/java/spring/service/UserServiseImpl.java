package spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.dao.UserDao;
import spring.entity.User;

import java.util.List;
@Service
public class UserServiseImpl implements UserServise {
    @Autowired
    private UserDao userDao;
    @Override
    public List<User> getAllUser() {
        return userDao.getAllUser();
    }

    @Override
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User getUserFromId(int id) {
        return userDao.getUserFromId(id);
    }

    @Override
    public void deleteUserFromId(int id) {
        userDao.deleteUserFromId(id);
    }
}
