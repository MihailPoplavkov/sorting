package fast;

public class MergeSort {
    public static int[] sort(int[] a) {
        int[] t = new int[a.length];
        split(a, t, 0, a.length - 1);
        return a;
    }

    private static void split(int[] a, int[] t, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            split(a, t, left, mid);
            split(a, t, mid + 1, right);
            merge(a, t, left, mid, right);
        }
    }

    private static void merge(int[] a, int[] t, int left, int mid, int right) {
        int l = left;
        int r = mid + 1;
        for (int i = left; i <= right; i++) {
            if (l > mid) {
                t[i] = a[r++];
            } else if (r > right) {
                t[i] = a[l++];
            } else if (a[l] <= a[r]) {
                t[i] = a[l++];
            } else {
                t[i] = a[r++];
            }
        }
        for (int i = left; i <= right; i++) {
            a[i] = t[i];
        }
    }
}
