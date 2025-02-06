/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arst.concprg.prodcons;

import java.util.Queue;

/**
 *
 * @author hcadavid
 */
public class Producer extends Thread {

    private Queue<Integer> queue;
    private int stockLimit;

    public Producer(Queue<Integer> queue, int stockLimit) {
        this.queue = queue;
        this.stockLimit=stockLimit;
       // System.err.println(stockLimit);
    
    }

    @Override
    public void run() {
        int count = 0;
        while (true) {
            synchronized(queue){
                if(queue.size() < stockLimit){
                    //System.out.println("limite de stock" + stockLimit);
                    queue.add(count);
                    System.out.println("Producer pructos: " + count);
                    count++;
                }
            }
            
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
