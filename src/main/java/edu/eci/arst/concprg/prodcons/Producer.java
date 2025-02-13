package edu.eci.arst.concprg.prodcons;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Producer class that produces data and adds it to a BlockingQueue.
 */
public class Producer extends Thread {

    private BlockingQueue<Integer> queue = null;
    private int dataSeed = 0;
    private Random rand = null;

    public Producer(BlockingQueue<Integer> queue) {
        this.queue = queue;
        rand = new Random(System.currentTimeMillis());
    }

    @Override
    public void run() {
        while (true) {
            try {
                dataSeed = dataSeed + rand.nextInt(100);
                System.out.println("Producer added " + dataSeed);
                queue.put(dataSeed); // This will block if the queue is full
                Thread.sleep(1000); // Produce quickly
            } catch (InterruptedException ex) {
                Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}