/*     / \____  _    ______   _____ / \____   ____  _____
 *    /  \__  \/ \  / \__  \ /  __//  \__  \ /    \/ __  \   Javaslang
 *  _/  // _\  \  \/  / _\  \\_  \/  // _\  \  /\  \__/  /   Copyright 2014-2015 Daniel Dietrich
 * /___/ \_____/\____/\_____/____/\___\_____/_/  \_/____/    Licensed under the Apache License, Version 2.0
 */
package javaslang.collection;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collector;

public class TreeSetTest extends AbstractSortedSetTest {

    @Override
    protected <T> Collector<T, ArrayList<T>, ? extends TreeSet<T>> collector() {
        return TreeSet.collector();
    }

    @Override
    protected <T> TreeSet<T> empty() {
        return TreeSet.empty(toStringComparator());
    }

    @Override
    protected <T> TreeSet<T> of(T element) {
        return TreeSet.of(toStringComparator(), element);
    }

    @SuppressWarnings({ "unchecked", "varargs" })
    @SafeVarargs
    @Override
    protected final <T> TreeSet<T> of(T... elements) {
        boolean allLongs = true;
        boolean allNumbers = true;
        for (T element : elements) {
            if (!(element instanceof Number)) {
                allNumbers = false;
            }
            if (!(element instanceof Long)) {
                allLongs = false;
            }
        }
        if (allLongs) {
            return TreeSet.ofAll(toLongComparator(), Iterator.of(elements));
        } else if (allNumbers) {
            return TreeSet.ofAll(toDoubleComparator(), Iterator.of(elements));
        } else {
            return TreeSet.ofAll(toStringComparator(), Iterator.of(elements));
        }
    }

    @Override
    protected <T> TreeSet<T> ofAll(Iterable<? extends T> elements) {
        return TreeSet.ofAll(toStringComparator(), elements);
    }

    @Override
    protected TreeSet<Boolean> ofAll(boolean[] array) {
        return TreeSet.ofAll(array);
    }

    @Override
    protected TreeSet<Byte> ofAll(byte[] array) {
        return TreeSet.ofAll(array);
    }

    @Override
    protected TreeSet<Character> ofAll(char[] array) {
        return TreeSet.ofAll(array);
    }

    @Override
    protected TreeSet<Double> ofAll(double[] array) {
        return TreeSet.ofAll(array);
    }

    @Override
    protected TreeSet<Float> ofAll(float[] array) {
        return TreeSet.ofAll(array);
    }

    @Override
    protected TreeSet<Integer> ofAll(int[] array) {
        return TreeSet.ofAll(array);
    }

    @Override
    protected TreeSet<Long> ofAll(long[] array) {
        return TreeSet.ofAll(array);
    }

    @Override
    protected TreeSet<Short> ofAll(short[] array) {
        return TreeSet.ofAll(array);
    }

    @Override
    boolean useIsEqualToInsteadOfIsSameAs() {
        return true; // TODO ?
    }

    @Override
    int getPeekNonNilPerformingAnAction() {
        return 1;
    }

    // -- helpers

    @SuppressWarnings("unchecked")
    private static Comparator<Object> toStringComparator() {
        return (Comparator<Object> & Serializable) (o1, o2) -> String.valueOf(o1).compareTo(String.valueOf(o2));
    }

    private static <T> Comparator<T> toDoubleComparator() {
        return (Comparator<T> & Serializable) (o1, o2) -> {
            Double n1 = ((Number) o1).doubleValue();
            Double n2 = ((Number) o2).doubleValue();
            return n1.compareTo(n2);
        };
    }

    private static <T> Comparator<T> toLongComparator() {
        return (Comparator<T> & Serializable) (o1, o2) -> {
            Long n1 = ((Number) o1).longValue();
            Long n2 = ((Number) o2).longValue();
            return n1.compareTo(n2);
        };
    }

    @Override
    protected TreeSet<Character> range(char from, char toExclusive) {
        return TreeSet.range(from, toExclusive);
    }

    @Override
    protected TreeSet<Character> rangeBy(char from, char toExclusive, int step) {
        return TreeSet.rangeBy(from, toExclusive, step);
    }

    @Override
    protected TreeSet<Double> rangeBy(double from, double toExclusive, double step) {
        return TreeSet.rangeBy(from, toExclusive, step);
    }

    @Override
    protected TreeSet<Integer> range(int from, int toExclusive) {
        return TreeSet.range(from, toExclusive);
    }

    @Override
    protected TreeSet<Integer> rangeBy(int from, int toExclusive, int step) {
        return TreeSet.rangeBy(from, toExclusive, step);
    }

    @Override
    protected TreeSet<Long> range(long from, long toExclusive) {
        return TreeSet.range(from, toExclusive);
    }

    @Override
    protected TreeSet<Long> rangeBy(long from, long toExclusive, long step) {
        return TreeSet.rangeBy(from, toExclusive, step);
    }

    @Override
    protected TreeSet<Character> rangeClosed(char from, char toInclusive) {
        return TreeSet.rangeClosed(from, toInclusive);
    }

    @Override
    protected TreeSet<Character> rangeClosedBy(char from, char toInclusive, int step) {
        return TreeSet.rangeClosedBy(from, toInclusive, step);
    }

    @Override
    protected TreeSet<Double> rangeClosedBy(double from, double toInclusive, double step) {
        return TreeSet.rangeClosedBy(from, toInclusive, step);
    }

    @Override
    protected TreeSet<Integer> rangeClosed(int from, int toInclusive) {
        return TreeSet.rangeClosed(from, toInclusive);
    }

    @Override
    protected TreeSet<Integer> rangeClosedBy(int from, int toInclusive, int step) {
        return TreeSet.rangeClosedBy(from, toInclusive, step);
    }

    @Override
    protected TreeSet<Long> rangeClosed(long from, long toInclusive) {
        return TreeSet.rangeClosed(from, toInclusive);
    }

    @Override
    protected TreeSet<Long> rangeClosedBy(long from, long toInclusive, long step) {
        return TreeSet.rangeClosedBy(from, toInclusive, step);
    }
}
