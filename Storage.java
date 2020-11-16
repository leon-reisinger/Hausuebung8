/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.htlgrieskirchen.pos3.pcp;

import java.util.concurrent.ArrayBlockingQueue;

public class Storage { 
    private final ArrayBlockingQueue<Integer> queue;
    
    private int fetchedCounter;
    private int storedCounter;
    private int underflowCounter;
    private int overflowCounter;
    private boolean productionComplete;


    public Storage(ArrayBlockingQueue<Integer> queue) {
        this.queue = new ArrayBlockingQueue<>(10);
    }

    public synchronized boolean put(Integer data) throws InterruptedException {
        queue.put(data);
        storedCounter++;
        if(queue.offer(data) == true){
            overflowCounter++;
            return false;
        }
        return true;
    }
 
    public synchronized Integer get() { //FIFO-Prinzip first in, first out
        queue.peek();
        fetchedCounter++;
        if(queue.isEmpty()){
            underflowCounter++;
            return null;
        }
        return fetchedCounter;
    }

    public boolean isProductionComplete() {
        // implement this
        return false;
    }

    public void setProductionComplete(boolean productionComplete) {
        productionComplete = true;
    }


    public int getFetchedCounter() {
        return this.fetchedCounter;
    }

    public int getStoredCounter() {
        return this.storedCounter;
    }

    public synchronized int getUnderflowCounter() {
        return this.underflowCounter;
    }

    public synchronized int getOverflowCounter() {
        return this.overflowCounter;
    }
}
