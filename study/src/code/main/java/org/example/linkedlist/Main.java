package org.example.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int COUNT = 10_000;
//        CustomList list = new CustomList();

        List<Point> list = new ArrayList<>();
        for (int i = 0; i < COUNT; i++) {
            list.add(new Point(Math.random(), Math.random()));
        }


    }
}
