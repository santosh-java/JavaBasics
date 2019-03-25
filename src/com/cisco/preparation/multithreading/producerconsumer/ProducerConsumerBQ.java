package com.cisco.preparation.multithreading.producerconsumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by MSantoshGiriGovind on 12/13/2016.
 */
public class ProducerConsumerBQ {
    public static void main (String args[]){
        BlockingQueue<Integer> sharedResource = new LinkedBlockingQueue<>(1);
        Producer p = new Producer(sharedResource);
        Consumer c = new Consumer(sharedResource);
        Thread pt = new Thread(p, "producer");
        Thread ct1 = new Thread(c, "consumer 1");
        Thread ct2 = new Thread(c, "consumer 2");
        ct1.start();
        ct2.start();
        pt.start();

    }
}
