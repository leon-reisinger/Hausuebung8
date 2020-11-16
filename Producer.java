/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.htlgrieskirchen.pos3.pcp;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

public class Producer implements Runnable{
    private final String name;
    private final Storage storage;
    private final int sleepTime;
    
    private final List<Integer> sent;
    private final int numberOfItems;

    public Producer(String name, Storage storage, int sleepTime, int numberOfItems) {
        this.name = name;
        this.storage = storage;
        this.sleepTime = sleepTime;
        sent = new ArrayList<>();
        this.numberOfItems = numberOfItems;
    }

    public List<Integer> getSent() {
        return sent;
    }

    @Override
    public void run() { //Fragen wie das geht 1.3 Aufgabe 
        Storage s;
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
        if(queue.offer(numberOfItems) == true){
            sent.add(numberOfItems);
        }
    }
    
}
