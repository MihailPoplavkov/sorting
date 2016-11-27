package order.statistics;

import java.util.Random;

import static util.Helper.swap;

public class OrderStatistics {
    public static int find(int[] a, int k) {
        return find(a, k, new Random());
    }

    private static int find(int[] a, int k, Random random) {
        int left = 0;
        int right = a.length - 1;
        while (true) {
            int pivot = left + random.nextInt(right - left + 1);
            int idx = partition(a, left, right, pivot);
            if (idx < k) {
                left = idx + 1;
            } else if (idx > k) {
                right = idx - 1;
            } else {
                return a[idx];
            }
        }
    }

    private static int partition(int[] a, int left, int right, int pivot) {
        if (left > right) {
            return right;
        }
        int x = a[pivot];
        swap(a, pivot, right);
        int i = left;
        int j = right - 1;
        while (i <= j) {
            while (i <= j && a[i] < x) {
                i++;
            }
            while (i <= j && a[j] > x) {
                j--;
            }
            if (i >= j) {
                break;
            }
            swap(a, i++, j--);
        }
        swap(a, i, right);
        return i;
    }
}
