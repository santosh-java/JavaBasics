package com.cisco.preparation.multithreading.producerconsumer;

/**
 * Created by MSantoshGiriGovind on 12/13/2016.
 */
public class ProducerConsumerSync {
    public static void main(String[] args){
        PCSharedResource pcr = new PCSharedResource();
        ProducerSync ps = new ProducerSync(pcr);
        ConsumerSync cs = new ConsumerSync(pcr);
//        ConsumerSync cs1 = new ConsumerSync(pcr);

        Thread pst = new Thread(ps, "Producer");
        Thread cst = new Thread(cs, "Consumer 1");
//        Thread cst1 = new Thread(cs1, "Consumer 2");


        cst.start();
//        cst1.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        pst.start();
    }
}
