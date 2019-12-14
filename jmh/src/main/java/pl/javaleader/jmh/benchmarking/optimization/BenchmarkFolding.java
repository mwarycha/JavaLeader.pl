package pl.javaleader.jmh.benchmarking.optimization;

import org.openjdk.jmh.annotations.*;
import pl.javaleader.jmh.benchmarking.optimization.state.thread.Params;
import java.util.concurrent.TimeUnit;

public class BenchmarkFolding {

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    @Fork(value = 1, warmups = 1)
    @Warmup(iterations = 1, time = 1)
    @Measurement(iterations = 1, time = 1, timeUnit = TimeUnit.MICROSECONDS)
    public int testConstantFoldingWithOptimizationOne() {
        int a = 1;
        int b = 2;
        int sum = a + b;
        return sum;
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    @Fork(value = 1, warmups = 1)
    @Warmup(iterations = 1, time = 1)
    @Measurement(iterations = 1, time = 1, timeUnit = TimeUnit.MICROSECONDS)
    public int testConstantFoldingWithoutOptimizationTwo(Params params) {
        int a = params.a;
        int b = params.b;
        int sum = a + b;
        return sum;
    }
}