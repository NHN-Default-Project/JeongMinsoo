package org.example;

import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleConsumer;
import java.util.function.DoublePredicate;

public interface IteratorAs {
    boolean hasMore();

    double next();

    default double reduce(DoubleBinaryOperator binaryOperator, double init) {
        double value = init;

        return binaryOperator.applyAsDouble(init, value);
    }

    default IteratorAs take(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Take");
        }
        final IteratorAs iterator = this;

        return new IteratorAs() {
            int remainig = n;


            @Override
            public boolean hasMore() {
                return remainig > 0 && iterator.hasMore();
            }

            @Override
            public double next() {
                if (remainig <= 0) {
                    throw new IllegalArgumentException();
                }
                remainig--;
                return iterator.next();
            }
        };
    }

    default void forEachRemaining(DoubleConsumer f) {
        while (this.hasMore()) {
            f.accept(next());
        }
    }

    static IteratorAs of(double... numbers) {
        return new IteratorAs() {
            int index = 0;

            @Override
            public boolean hasMore() {
                return numbers.length > index;
            }

            @Override
            public double next() {
                return numbers[index++];
            }
        };
    }

    default IteratorAs filter(DoublePredicate predicate) {
        return new IteratorAs() {
            private double nextElement;

            @Override
            public boolean hasMore() {
                while (IteratorAs.this.hasMore()) {
                    nextElement = IteratorAs.this.next();

                    if (predicate.test(nextElement)) {
                        return true;
                    }
                }
                return false;
            }

            @Override
            public double next() {
                return 0;
            }
        };
    }
}
