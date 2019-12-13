package pl.javaleader.jmh.benchmarking.state.benchmark;

import org.openjdk.jmh.annotations.*;
import pl.javaleader.jmh.benchmarking.Factorial;
import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
public class BenchmarkFactorial {
 
    @Param({"4", "100"})
    int param;
 
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    @Fork(value = 1, warmups = 4)
    @Warmup(iterations = 3, time = 1)
    @Measurement(iterations = 5, time = 2)
    public int testFactorialWithLoopForWithSmallNumber() {
        return Factorial.getFactorialFor(param);
    }
 
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    @Fork(value = 1, warmups = 4)
    @Warmup(iterations = 3, time = 1)
    @Measurement(iterations = 5, time = 2)
    public int testFactorialWithRecursiveMethodWithSmallNumber() {
        return Factorial.getFactorialRec(param);
    }
}