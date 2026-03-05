package com.epamTasks.fundamentals.multithreading;

import java.util.List;
import java.util.concurrent.ThreadFactory;

public interface ThreadUnion extends ThreadFactory {
    int totalSize();
    int activeSize();

    void shutdown();
    boolean isShutdown();
    void awaitTermination();
    boolean isFinished();

    List<FinishedThreadResult> results();

    static ThreadUnion newInstance(String name){
        return new ThreadUnionImpl(name);
    }
}
