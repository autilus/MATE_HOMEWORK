package com.autilus.hw2706;

import com.autilus.hw2706.controller.ConsoleHandler;
import com.autilus.hw2706.dao.BetDaoImpl;
import com.autilus.hw2706.dao.UserDaoImpl;
import com.autilus.hw2706.lib.Injector;

public class Main {

    static {
        try {
            Injector.injectDependency();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Если хотите сделать ставку, введите \n" +
                "сумму и риск через пробел");
        ConsoleHandler.handle();
        BetDaoImpl betDao = new BetDaoImpl();
        UserDaoImpl userDao=new UserDaoImpl();
        System.out.println(betDao.getAll());
        System.out.println(userDao.getAll());
    }


}




