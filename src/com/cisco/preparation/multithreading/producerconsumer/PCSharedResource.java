package com.cisco.preparation.multithreading.producerconsumer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MSantoshGiriGovind on 12/13/2016.
 */
public class PCSharedResource {
    private final int MAX_CAPACITY = 2;
    private List<Integer> intList = new ArrayList<>();

    public int consume()
    {
        synchronized (this) {
            while (intList.isEmpty()) {
                try {
                    System.out.println(Thread.currentThread().getName() +" waiting");
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        Integer consumedVal = null;
        synchronized (this) {
            consumedVal = intList.remove(0);
            this.notifyAll();
        }

        System.out.println(Thread.currentThread().getName() +" consumed :" + consumedVal);
        return consumedVal;
    }

    public void produce(int producedInt) {
        synchronized (this) {
            while (intList.size() == MAX_CAPACITY) {
                try {
                    System.out.println(Thread.currentThread().getName() +" waiting");
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        synchronized (this)  {
            intList.add(producedInt);
            this.notifyAll();
        }
        System.out.println(Thread.currentThread().getName() +" produced :" + producedInt);
    }
}
