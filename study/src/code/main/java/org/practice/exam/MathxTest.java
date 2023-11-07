package org.example.practice.exam;

public class MathxTest {
    private MathxTest() {
    }

    public static void main(String[] args) {
        sphereVolume();
        range();
        iterator();
    }

    private static void sphereVolume() {
        assert Mathx.equals(Mathx.sphereVolume(12), 2304.0 * Math.PI);
        assert Mathx.equals(Mathx.sphereVolume(9), 972.0 * Math.PI);
        try {
            Mathx.sphereVolume(0);
        } catch (IllegalArgumentException negativeRadius) {
            System.out.println(negativeRadius.getMessage());
            return;
        }
        assert false;
    }

    private static void range() {
        try {
            Range.of(1, 0);
            assert false;
        } catch (IllegalArgumentException wrongRange) {
            System.out.println(wrongRange.getMessage());
        }
        assert Range.of(0, 1).equals(Range.of(0, 1));
        assert Mathx.sum(Range.of(0, 0)) == 0;
        assert Mathx.sum(Range.of(0, 10)) == 55;
        assert Mathx.sum(Range.of(10, 99)) + 100 == Mathx.sum(Range.of(10, 100));
        assert Mathx.sum(Range.of(-10, 0)) == -Mathx.sum(Range.of(0, 10));
        assert Mathx.sum(Range.of(-2, 2)) == 0;
    }

    private static void iterator() {
        Range r = Range.of(1, 100);
        assert Mathx.sum(1, 2, 3, 7, 9, 10, 5, 4, 8, 6) == Mathx.sum(Range.of(1, 10));
        assert Mathx.product(1, 2, 3, 7, 9, 10, 5, 4, 8, 6) == Mathx
                .product(Range.of(1, 10).iterator());
        assert (Mathx.sum(r.iterator().filter(Mathx.even))
                + Mathx.sum(r.iterator().filter(Mathx::odd))) == Mathx.sum(r.iterator());
        assert r.iterator().take(10).reduce((x, y) -> x + y, 0) == 55;
        Mathx.randomNumbers(r)
                .take(10)
                .forEachRemaining(x -> System.out.print(x + " "));
    }


}
