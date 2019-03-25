package com.cisco.preparation.multithreading.producerconsumer;

import java.util.concurrent.BlockingQueue;

/**
 * Created by MSantoshGiriGovind on 12/13/2016.
 */
public class Consumer implements Runnable {
    private BlockingQueue<Integer> sharedResource;
    public Consumer(BlockingQueue<Integer> sharedResource) {
        this.sharedResource = sharedResource;
    }
    @Override
    public void run() {
        for(int i=0; i<5; i++){
            try {
                System.out.println(Thread.currentThread().getName() + " consuming " + sharedResource.take());
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " done consuming");
    }
}
