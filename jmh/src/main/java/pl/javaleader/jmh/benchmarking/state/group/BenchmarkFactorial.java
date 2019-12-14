package pl.javaleader.jmh.benchmarking.state.group;

import io.vavr.Tuple;
import org.openjdk.jmh.annotations.*;
import pl.javaleader.jmh.benchmarking.Factorial;
import java.util.concurrent.TimeUnit;

public class BenchmarkFactorial {
 
    @Benchmark
    @GroupThreads(3)
    @Group("g1")
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    @Fork(value = 1, warmups = 1)
    @Warmup(iterations = 0, time = 1)
    @Measurement(iterations = 1, time = 1, timeUnit = TimeUnit.MICROSECONDS)
    public Tuple testFactorialWithLoopForOne(ParamsGroup params) {
        params.addToSet(String.valueOf(Thread.currentThread().getId()) + " [testFactorialWithLoopFor] " + params);
        params.getThreadsId();
        int factorialForSmallNumber = Factorial.getFactorialFor(params.SMALL_NUMBER);
        int factorialForLongNumber  = Factorial.getFactorialFor(params.LONG_NUMBER);
        return Tuple.of(factorialForSmallNumber, factorialForLongNumber);
    }
 
    @Benchmark
    @GroupThreads(3)
    @Group("g1")
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1, warmups = 1)
    @Warmup(iterations = 0, time = 1)
    @Measurement(iterations = 1, time = 1, timeUnit = TimeUnit.MICROSECONDS)
    public Tuple testFactorialWithRecursiveMethodTwo(ParamsGroup params) {
        params.addToSet(String.valueOf(Thread.currentThread().getId() + " [testFactorialWithRecursiveMethod] " + params));
        params.getThreadsId();
        int factorialRecSmallNumber = Factorial.getFactorialRec(params.SMALL_NUMBER);
        int factorialRecLongNumber  = Factorial.getFactorialRec(params.LONG_NUMBER);
        return Tuple.of(factorialRecSmallNumber, factorialRecLongNumber);
    }
}