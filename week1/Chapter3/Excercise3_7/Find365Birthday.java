package Excercise3_7;

public class Find365Birthday extends Birth {
    private boolean[] used;
    private int peopleCount;

    private final int DAYS = 365;

    public Find365Birthday() {
        super("1일~365일 각각마다 생일이 있는 사람을 찾는데에");
        this.used = new boolean[DAYS];
        this.peopleCount = 0;
        calculate();

        super.setCount(count);
    }

    public void calculate() {
        int count = 0;
        while (true) {
            int birthday = (int) (Math.random() * DAYS);
            peopleCount++;

            if (used[birthday]) {
                continue;
            } else {
                count++;
                used[birthday] = true;
            }

            if (count == DAYS) {
                break;
            }

        }
    }

}
