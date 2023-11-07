package org.example.practice;

public class TrueTest {
    static boolean twoMoreTrue(boolean... parm) {
        int num = 0;
        for (boolean value : parm) {
            num = value ? num + 1 : num + 0;
        }
        return num > 1 ? true : false;

    }

    public static void main(String[] args) {

        boolean[] argsBool = new boolean[3];

        try {
            for (int i = 0; i < 3; i++) {
                argsBool[i] = Boolean.valueOf(args[i]);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException("TrueTest: three boolean arguments required");
        }
        System.out.println(twoMoreTrue(argsBool));
    }
}
