package com.autilus.hw2706.lib;

import com.autilus.hw2706.controller.ConsoleHandler;
import com.autilus.hw2706.dao.BetDaoImpl;
import com.autilus.hw2706.dao.UserDaoImpl;
import com.autilus.hw2706.factory.BetDaoFactory;
import com.autilus.hw2706.factory.UserDaoFactory;

import java.lang.reflect.Field;

public class Injector {

    public static void injectDependency() throws IllegalAccessException {
        Class<ConsoleHandler> consoleHandlerClass = ConsoleHandler.class;
        Class<BetDaoImpl> betDaoClass = BetDaoImpl.class;
        Class<UserDaoImpl> userDaoClass = UserDaoImpl.class;
        Field[] consoleHandlerFields = consoleHandlerClass.getDeclaredFields();
        for (Field field : consoleHandlerFields) {
            if (!(field.getDeclaredAnnotation(Inject.class) == null)) {
                field.setAccessible(true);
                if (field.getName().equals("UserDao") && !(userDaoClass.getAnnotation(Dao.class) == null)) {
                    field.set(null, UserDaoFactory.getUserDao());
                }
                if (field.getName().equals("betDao") && !(betDaoClass.getAnnotation(Dao.class) == null)) {
                    field.set(null, BetDaoFactory.getBetDao());
                }
                field.setAccessible(false);
            }
        }
    }
}
