package rs.raf.mstojanovic5623m.agpp.network.oebb.transform;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public interface Converter<I, O> {
    O convert(I input);
    Predicate<I> shouldConvert();

    default List<O> convertAll(List<I> inputs) {
        return inputs.stream()
                .filter(i -> shouldConvert().test(i))
                .map(this::convert)
                .collect(Collectors.toList());
    }
}
