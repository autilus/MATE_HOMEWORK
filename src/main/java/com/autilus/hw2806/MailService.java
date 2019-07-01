package com.autilus.hw2806;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public static class MailService<T> implements Consumer<Send<T>> {
    @Override
    public void accept(Send<T> t) {
        List<T> v = box.get(t.getTo());
        v.add(t.getContent());
        box.put(t.getTo(), v);
    }

    public MailService() {
        box = (HashMap) get(key) ->{ return super.getOrDefault(key, new LinkedList<T>()); };

    }

    public Map<String, List<T>> getMailBox() {
        return box;
    }

    private Map<String, List<T>> box;
}
