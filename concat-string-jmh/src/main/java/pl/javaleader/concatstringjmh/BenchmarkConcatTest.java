package pl.javaleader.concatstringjmh;

import org.openjdk.jmh.annotations.*;
import java.util.concurrent.TimeUnit;

public class BenchmarkConcatTest {

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    @Fork(value = 1)
    @Warmup(iterations = 3, time = 1)
    @Measurement(iterations = 5, time = 1)
    public String testConcatByStringBuilder() {
        return ConcatString.concatByStringBuilder();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    @Fork(value = 1)
    @Warmup(iterations = 3, time = 1)
    @Measurement(iterations = 5, time = 1)
    public String testConcatByStringBuffer() {
        return ConcatString.concatByStringBuffer();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    @Fork(value = 1)
    @Warmup(iterations = 3, time = 1)
    @Measurement(iterations = 5, time = 1)
    public String testConcatByPlusOperator() {
        return ConcatString.concatByPlusOperator();
    }

}
