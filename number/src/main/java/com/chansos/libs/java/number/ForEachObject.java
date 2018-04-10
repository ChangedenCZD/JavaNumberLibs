package com.chansos.libs.java.number;

import java.util.Map;

public class ForEachObject<T> implements ForEachAble {
    private T object;
    private int index;

    public ForEachObject(T t) {
        this.object = t;
    }

    @Override
    public void forEach(ForEachResult forEachResult) {
        if (object instanceof Map) {
            Map map = (Map) object;
            map.forEach((key, value) -> {
                forEachResult.onResult(key, value);
            });
        } else {
            Iterable iterable = (Iterable) object;
            index = 0;
            iterable.forEach(item -> {
                forEachResult.onResult(index, item);
                index++;
            });
        }
    }

    public T self() {
        return object;
    }

    @Override
    public String toString() {
        return object.toString();
    }
}
