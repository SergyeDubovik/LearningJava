package com.epamTasks.fundamentals.multithreading;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadUnionImpl implements ThreadUnion {
    private final String name;
    private final AtomicInteger counter = new AtomicInteger(-1);
    private final List<Thread> threads = Collections.synchronizedList(new ArrayList<>());
    private final List<FinishedThreadResult> results = Collections.synchronizedList(new ArrayList<>());
    private volatile boolean shutdown = false;

    public ThreadUnionImpl(String name) {
        this.name = name;
    }

    @Override
    public int totalSize() {
        return threads.size();
    }

    @Override
    public int activeSize() {
        int count = 0;
        synchronized (threads) {
            for (Thread t : threads) {
                if (t.isAlive()) count++;
            }
        }
        return count;
    }

    @Override
    public void shutdown() {
        shutdown = true;
        synchronized (threads) {
            for (Thread thread : threads) {
                thread.interrupt();
            }
        }
    }

    @Override
    public boolean isShutdown() {
        return shutdown;
    }

    @Override
    public void awaitTermination() {
        synchronized (threads) {
            for (Thread thread : threads) {
                try {
                    thread.join();
                } catch (InterruptedException exception) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    @Override
    public boolean isFinished() {
        if (!shutdown) {
            return false;
        }
        synchronized (threads) {
            for (Thread thread : threads) {
                if (thread.isAlive()) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public List<FinishedThreadResult> results() {
        synchronized (results) {
            return List.copyOf(results);
        }
    }
    @Override
    public Thread newThread(Runnable r) {
        if (shutdown) {
            throw new IllegalStateException("threadUnion is shutdown. cannot create new thread");
        }
        int id = counter.incrementAndGet();
        String threadName = name + "-worker-" + id;
        Runnable wrapper = () -> {
            Throwable throwable = null;
            try {
                r.run();
            } catch (Throwable t) {
                throwable = t;
            } finally {
                results.add(new FinishedThreadResult(Thread.currentThread().getName(), throwable));
            }
        };
        Thread thread = new Thread(wrapper, threadName);
        threads.add(thread);

        return thread;
    }
}
