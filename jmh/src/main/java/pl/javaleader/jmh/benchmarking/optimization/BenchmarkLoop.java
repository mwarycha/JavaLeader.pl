package pl.javaleader.jmh.benchmarking.optimization;

import org.openjdk.jmh.annotations.*;
import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
public class BenchmarkLoop {
 
    @Param({"100", "1000", "10000"})
    int param;
 
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    @Fork(value = 1, warmups = 1)
    @Warmup(iterations = 1, time = 1)
    @Measurement(iterations = 1, time = 1, timeUnit = TimeUnit.MICROSECONDS)
    public int testLoop() {
        int sum = 0;
        for (int i = 0; i < param; i++) {
            sum++;
        }
        return sum;
    }
}