package util;

import java.util.Random;

public abstract class Helper {
    public static void swap(int[] a, int p, int q) {
        int tmp = a[p];
        a[p] = a[q];
        a[q] = tmp;
    }

    public static int[] gen(int size) {
        return gen(size, Integer.MAX_VALUE);
    }

    public static int[] gen(int size, int maxVal) {
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            res[i] = new Random().nextInt(maxVal * 2 + 1) - maxVal - 1;
        }
        return res;
    }
}