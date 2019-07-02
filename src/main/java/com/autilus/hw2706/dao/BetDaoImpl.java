package com.autilus.hw2706.dao;

import com.autilus.hw2706.db.Storage;
import com.autilus.hw2706.lib.Dao;
import com.autilus.hw2706.model.Bet;

import java.util.List;

//НАШ КЛАСС ДЛЯ РАБОТЫ С БАЗОЙ ДАННЫХ И ТАБЛИЦОЙ СТАВОК
@Dao
public class BetDaoImpl implements DaoInterface<Bet> {
    @Override
    public void add(Bet bet) {
        Storage.BETS.add(bet);
    }

    @Override
    public List<Bet> getAll() {
        return Storage.BETS;
    }
}
