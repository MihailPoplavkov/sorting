package fast;

import static util.Helper.swap;

public class QuickSort {
    public static int[] sort(int[] a) {
        return sort(a, 0, a.length - 1);
    }

    public static int[] sort(int[] a, int leftIdx, int rightIdx) {
        if (leftIdx >= rightIdx) {
            return a;
        }
        int idx = partition(a, leftIdx, rightIdx);
        sort(a, leftIdx, idx);
        sort(a, idx + 1, rightIdx);
        return a;
    }

    private static int partition(int[] a, int leftIdx, int rightIdx) {
        int elem = a[leftIdx + (rightIdx - leftIdx + 1) / 2];
        int i = leftIdx;
        int j = rightIdx;
        while (i <= j) {
            while (a[i] < elem) {
                i++;
            }
            while (a[j] > elem) {
                j--;
            }
            if (i <= j) {
                swap(a, i++, j--);
            }
        }
        return j;
    }
}
