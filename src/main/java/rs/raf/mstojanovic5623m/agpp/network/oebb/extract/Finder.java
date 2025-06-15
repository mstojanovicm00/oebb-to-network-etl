package rs.raf.mstojanovic5623m.agpp.network.oebb.extract;

import java.util.Optional;
import java.util.function.Function;

public class Finder<T> {

    private final Function<String, T> finderFunction;

    public Finder(Function<String, T> finderFunction) {
        this.finderFunction = finderFunction;
    }

    public Optional<T> find(String id) {
        return Optional.ofNullable(this.finderFunction.apply(id));
    }
}
