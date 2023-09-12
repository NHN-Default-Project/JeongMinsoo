package JeongMinsoo.week1.Chapter3;

public class Excercise3_1 {
    public static void main(String[] args) {
        int count = 0;
        int dice1 = 0;
        int dice2 = 0;
        do {
            dice1 = (int) (Math.random() * 6 + 1);
            dice2 = (int) (Math.random() * 6 + 1);
            count++;
            System.out.println("주사위의 값 : " + dice1 +
                    " " + dice2);

        } while (dice1 != 1 || dice2 != 1);

        System.out.println("둘 다 1이 나올 때까지 주사위를 굴린 횟수 : " + count);
    }
}
