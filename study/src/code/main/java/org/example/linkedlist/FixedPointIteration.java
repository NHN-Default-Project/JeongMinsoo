package org.example.linkedlist;

public class FixedPointIteration {
    public static void main(String[] args) {
        double initialGuess = 1.0; // 초기 추측값
        double tolerance = 1e-6; // 수렴 허용 한계
        int maxIterations = 100; // 최대 반복 횟수

        double x = initialGuess;
        int iterations = 0;

        while (iterations < maxIterations) {
            double nextX = f(x); // f(x) 함수를 정의하고 호출
            if (Math.abs(nextX - x) < tolerance) {
                System.out.println("고정점 반복 수렴: x = " + nextX);
                break;
            }
            x = nextX;
            iterations++;
        }

        if (iterations == maxIterations) {
            System.out.println("반복 횟수 초과: 수렴하지 않음");
        }
    }

    // f(x) = x^2 - 2
    private static double f(double x) {
        return x * x - 2;
    }
}
