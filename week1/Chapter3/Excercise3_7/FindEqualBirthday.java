package Excercise3_7;

class FindEqualBirthday {
    private int[] used;
    private int count;
    private final int targetPeople;

    private final int DAYS = 365;

    public FindEqualBirthday(int targetPeople) {
        this.targetPeople = targetPeople;
        this.used = new int[DAYS];
        this.count = 0;
        calculate();
    }

    private void calculate() {
        while (true) {

            int birthday = (int) (Math.random() * DAYS);
            this.count++;
            this.used[birthday] += 1;

            // System.out.printf("Person %d has birthday number %d%n", count, birthday);

            if (used[birthday] == targetPeople) {
                break;
            }

        } // end while
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        return sb.append("같은 생일을 가진 사람 ")
                .append(targetPeople)
                .append("명 찾는데에 ")
                .append(this.count)
                .append("번이 걸렸습니다.")
                .toString();
    }

    public int getCount() {
        return this.count;
    }

}