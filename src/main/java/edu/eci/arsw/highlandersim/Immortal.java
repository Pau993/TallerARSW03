package edu.eci.arsw.highlandersim;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Immortal extends Thread {

    private static final Logger logger = Logger.getLogger(Immortal.class.getName());
    private boolean paused = false;
    private boolean running = true;
    private final Object pauseLock = new Object();
    private final ImmortalUpdateReportCallback updateCallback;
    private int health;
    private final int defaultDamageValue;
    private final List<Immortal> immortals;
    private final String name;
   // private final Random r = new Random(System.currentTimeMillis());

    public void pauseImmortal(){
        synchronized (pauseLock){
            paused = true;
            logger.log(Level.INFO, "{0} paused", name);
        }
    }

    public void resumeImmortal(){
        synchronized (pauseLock){
            paused = false;
            pauseLock.notifyAll();
            logger.log(Level.INFO, "{0} resumed", name);
        }
    }

    public void stopImmortal() {
        running = false;
        resumeImmortal(); // Ensure the thread is not paused when stopping
        logger.log(Level.INFO, "{0} stopped", name);
    }

    public Immortal(String name, List<Immortal> immortalsPopulation, int health, int defaultDamageValue, ImmortalUpdateReportCallback ucb) {
        super(name);
        this.updateCallback=ucb;
        this.name = name;
        this.immortals = immortalsPopulation;
        this.health = health;
        this.defaultDamageValue=defaultDamageValue;
    }

    @Override
    public void run() {
        while (running) {
            synchronized (pauseLock){
                while (paused) {
                    try {
                        pauseLock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            fight();
        }

    }

    public void fight() {
        Immortal opponent = selectOpponent();
        if (opponent != null) {
            Immortal first, second;
            if (System.identityHashCode(this) < System.identityHashCode(opponent)) {
                first = this;
                second = opponent;
            } else {
                first = opponent;
                second = this;
            }

            synchronized (first) {
                synchronized (second) {
                    if (opponent.getHealth() > 0) {
                        opponent.changeHealth(-defaultDamageValue);
                        this.changeHealth(defaultDamageValue);
                        updateCallback.processReport("Fight: " + this + " vs " + opponent + "\n");
                    } else {
                        updateCallback.processReport(this + " says:" + opponent + "is already dead!\n");
                        //immortals.remove(opponent);
                    }
                }
            }
        }
    }

    public boolean isPaused() {
        synchronized (pauseLock) {
            return paused;
        }
    }
    
    private Immortal selectOpponent() {
        Immortal opponent = null;
        int myIndex = immortals.indexOf(this);
        int nextIndex = (myIndex + 1) % immortals.size();
        opponent = immortals.get(nextIndex);
        return opponent;
    }


    public void changeHealth(int v) {
        health += v;
        logger.log(Level.INFO, "{0} health changed by {1}, new health: {2}", new Object[]{name, v, health});
    }

    public int getHealth() {
        return health;
    }

    @Override
    public String toString() {

        return name + "[" + health + "]";
    }

}
