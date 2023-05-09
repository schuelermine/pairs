package com.anselmschueler.pairs;

import java.util.Optional;
import java.util.function.Function;

public final class HomPair<T> extends HetPair<T, T> {
    public HomPair(T first, T second) {
        super(first, second);
    }

    public HomPair(Pair<T, T> other) {
        super(other);
    }

    public static <T> HomPair<T> dup(T value) {
        return new HomPair<>(value, value);
    }

    public void swap() {
        final T temporary = first;
        first = second;
        second = temporary;
    }

    public void updateBoth(Function<? super T, ? extends T> function) {
        first = function.apply(first);
        second = function.apply(second);
    }

    public <R> HomPair<R> onBoth(Function<? super T, R> function) {
        return new HomPair<>(function.apply(first), function.apply(second));
    }

    public static <T> Optional<HomPair<T>> compose(Pair<T, T> left, Pair<T, T> right) {
        if (left.getSecond().equals(right.getFirst())) {
            return Optional.of(new HomPair<>(left.getFirst(), right.getSecond()));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public String toString() {
        return "HomPair [first=%s, second=%s]".formatted(first, second);
    }
}
