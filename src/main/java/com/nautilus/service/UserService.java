package com.nautilus.service;

import com.nautilus.dao.UserDao;
import com.nautilus.model.User;

import java.util.List;

public class UserService {

    private UserDao usersDao = new UserDao();

    public UserService() {
    }

    public User findUser(int id) {
        return usersDao.findById(id);
    }
    public Long findIdByLogin(String login){
        return usersDao.findIdByLogin(login);
    }
    public Long findIdByPassword(String password){
        return usersDao.finIdByPassword(password);
    }

    public void saveUser(User user) {
        usersDao.save(user);
    }

    public void deleteUser(User user) {
        usersDao.delete(user);
    }

    public void updateUser(User user) {
        usersDao.update(user);
    }

    public List<User> findAllUsers() {
        return usersDao.findAll();
    }

}
