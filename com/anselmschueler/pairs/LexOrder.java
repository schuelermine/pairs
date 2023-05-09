package com.anselmschueler.pairs;

import java.util.Comparator;

public final class LexOrder<T, U, C extends Comparator<T>, D extends Comparator<U>>
        implements Comparator<Pair<T, U>> {
    public LexOrder(C firstComparator, D secondComparator) {
        this.firstComparator = firstComparator;
        this.secondComparator = secondComparator;
    }

    public static <T, C extends Comparator<T>> LexOrder<T, T, C, C> dup(C comparator) {
        return new LexOrder<>(comparator, comparator);
    }

    private C firstComparator;
    private D secondComparator;

    public int compare(Pair<T, U> o1, Pair<T, U> o2) {
        int firstComparison = firstComparator.compare(o1.getFirst(), o2.getFirst());
        if (firstComparison != 0) {
            return firstComparison;
        } else {
            return secondComparator.compare(o1.getSecond(), o2.getSecond());
        }
    }
}
