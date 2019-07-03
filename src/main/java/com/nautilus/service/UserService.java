package com.nautilus.service;

import com.nautilus.model.User;

import java.util.List;

interface UserService {
    User findById(int id);

    Long findIdByLogin(String login);

    Long findIdByPassword(String password);

    void save(User user);

    void update(User user);

    void delete(User user);

    List<User> findAll();
}
