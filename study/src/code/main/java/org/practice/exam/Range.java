package org.example.practice.exam;

public final class Range {
    private int max;
    private int min;

    public static Range of(int min, int max) {
        return new Range(min, max);

    }

    public Range(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public int max() {
        return this.max;
    }

    public int min() {
        return this.min;
    }

    public IteratorAsDouble iterator() {
        return new IteratorAsDouble() {
            private int current = min();

            public boolean hasMore() {
                return current <= max();
            }

            public double next() {
                return current++;
            }
        };
    }

}
