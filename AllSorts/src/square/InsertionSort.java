package square;

import static util.Helper.swap;

public class InsertionSort {
    public static void main(String[] args) {
    }

    public static int[] sort(int a[]) {
        if (a == null) {
            return null;
        }
        for (int i = 1; i < a.length; i++) {
            for (int j = i; (j > 0) && (a[j] < a[j - 1]); j--) {
                swap(a, j, j - 1);
            }
        }
        return a;
    }
}