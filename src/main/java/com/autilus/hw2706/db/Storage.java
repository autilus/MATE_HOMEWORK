package com.autilus.hw2706.db;

import com.autilus.hw2706.model.Bet;
import com.autilus.hw2706.model.User;

import java.util.ArrayList;
import java.util.List;

//ЭТО НАША БД
public class Storage {
    public static final List<Bet> bets = new ArrayList<>();
    public static final List<User> users = new ArrayList<>();
}
