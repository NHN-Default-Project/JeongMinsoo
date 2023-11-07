package org.example.practice.exam;

import java.util.function.DoublePredicate;

public class Mathx {
    private Mathx() {
    }

    public static int fibonacci(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("fibonacci: n < 0");
        }

        switch (n) {
            case 0:
            case 1:
                return n;
        }

        return Math.addExact(fibonacci(n - 1), fibonacci(n - 2));
    }

    /*
     * sphereVolume을 여기에
     */

    public static double sphereVolume(int r) {
        if (r <= 0) {
            throw new IllegalArgumentException("반지름의 값이 0과 같거나 작습니다.");
        }

        return Double.valueOf(4 / 3) * Math.pow(r, 3) * Math.PI;

    }


    public static long sum(Range range) {
        final var max = range.max();
        final var min = range.min();
        return (max - min + 1) * (max + min) / 2;
    }

    // IteratorAsDouble subtype을 위한 polymorphic reduce
    public static double reduce(java.util.function.DoubleBinaryOperator binaryOperator, double init,
                                IteratorAsDouble iterator) {
        double result = init;
        while (iterator.hasMore()) {
            result = binaryOperator.applyAsDouble(result, iterator.next());
        }
        return result;
    }

    public static double product(IteratorAsDouble numbers) {
        return reduce((x, y) -> x * y, 1.0, numbers);
    }

    public static double sum(IteratorAsDouble numbers) {
        return reduce((x, y) -> x + y, 0.0, numbers);
    }

    // Variable length args를 위한 overloading
    public static double product(double... numbers) {
        return reduce((x, y) -> x * y, 1.0, IteratorAsDouble.of(numbers));
    }

    public static double sum(double... numbers) {
        return reduce((x, y) -> x + y, 0.0, IteratorAsDouble.of(numbers));
    }

    // MathxTest.iterator()에서 odd, even을 씁니다.
    // 둘을 가리키는 문법이 굳이 달라야 할 까닭은?
    public static final DoublePredicate even = x -> x % 2 == 0;

    public static boolean odd(double x) {
        return x % 2 == 1;
    }

    public static int random(Range range) {
        int max = range.max();
        int min = range.min();
        return (int) ((Math.random() * (max - min)) + min);
    }

    public static IteratorAsDouble randomNumbers(Range range) {
        return new IteratorAsDouble() {
            public boolean hasMore() {
                return true;
            } // infinite

            public double next() {
                return random(range);
            }
        };
    }

    public static boolean equals(double a, double b) {
        if (a == b) {
            return true;
        } else {
            return false;
        }
    }
}
