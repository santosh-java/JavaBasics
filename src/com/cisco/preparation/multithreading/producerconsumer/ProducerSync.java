package com.cisco.preparation.multithreading.producerconsumer;

/**
 * Created by MSantoshGiriGovind on 12/13/2016.
 */
public class ProducerSync implements Runnable{
    private PCSharedResource sharedResource;

    public ProducerSync(PCSharedResource sr) {
        this.sharedResource = sr;
    }

    @Override
    public void run() {
        for(int i=1; i<10; i++)
        {
            sharedResource.produce(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " finished");
    }
}
