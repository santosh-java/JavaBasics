package com.cisco.preparation.multithreading.producerconsumer;

/**
 * Created by MSantoshGiriGovind on 12/13/2016.
 */
public class ConsumerSync implements Runnable{

    private PCSharedResource sharedResource;

    public ConsumerSync(PCSharedResource sr) {
        this.sharedResource = sr;
    }

    @Override
    public void run() {
        for(int i=1; i<10; i++)
        {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sharedResource.consume();
        }
        System.out.println(Thread.currentThread().getName() + " finished");
    }
}
