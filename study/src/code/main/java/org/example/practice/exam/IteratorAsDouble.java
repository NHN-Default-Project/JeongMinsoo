package org.example.practice.exam;

import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleConsumer;
import java.util.function.DoublePredicate;

public interface IteratorAsDouble {
    boolean hasMore();

    double next();

    default double reduce(DoubleBinaryOperator binaryOperator, double init) {
        double value = init;

        return binaryOperator.applyAsDouble(init, value); // TODO: 채웁니다
    }

    default IteratorAsDouble take(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("take: n <= 0, where n == " + n);
        }
        return new IteratorAsDouble() {
            private int[] numbers = new int[n];

            @Override
            public boolean hasMore() {
                return numbers.length > 0;
            }

            @Override
            public double next() {
                return numbers[0];
            }
        };
    }

    default void forEachRemaining(DoubleConsumer f) {

    }

    public static IteratorAsDouble of(double... numbers) {
        return new IteratorAsDouble() {

            @Override
            public boolean hasMore() {
                if (numbers.length > 0) {
                    return true;
                } else {
                    return false;
                }
            }

            @Override
            public double next() {
                return numbers[0];
            }

        };
    }

    default IteratorAsDouble filter(DoublePredicate predicate) {
        return new IteratorAsDouble() {
            private double nextElement;

            public boolean hasMore() {
                while (IteratorAsDouble.this.hasMore()) {
                    nextElement = IteratorAsDouble.this.next();
                    if (predicate.test(nextElement)) {
                        return true;
                    }
                }
                return false;
            }

            public double next() {
                return nextElement;
            }
        };
    }
}
