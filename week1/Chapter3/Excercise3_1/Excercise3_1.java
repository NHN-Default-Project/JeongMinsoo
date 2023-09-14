package Excercise3_1;

public class Excercise3_1 {

    public final static int DICE_COUNT = 2;

    public static void main(String[] args) {
        int count = 0;
        boolean isOne = false;
        Dice[] dice = new Dice[DICE_COUNT];

        for (int i = 0; i < DICE_COUNT; i++) {
            dice[i] = new Dice(6);
        }

        while (!isOne) {
            for (int i = 0; i < DICE_COUNT; i++) {
                System.out.println((i + 1) + "번째" + dice[i]);

                if (dice[i].getDiceNum() != 1) {
                    dice[i].diceRoll();
                    isOne = false;
                } else {
                    isOne = true;
                }
            }
            count++;

        }

        System.out.println("모두 1이 나올 때까지 주사위를 굴린 횟수 : " + count);
    }
}

class Dice {
    private int diceNum;
    private int eyes;

    public Dice(int eyes) {
        this.eyes = eyes;
        this.diceRoll();
    }

    public void diceRoll() {
        this.diceNum = (int) (Math.random() * eyes + 1);
    }

    @Override
    public String toString() {
        return "Dice Number : " + this.diceNum;
    }

    public int getDiceNum() {
        return diceNum;
    }
}