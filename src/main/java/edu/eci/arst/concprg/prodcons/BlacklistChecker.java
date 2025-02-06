package edu.eci.arst.concprg.prodcons;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class BlacklistChecker {

    private static final int BLACK_LIST_ALARM_COUNT = 5;
    private final List<Integer> blackListOccurrences;
    private final AtomicInteger occurrencesCount = new AtomicInteger(0);
    private final Object lock = new Object();

    public BlacklistChecker(List<Integer> blackListOccurrences) {
        this.blackListOccurrences = blackListOccurrences;
    }

    public boolean isHostReliable(String host, List<Integer> blackListServers) {
        int numThreads = 10;
        int serversPerThread = blackListServers.size() / numThreads;
        Thread[] threads = new Thread[numThreads];

        for (int i = 0; i < numThreads; i++) {
            int start = i * serversPerThread;
            int end = (i == numThreads - 1) ? blackListServers.size() : start + serversPerThread;
            List<Integer> subList = blackListServers.subList(start, end);

            threads[i] = new Thread(() -> {
                for (Integer server : subList) {
                    if (Thread.currentThread().isInterrupted()) {
                        break;
                    }
                    if (checkServerForHost(server, host)) {
                        int currentCount = occurrencesCount.incrementAndGet();
                        synchronized (lock) {
                            if (currentCount >= BLACK_LIST_ALARM_COUNT) {
                                lock.notifyAll();
                                break;
                            }
                        }
                    }
                }
            });
            threads[i].start();
        }

        synchronized (lock) {
            while (occurrencesCount.get() < BLACK_LIST_ALARM_COUNT) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }


        for (Thread thread : threads) {
            thread.interrupt();
        }

        return occurrencesCount.get() < BLACK_LIST_ALARM_COUNT;
    }

    private boolean checkServerForHost(Integer server, String host) {
        return blackListOccurrences.contains(server);
    }
}