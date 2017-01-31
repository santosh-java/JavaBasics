package com.cisco.preparation.multithreading.executors;

/**
 * Created by MSantoshGiriGovind on 12/15/2016.
 */
public class ExecutorTest {
    public static void main(String[] args) {
        SampleThreadPoolExecutor stpe = new SampleThreadPoolExecutor(3);

        for(int i= 0 ; i < 10; i++)
        {
            try {
                stpe.execute(new Work("Task"+i));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
 
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        stpe.stopPool();
        try {
            stpe.execute(new Work("UnattendedTask"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

class Work implements Runnable {
    private String task;
    public Work(String task) {
        this.task = task;
    }
    @Override
    public void run() {
        System.out.println(this.task + "run by " + Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Finished executing " + this.task);
    }
}
