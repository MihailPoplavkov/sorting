package improved;

import java.util.Random;

import static util.Helper.swap;

public class ImprovedQuickSort {
    public static int[] sort(int[] a) {
        return sort(a, 0, a.length - 1, new Random());
    }

    public static int[] sort(int[] a, int left, int right, Random random) {
        if (left < right) {
            int pivot = left + random.nextInt(right - left);
            int x = a[pivot];
            swap(a, pivot, right);
            int i = left;
            int j = right - 1;
            int p = left - 1;
            int q = right;
            while (true) {
                while (i < right && a[i] < x) {
                    i++;
                }
                while (j > left && a[j] > x) {
                    j--;
                }
                if (i >= j) break;
                swap(a, i, j);
                if (a[i] == x) {
                    p++;
                    swap(a, p, i);
                    i++;
                }
                if (a[j] == x) {
                    q--;
                    swap(a, q, j);
                    j--;
                }
            }
            swap(a, i, right);
            j = i - 1;
            i++;
            for (int k = left; k <= p; k++, j--) {
                swap(a, k, j);
            }
            for (int k = right - 1; k >= q; k--, i++) {
                swap(a, k, i);
            }
            sort(a, left, j, new Random());
            sort(a, i, right, new Random());
        }
        return a;
    }
}
