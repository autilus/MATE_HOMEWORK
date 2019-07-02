package com.autilus.hw2706.factory;

import com.autilus.hw2706.dao.DaoInterface;
import com.autilus.hw2706.dao.UserDaoImpl;

public class UserDaoFactory {

    private static DaoInterface instance;

    public static DaoInterface getUserDao() {
        if (instance == null) {
            instance = new UserDaoImpl();
        }
        return instance;
    }
}
