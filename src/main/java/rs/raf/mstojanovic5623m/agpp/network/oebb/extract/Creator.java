package rs.raf.mstojanovic5623m.agpp.network.oebb.extract;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Creator<T> {

    private final List<T> items = new ArrayList<>();
    private final Function<String, T> newItem;

    public Creator(Function<String, T> newItem) {
        this.newItem = newItem;
    }

    public T create(String id) {
        T item = this.newItem.apply(id);
        int index = this.items.indexOf(item);
        if (index == -1) {
            this.items.add(item);
            return item;
        }
        return this.items.get(index);
    }

    public List<T> getItems() {
        return items;
    }
}
