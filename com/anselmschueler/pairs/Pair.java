package com.anselmschueler.pairs;

import java.util.function.Function;

public interface Pair<T, U> {
    public T getFirst();

    public void setFirst(T first);

    public default void updateFirst(Function<? super T, ? extends T> function) {
        setFirst(function.apply(getFirst()));
    }

    public default <R> R onFirst(Function<? super T, R> function) {
        return function.apply(getFirst());
    }

    public U getSecond();

    public void setSecond(U second);

    public default void updateSecond(Function<? super U, ? extends U> function) {
        setSecond(function.apply(getSecond()));
    }

    public default <R> R onSecond(Function<? super U, R> function) {
        return function.apply(getSecond());
    }
}
