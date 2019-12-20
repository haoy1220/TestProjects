package 集合;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Comparator与Comparable {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(1);
        arrayList.add(3);
        arrayList.add(10);
        arrayList.add(22);
        arrayList.add(-4);
        arrayList.add(73);
        arrayList.add(93);
        arrayList.add(-1);
        arrayList.add(6);
        System.out.println(arrayList);

        Collections.sort(arrayList);
        System.out.println(arrayList);

        Collections.reverse(arrayList);
        System.out.println(arrayList);

        Collections.sort(arrayList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

        System.out.println(arrayList);
    }
}
