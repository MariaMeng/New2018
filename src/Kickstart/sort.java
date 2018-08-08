package Kickstart;

import java.util.ArrayList;
import java.util.Collections;

public class sort {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(0);

        Collections.sort(list);

        System.out.println(list);
    }
}
