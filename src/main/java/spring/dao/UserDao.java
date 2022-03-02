package spring.dao;

import spring.entity.User;

import java.util.List;

public interface UserDao {
    public List<User> getAllUser();
    public void saveUser(User user);
    public User getUserFromId(int id);
    public void deleteUserFromId(int id);
}
