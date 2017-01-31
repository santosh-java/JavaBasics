package com.cisco.preparation.multithreading.producerconsumer;

import java.util.concurrent.BlockingQueue;

/**
 * Created by MSantoshGiriGovind on 12/13/2016.
 */
public class Producer implements Runnable {
    private BlockingQueue<Integer> sharedResource;
    public Producer(BlockingQueue<Integer> sharedResource){
        this.sharedResource = sharedResource;
    }
    @Override
    public void run() {
        for(int i = 0; i< 10; i++){
            try {
            	Thread.sleep(1000L);
                sharedResource.put(i);
                System.out.println(Thread.currentThread().getName() + " produced " + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " done producing");
    }
}
