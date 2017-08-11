package com.company;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Deadlock {

    static Lock lock1 = new ReentrantLock();
    static Lock lock2 = new ReentrantLock();

    static void a() {
        lock1.lock();
        try {
            lock1.wait(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock2.lock();
    }

    static void b() {
        lock2.lock();
        try {
            lock2.wait(3500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock1.lock();
    }

    public static void main(String[] args) {
        new Thread(Deadlock::a).start();
        new Thread(Deadlock::b).start();
    }
}
