package com.company;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

    public static void main(String[] args) {

/*        Thread thread = new Thread(() -> System.out.println("hello thread"));
        thread.start();

        Thread thread2 = new Thread(() -> System.out.println(Thread.currentThread().getName()));
        thread2.start();

        Callable<Integer> callable = () -> new Random().nextInt();
        ExecutorService service = Executors.newFixedThreadPool(1);
        Future<Integer> future = service.submit(callable);
        try {
            System.out.println(future.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        service.shutdownNow();*/

        Runnable hello = () -> System.out.println("Hello world");
        Runnable name = () -> System.out.println(Thread.currentThread().getName());
        Callable<Integer> random = () -> new Random().nextInt();

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        executorService.submit(hello);
        executorService.submit(name);
        Future<Integer> future = executorService.submit(random);

        try {
            System.out.println(future.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        Callable<Integer> plusFive = () -> future.get() + 5;
        ExecutorService service = Executors.newFixedThreadPool(1);
        Future<Integer> randPlusFive = service.submit(plusFive);

        try {
            System.out.println(randPlusFive.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        executorService.shutdownNow();
    }
}
