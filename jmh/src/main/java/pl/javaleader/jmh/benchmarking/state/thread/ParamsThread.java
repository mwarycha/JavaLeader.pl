package pl.javaleader.jmh.benchmarking.state.thread;

import org.openjdk.jmh.annotations.Scope;
import java.util.HashSet;
import java.util.Set;

import org.openjdk.jmh.annotations.State;

@State(Scope.Thread)
public class ParamsThread {

    public Set<String> threadsId = new HashSet();

    public static final int SMALL_NUMBER = 2;
    public static final int LONG_NUMBER  = 100;

    public synchronized void getThreadsId() {
        System.out.println(threadsId);
    }

    public synchronized void addToSet(String arg){
        threadsId.add(arg);
    }
}