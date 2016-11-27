import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import fast.MergeSort;
import fast.QuickSort;
import fast.ShellSort;
import improved.BinInsertionSort;
import improved.ImprovedQuickSort;
import improved.MergeSortWithoutAdditionalMemory;
import order.statistics.OrderStatistics;
import order.statistics.OrderStatisticsImproved;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import square.InsertionSort;
import util.Helper;

@RunWith(value = Parameterized.class)
public class Tester {

    @Rule
    public TestRule watcher = new TestWatcher() {
        protected void starting(final Description description) {
            System.err.println("=== Running " + description.getMethodName());
        }
    };

    @Parameterized.Parameter
    public int[] array;

    @Parameterized.Parameters(name = "{index}")
    public static Collection<int[]> data() {
        return Arrays.asList(new int[][]{
                {0},
                {0, 0, 0, 0},
                {4, 3, 2, 1},
                {0, 1, 1, 0},
                {1},
                {Integer.MAX_VALUE, 0, 0, Integer.MIN_VALUE},
                Helper.gen(1),
                Helper.gen(10),
                Helper.gen(100),
                Helper.gen(1000),
                Helper.gen(10000),
        });
    }

    private boolean isSorted(int[] a) {
        boolean isSorted = true;
        for (int i = 0; i < a.length - 1 && isSorted; i++) {
            isSorted = a[i] <= a[i + 1];
        }
        return isSorted;
    }

    @Test
    public void test01_checkInsertionSort() throws IOException {
        int[] arr = Arrays.copyOf(array, array.length);
        Assert.assertTrue(isSorted(InsertionSort.sort(arr)));
    }

    @Test
    public void test02_checkBinInsertionSort() throws IOException {
        int[] arr = Arrays.copyOf(array, array.length);
        Assert.assertTrue(isSorted(BinInsertionSort.sort(arr)));
    }

    @Test
    public void test03_checkShellSort() throws IOException {
        int[] arr = Arrays.copyOf(array, array.length);
        Assert.assertTrue(isSorted(ShellSort.sort(arr)));
    }

    @Test
    public void test04_checkMergeSort() throws IOException {
        int[] arr = Arrays.copyOf(array, array.length);
        Assert.assertTrue(isSorted(MergeSort.sort(arr)));
    }

    @Test
    public void test05_checkMergeSortWithout() throws IOException {
        int[] arr = Arrays.copyOf(array, array.length);
        Assert.assertTrue(isSorted(MergeSortWithoutAdditionalMemory.sort(arr)));
    }

    @Test
    public void test06_checkQuickSort() throws IOException {
        int[] arr = Arrays.copyOf(array, array.length);
        Assert.assertTrue(isSorted(QuickSort.sort(arr)));
    }

    @Test
    public void test07_checkImprovedQuickSort() throws IOException {
        int[] arr = Arrays.copyOf(array, array.length);
        Assert.assertTrue(isSorted(ImprovedQuickSort.sort(arr)));
    }

    @Test
    public void test08_checkOrderStatistics() throws IOException {
        int[] arr = Arrays.copyOf(array, array.length);
        int[] a = new int[array.length];
        for (int i = 0; i < a.length; i++) {
            a[i] = OrderStatistics.find(arr, i);
        }
        Assert.assertTrue(isSorted(QuickSort.sort(a)));
    }

    @Test
    public void test09_checkOrderStatisticsImproved() throws IOException {
        int[] arr = Arrays.copyOf(array, array.length);
        int[] a = new int[array.length];
        for (int i = 0; i < a.length; i++) {
            a[i] = OrderStatisticsImproved.find(arr, i);
        }
        Assert.assertTrue(isSorted(QuickSort.sort(a)));
    }
}