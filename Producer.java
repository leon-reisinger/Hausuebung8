/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.htlgrieskirchen.pos3.pcp;

import java.util.List;

public class Producer /* implement this */ {
    private final String name;
    private final Storage storage;
    private final int sleepTime;
    
    private final List<Integer> sent;
    private final int numberOfItems;

    public Producer(String name, Storage storage, int sleepTime, List<Integer> sent, int numberOfItems) {
        this.name = name;
        this.storage = storage;
        this.sleepTime = sleepTime;
        this.sent = sent;
        this.numberOfItems = numberOfItems;
    }

    public List<Integer> getSent() {
        // implement this
        return null;
    }
    
}
