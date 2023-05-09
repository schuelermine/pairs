package com.anselmschueler.pairs;

import java.util.Objects;

public sealed class HetPair<T, U> implements Pair<T, U> permits HomPair {
    public HetPair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public HetPair(Pair<T, U> other) {
        this(other.getFirst(), other.getSecond());
    }

    public void copyFrom(HetPair<T, U> other) {
        first = other.first;
        second = other.second;
    }

    public static <T> HetPair<T, T> dup(T value) {
        return new HetPair<>(value, value);
    }

    public static <T, U, V> HetPair<HetPair<T, U>, V> assocL(Pair<T, ? extends Pair<U, V>> pair) {
        return new HetPair<>(new HetPair<>(pair.getFirst(), pair.getSecond().getFirst()), pair.getSecond().getSecond());
    }

    public static <T, U, V> HetPair<T, HetPair<U, V>> assocR(Pair<? extends Pair<T, U>, V> pair) {
        return new HetPair<>(pair.getFirst().getFirst(), new HetPair<>(pair.getFirst().getSecond(), pair.getSecond()));
    }

    protected T first;
    protected U second;

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public U getSecond() {
        return second;
    }

    public void setSecond(U second) {
        this.second = second;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (first == null ? 0 : first.hashCode());
        result = prime * result + (second == null ? 0 : second.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj instanceof HetPair<?, ?> other) {
            return Objects.equals(first, other.first) && Objects.equals(second, other.second);
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "HetPair [first=%s, second=%s]".formatted(first, second);
    }
}
