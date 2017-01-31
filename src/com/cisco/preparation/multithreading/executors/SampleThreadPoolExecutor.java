package com.cisco.preparation.multithreading.executors;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by MSantoshGiriGovind on 12/15/2016.
 */
public class SampleThreadPoolExecutor {
    private final int maxPoolSize;
    private int currentPoolSize;
    private boolean isStopping = false;
    private BlockingQueue<Runnable> worksToDo;
    private List<Worker> workerThreads;

    public SampleThreadPoolExecutor(int maxPoolSize) {
        this.maxPoolSize = maxPoolSize;
        worksToDo = new LinkedBlockingQueue<>();
        workerThreads = new ArrayList<>(maxPoolSize);
    }

    public synchronized void execute(Runnable work) throws Exception{
        if(!this.isStopping)
            worksToDo.put(work);
        else
            throw new IllegalStateException("Thread pool stopping and cannot accept new work");

        if(currentPoolSize < maxPoolSize)
        {
            Worker workerThread = new Worker(worksToDo, "Worker_"+(++currentPoolSize));
            System.out.println("Worker thread " + workerThread.getName() + " is created.");
            workerThreads.add(workerThread);
            workerThread.start();
        }
    }

    public synchronized void stopPool() {
        System.out.println("stop pool called");
        isStopping = true;
        Iterator<Worker> iterator = workerThreads.iterator();
        while(iterator.hasNext())
        {
            Worker worker = iterator.next();
            worker.doStop();
        }
    }
}

class Worker extends Thread
{
    private BlockingQueue<Runnable> worksToDo;
    private boolean stopped = false;

    public Worker(BlockingQueue<Runnable> worksToDo, String name)
    {
        super(name);
        this.worksToDo = worksToDo;
    }

    @Override
    public void run() {
        while (!isStopped()) {
            try {
                Runnable work = worksToDo.take();
                System.out.println(getName() + " started executing work.");
                work.run();
            } catch (InterruptedException e) {
                //Do Nothing just keep running the thread
                System.out.println(getName() + " thread is interrupted. IsWorkerStopped : " + isStopped());
            }
        }
    }

    public synchronized void doStop() {
        System.out.println(getName() + " is going to stop processing works.");
        this.stopped = true;
        this.interrupt();
    }

    public synchronized boolean isStopped() {
        return stopped;
    }
}
