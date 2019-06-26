package com.autilus.hw2706.factory;

import com.autilus.hw2706.dao.BetDaoImpl;
import com.autilus.hw2706.dao.DaoInterface;

public class BetDaoFactory {

    private static DaoInterface instance;

    public static DaoInterface getBetDao() {
        if (instance == null) {
            instance = new BetDaoImpl();
        }
        return instance;
    }
}
