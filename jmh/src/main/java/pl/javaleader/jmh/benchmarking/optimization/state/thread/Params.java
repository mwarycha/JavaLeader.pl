package pl.javaleader.jmh.benchmarking.optimization.state.thread;

import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

@State(Scope.Thread)
public class Params {
    public int a;
    public int b;
}
