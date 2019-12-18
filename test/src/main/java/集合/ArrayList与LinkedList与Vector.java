package 集合;

import java.util.*;

public class ArrayList与LinkedList与Vector {
    public static void main(String[] args) {
        int a = 5;
         a = tableSizeFor(a);
        System.out.println(a);
    }

    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return n;
    }
}
