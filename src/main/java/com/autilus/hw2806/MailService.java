package com.autilus.hw2806;

import java.util.*;
import java.util.function.Consumer;

public class MailService<T> implements Consumer<Send<T>> {
    private Map<String, List<T>> box;

    @Override
    public void accept(Send<T> t) {
        List<T> v = box.get(t.getTo());
        v.add(t.getContent());
        box.put(t.getTo(), v);
    }

    public MailService() {
        box = new HashMap<String, List<T>>() {
            @Override
            public List<T> get(Object key) {
                return getOrDefault(key, new LinkedList<T>());
            }
        };
    }

    public Map<String, List<T>> getMailBox() {
        return box;
    }
}
