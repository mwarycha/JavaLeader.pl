package pl.javaleader.jmh.benchmarking.state.group;

import org.openjdk.jmh.annotations.Scope;
import java.util.HashSet;
import java.util.Set;

import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.TearDown;

@State(Scope.Group)
public class ParamsGroup {

    public Set<String> threadsId = new HashSet();

    public static final int SMALL_NUMBER = 2;
    public static final int LONG_NUMBER  = 100;

    public synchronized void getThreadsId() {
        System.out.println(threadsId);
    }

    public synchronized void addToSet(String arg){
        threadsId.add(arg);
    }

    @Setup
    public synchronized void setup() {
        System.out.println("run setup " + threadsId);
    }

    @TearDown
    public synchronized void tearDown() {
        System.out.println("run tearDown " + threadsId);
    }
}