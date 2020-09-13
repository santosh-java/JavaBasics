package com.cisco.preparation.multithreading.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class ParallelProcessing {
  public static void main(String[] args) {
    System.out.println(Runtime.getRuntime().availableProcessors());
    ReentrantLock r = new ReentrantLock();

    ExecutorService es = Executors.newFixedThreadPool(1);

  }
}
