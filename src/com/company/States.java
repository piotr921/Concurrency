package com.company;

public class States {

    public static void main(String[] args) {

        //Integer number = new Integer("25");

/*        Thread observable = new Thread(() -> System.out.println("--------------"));

        System.out.println(observable.getState());
        observable.start();
        System.out.println(observable.getState());

        try {
            observable.join(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
            System.out.println(observable.getState());*/

        //-------------WAITING
        Thread waiting = new Thread(() -> {

            Thread waitForMe = new Thread(() -> {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

            waitForMe.start();
            try {
                waitForMe.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        waiting.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(waiting.getState());
    }
}
