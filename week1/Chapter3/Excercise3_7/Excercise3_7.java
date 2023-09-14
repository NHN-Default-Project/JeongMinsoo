package Excercise3_7;

public class Excercise3_7 {
    public static void main(String[] args) {
        FindEqualBirthday exam1 = new FindEqualBirthday(3);
        System.out.println(exam1);

        FindDifferentBirthday exam2 = new FindDifferentBirthday(365);
        System.out.println(exam2);

        Find365Birthday exam3 = new Find365Birthday();
        System.out.println(exam3);
    }

}

interface FindBirth {
    void calculate();
}

abstract class Birth implements FindBirth {

    protected final String str;
    protected int count;

    public Birth(String str) {
        this.str = str;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public final String toString() {
        return str + count + "명입니다.";
    }
}

