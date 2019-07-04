package com.nautilus.dao;

import com.nautilus.model.User;

import java.util.List;

interface UserDao {
    User findById(int id);

    Long findIdByLogin(String login);

    Long findIdByPassword(String password);

    void save(User user);

    void update(User user);

    void delete(User user);

    List<User> findAll();
}
