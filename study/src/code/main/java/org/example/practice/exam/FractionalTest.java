package org.example.practice.exam;

public class FractionalTest { // 또는 Rational
    private FractionalTest() {
    }

    public static void main(String[] args) {
        try {
            Fractional.of(1, 0);
            assert false;
        } catch (IllegalArgumentException zeroDenominator) {
            System.out.println(zeroDenominator.getMessage());
        }

        assert Fractional.of(1, 2).equals(Fractional.of(2, 4));
        assert Fractional.of(1, -2).equals(Fractional.of(-1, 2));
        assert Fractional.of(1, 2).hashCode() == Fractional.of(2, 4).hashCode();
        assert Fractional.of(1, -2).hashCode() == Fractional.of(-1, 2).hashCode();
    }

}
