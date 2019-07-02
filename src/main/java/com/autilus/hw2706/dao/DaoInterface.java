package com.autilus.hw2706.dao;

import java.util.List;

public interface DaoInterface<T> {
    void add(T name);

    List<T> getAll();
}
