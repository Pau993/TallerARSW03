package edu.eci.arst.concprg.prodcons;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StartProduction {

    public static void main(String[] args) {
        int stockLimit = 10; // Set the stock limit
        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(stockLimit);

        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);

        producer.start();

        // Let the producer create products for 5 seconds (stock).
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(StartProduction.class.getName()).log(Level.SEVERE, null, ex);
        }

        consumer.start();
    }
}