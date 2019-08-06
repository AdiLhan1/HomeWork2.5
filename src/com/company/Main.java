package com.company;

import java.util.concurrent.CountDownLatch;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(15);
        for (int i = 1; i <= 15; i++) {
            Guide r = new Guide(i, latch);
            r.start();
            Thread.sleep(1000);
        }
        latch.await();
        System.out.println("Все собрались),Выезжаем");
    }
}
