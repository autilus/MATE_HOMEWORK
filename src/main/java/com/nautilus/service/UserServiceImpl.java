package com.nautilus.service;

import com.nautilus.dao.UserDaoImpl;
import com.nautilus.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDaoImpl usersDao = new UserDaoImpl();

    public UserServiceImpl() {
    }

    public User findById(int id) {
        return usersDao.findById(id);
    }

    public Long findIdByLogin(String login) {
        return usersDao.findIdByLogin(login);
    }

    public Long findIdByPassword(String password) {
        return usersDao.findIdByPassword(password);
    }

    public void save(User user) {
        usersDao.save(user);
    }

    public void delete(User user) {
        usersDao.delete(user);
    }

    public void update(User user) {
        usersDao.update(user);
    }

    public List<User> findAll() {
        return usersDao.findAll();
    }

}
