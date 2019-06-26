package com.autilus.hw2706.dao;

import com.autilus.hw2706.db.Storage;
import com.autilus.hw2706.lib.Dao;
import com.autilus.hw2706.model.Bet;
import com.autilus.hw2706.model.User;

import java.util.List;

//НАШ КЛАСС ДЛЯ РАБОТЫ С БАЗОЙ ДАННЫХ И ТАБЛИЦОЙ СТАВОК
@Dao
public class UserDaoImpl implements DaoInterface<User> {
        @Override
        public void add(User user) {
            Storage.users.add(user);
        }

        @Override
        public List<User> getAll() {
            return Storage.users;
        }
    }