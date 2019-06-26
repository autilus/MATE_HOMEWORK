package com.autilus.hw2706.controller;

import com.autilus.hw2706.dao.DaoInterface;
import com.autilus.hw2706.lib.Inject;
import com.autilus.hw2706.model.Bet;
import com.autilus.hw2706.model.User;

import java.util.Scanner;

public class ConsoleHandler {
    @Inject
    private static DaoInterface<User> userDao;
    @Inject
    private static DaoInterface<Bet> betDao;

    static public void handle() {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                String command = scanner.nextLine();
                if (command.equals("0")) {
                    return;
                }
                String[] data = command.split(" ");
                String firstName = data[0];
                String lastName = data[1];
                User user = new User(firstName.toString(), lastName.toString());
                int value = Integer.parseInt(data[2]);
                double risk = Double.parseDouble(data[3]);
                Bet bet = new Bet(value, risk);
                betDao.add(bet);
                userDao.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Данные введены некорректно");
        }
    }
}

