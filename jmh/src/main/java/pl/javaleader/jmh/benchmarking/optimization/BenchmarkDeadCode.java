package pl.javaleader.jmh.benchmarking.optimization;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class BenchmarkDeadCode {

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    @Fork(value = 1, warmups = 1)
    @Warmup(iterations = 1, time = 1)
    @Measurement(iterations = 1, time = 1, timeUnit = TimeUnit.MICROSECONDS)
    public void  testDeadCodeOne() {
        Supplier<String> supplier = ()-> "javaleader.pl";
        if (supplier == null) {
            throw new IllegalArgumentException("Supplier cannot be null");
        }
        supplier.get();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    @Fork(value = 1, warmups = 1)
    @Warmup(iterations = 1, time = 1)
    @Measurement(iterations = 1, time = 1, timeUnit = TimeUnit.MICROSECONDS)
    public void  testDeadCodeTwo(Blackhole blackhole) {
        Supplier<String> supplier = ()-> "javaleader.pl";
        if (supplier == null) {
            throw new IllegalArgumentException("Supplier cannot be null");
        }
        blackhole.consume(supplier.get());
    }
}