package improved;

import static util.Helper.swap;

public class BinInsertionSort {
    public static int[] sort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int k = binSearchRight(a, 0, i - 1, a[i]);
            for (int j = i; j > k; j--) {
                swap(a, j, j - 1);
            }
        }
        return a;
    }

    private static int binSearchRight(int[] a, int left, int right, int key) {
        int l = left - 1;
        int r = right + 1;
        while (l < r - 1) {
            int mid = (l + r) / 2;
            if (a[mid] <= key) {
                l = mid;
            } else {
                r = mid;
            }
        }
        return l + 1;
    }
}
