package bench;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import fast.MergeSort;
import fast.QuickSort;
import fast.ShellSort;
import improved.BinInsertionSort;
import improved.ImprovedQuickSort;
import improved.MergeSortWithoutAdditionalMemory;
import order.statistics.OrderStatistics;
import order.statistics.OrderStatisticsImproved;
import square.InsertionSort;
import util.Helper;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Fork(1)
public class AverageTimeBench {

    int[][] data;
    int[] curr;
    int index;
    static int count = 100000;
    static int maxValue = 1000;

    @Setup(value = Level.Trial)
    public void setUpTrial() {
        data = new int[10][count];
        for (int i = 0; i < 10; i++) {
            data[i] = Helper.gen(count, maxValue);
        }
    }

    @Setup(value = Level.Invocation)
    public void setUpInvocation() {
        curr = Arrays.copyOf(data[index], data[index].length);
        index = (index + 1) % 10;
    }

/*    @Benchmark
    public void measureInsertionSort() {
        InsertionSort.sort(curr);
    }*/

 /*   @Benchmark
    public void measureBinInsertionSort() {
        BinInsertionSort.sort(curr);
    }*/

/*    @Benchmark
    public void measureShellSort() {
        ShellSort.sort(curr);
    }*/

/*    @Benchmark
    public void measureMergeSort() {
        MergeSort.sort(curr);
    }*/

/*    @Benchmark
    public void measureMergeSortWithoutAddMem() {
        MergeSortWithoutAdditionalMemory.sort(curr);
    }*/

/*    @Benchmark
    public void measureQuickSort() {
        QuickSort.sort(curr);
    }*/

/*    @Benchmark
    public void measureImprovedQuickSort() {
        ImprovedQuickSort.sort(curr);
    }*/

/*    @Benchmark
    public void measureFindAllOrderStatistics() {
        for (int i = 0; i < count; i++) {
            OrderStatistics.find(curr, i);
        }
    }*/

/*    @Benchmark
    public void measureFindAllOrderStatisticsImproved() {
        for (int i = 0; i < count; i++) {
            OrderStatisticsImproved.find(curr, i);
        }
    }*/

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(AverageTimeBench.class.getSimpleName())
                .build();

        new Runner(opt).run();
    }
}