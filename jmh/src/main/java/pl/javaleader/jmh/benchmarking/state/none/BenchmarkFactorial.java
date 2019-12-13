package pl.javaleader.jmh.benchmarking.state.none;

import org.openjdk.jmh.annotations.*;
import pl.javaleader.jmh.benchmarking.Factorial;

import java.util.concurrent.TimeUnit;

public class BenchmarkFactorial{
 
    private static final int SMALL_NUMBER = 4;
    private static final int LONG_NUMBER  = 100;
 
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    @Fork(value = 1, warmups = 4)
    @Warmup(iterations = 3, time = 1)
    @Measurement(iterations = 5, time = 2)
    public int testFactorialWithLoopForWithSmallNumber() {
        return Factorial.getFactorialFor(SMALL_NUMBER);
    }
 
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    @Fork(value = 1, warmups = 4)
    @Warmup(iterations = 3, time = 1)
    @Measurement(iterations = 5, time = 2)
    public int testFactorialWithRecursiveMethodWithSmallNumber() {
        return Factorial.getFactorialRec(SMALL_NUMBER);
    }
 
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    @Fork(value = 1, warmups = 4)
    @Warmup(iterations = 3, time = 1)
    @Measurement(iterations = 5, time = 2)
    public int testFactorialWithLoopForWithLongNumber() {
        return Factorial.getFactorialFor(LONG_NUMBER);
    }
 
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    @Fork(value = 1, warmups = 4)
    @Warmup(iterations = 3, time = 1)
    @Measurement(iterations = 5, time = 2)
    public int testFactorialWithRecursiveMethodWithLongNumber() {
        return Factorial.getFactorialRec(LONG_NUMBER);
    }
}