package JeongMinsoo.week1.Chapter3;

public class Excercise3_2 {

    public static void main(String[] args) {

        int N = 10000;

        int divisorCount = 0;

        int bigNum = 0;
        int bigDivisorNum = 0;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    divisorCount++;
                }
            }
            if (divisorCount >= bigDivisorNum) {
                bigNum = i;
                bigDivisorNum = divisorCount;
            }
            divisorCount = 0;

        }

        System.out.println("1~10000에서 가장 제수가 많은 숫자 : " + bigNum);
        System.out.println("제수의 개수 : " + bigDivisorNum);

    }

}