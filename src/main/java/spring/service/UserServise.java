package spring.service;

import spring.entity.User;

import java.util.List;

public interface UserServise {
    public List<User> getAllUser();
    public void saveUser(User user);
    public User getUserFromId(int id);
    public void deleteUserFromId(int id);
}
