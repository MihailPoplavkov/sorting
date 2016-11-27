package bench;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

/**
 * Created by mihailpoplavkov on 27.11.2016.
 */
public class ben {
    @Benchmark
    public void measureBubbleSort() {
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(ben.class.getSimpleName())
                .forks(1)
                .build();

        new Runner(opt).run();
    }
}
